package com.example.CoreliaTask.service.Impl;

import com.example.CoreliaTask.exception.BadRequestException;
import com.example.CoreliaTask.dto.Token;
import com.example.CoreliaTask.model.User;
import com.example.CoreliaTask.repository.UserRepository;
import com.example.CoreliaTask.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;




    public AuthServiceImpl(UserRepository repository,
                           PasswordEncoder passwordEncoder,
                           JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager=authenticationManager;

    }

    public Token register(User request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByEmail(request.getUsername()).isPresent()) {
            return new Token(null,"User already exist");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setCountry(request.getCountry());
        user = repository.save(user);
        String accessToken = jwtService.generateAccessToken(user);
        return new Token(accessToken,"User registration was successful");

    }
    public Token authenticate(User request) {
        try {authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        }
        catch (BadCredentialsException e){
           throw new BadRequestException("bad credentials");
        }
        User user = repository.findByEmail(request.getUsername()).orElseThrow();
        String accessToken = jwtService.generateAccessToken(user);
        return new Token (accessToken, "User login was successful");

    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = authentication.getName();
            return  repository.findByEmail(currentUserName).orElseThrow(()-> new UsernameNotFoundException("user not found with this email: " +currentUserName));
        }
    }



package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.exception.BadRequestException;
import com.example.OnlineLearningSystem.model.Token;
import com.example.OnlineLearningSystem.model.User;
import com.example.OnlineLearningSystem.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;




    public AuthService(UserRepository repository,
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
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
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
}


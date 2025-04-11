package com.example.CoreliaTask.service;

import com.example.CoreliaTask.dto.Token;
import com.example.CoreliaTask.model.User;

public interface AuthService {
    public Token register(User request);

    public Token authenticate(User request);

    public User getCurrentUser();
}
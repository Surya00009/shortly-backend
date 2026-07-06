package com.shortly.service;

import com.shortly.dto.AuthResponse;
import com.shortly.dto.LoginRequest;
import com.shortly.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}
package com.work.assistant.user.service;

import com.work.assistant.user.dto.LoginRequest;
import com.work.assistant.user.dto.SignUpRequest;
import com.work.assistant.user.dto.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    void signup(SignUpRequest signUpRequest);
    UserResponse login(LoginRequest loginRequest);
}

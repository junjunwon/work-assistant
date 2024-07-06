package com.work.assistant.controller;

import com.work.assistant.security.dto.TokenResponse;
import com.work.assistant.security.jwt.JwtProvider;
import com.work.assistant.security.service.UserDetailsImpl;
import com.work.assistant.user.dto.LoginRequest;
import com.work.assistant.user.dto.SignUpRequest;
import com.work.assistant.user.dto.UserResponse;
import com.work.assistant.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid SignUpRequest signUpRequest) {
        if (!signUpRequest.getPassword().equals(signUpRequest.getPassword2())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        }
        userService.signup(signUpRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest loginRequest, HttpServletResponse response) {
        UserResponse user = userService.login(loginRequest);
        TokenResponse token = jwtProvider.createTokenByLogin(user.getEmail(), user.getRole());
        response.addHeader(JwtProvider.AUTHORIZATION_HEADER, token.getAccessToken());

        return token;
    }

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN','MEMBER')")
    public UserResponse getMyInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return UserResponse.of(userDetails.getUser());
    }

}
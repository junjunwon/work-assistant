package com.work.assistant.user.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.common.exception.ExceptionStatus;
import com.work.assistant.user.dto.LoginRequest;
import com.work.assistant.user.dto.SignUpRequest;
import com.work.assistant.user.dto.UserResponse;
import com.work.assistant.user.entity.User;
import com.work.assistant.user.entity.UserRoleEnum;
import com.work.assistant.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public ResponseEntity signup(SignUpRequest signUpRequest) {
        String email = signUpRequest.getEmail();
        String nickname = signUpRequest.getNickname();
        String password = passwordEncoder.encode(signUpRequest.getPassword());

        //닉네임 중복 확인
        Optional<User> findNickname = userRepository.findByNickname(nickname);
        if (findNickname.isPresent()) {
            throw new CustomException(ExceptionStatus.DUPLICATED_NICKNAME);
        }
        // 이메일 중복 확인
        Optional<User> findEmail = userRepository.findByEmail(email);
        if (findEmail.isPresent()) {
            throw new CustomException(ExceptionStatus.DUPLICATED_EMAIL);
        }
        UserRoleEnum role = UserRoleEnum.MEMBER;
        User user = signUpRequest.toEntity(role, password);

        userRepository.save(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    @Transactional
    public UserResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmail(email).orElseThrow(
            () -> new CustomException(ExceptionStatus.WRONG_EMAIL)
        );
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new CustomException(ExceptionStatus.WRONG_PASSWORD);
        }
        return new UserResponse().of(user);
    }

    public UserResponse getUserInfoByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        return UserResponse.of(user);
    }

    private void hasAuthority(User authUser, Long id) {
        if (!authUser.getRole().equals(UserRoleEnum.ADMIN) && !authUser.getId().equals(id)) {
            throw new IllegalArgumentException("잘못된 접근입니다.");
        }
    }
}


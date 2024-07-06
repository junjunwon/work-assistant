package com.work.assistant.user.dto;

import com.work.assistant.user.entity.User;
import com.work.assistant.user.entity.UserRoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@PasswordAndIdCheck(userEmail = "email", password = "password")
public class SignUpRequest {

    // 정규식이 틀렸을때 발생하는 예외 MethodArgumentNotValidException
    @Email
    private final String email;

    @Pattern(regexp = "[a-zA-Z0-9]{4,8}$", message = "닉네임은 최소 4자 이상, 8자 이하이며, 영문과 숫자만 입력하세요.")
    private final String nickname;

    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()+|=])^[a-zA-Z0-9~!@#$%^&*()+|=]{15,30}$", message = "비밀번호는 최소 15자 이상, 30자 이하이며, 영문 대소문자, 숫자, 특수문자룰 포함하여 입력하세요.")
    private final String password;

    @Pattern(regexp = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[~!@#$%^&*()+|=])^[a-zA-Z0-9~!@#$%^&*()+|=]{15,30}$", message = "비밀번호를 확인해주세요.")
    private final String password2;

    @Builder
    public SignUpRequest(String email, String nickname, String password, String password2) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.password2 = password2;
    }

    public User toEntity(UserRoleEnum role, String encodedPassword) {
        return User.builder()
            .nickname(nickname)
            .email(email)
            .password(encodedPassword)
            .role(role)
            .build();
    }
}

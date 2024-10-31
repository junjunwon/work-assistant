package com.work.assistant.user.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.common.exception.ExceptionStatus;
import com.work.assistant.repository.jpa.UserRepository;
import com.work.assistant.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDAOServiceImpl implements UserDAOService {

    private final UserRepository userRepository;

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new CustomException(ExceptionStatus.WRONG_EMAIL));
    }

    @Override
    public void validateByNickname(String nickname) {
        userRepository.existsByNickname(nickname).orElseThrow(
                () -> new CustomException(ExceptionStatus.SIGNUP_WRONG_USERNAME));
    }

    @Override
    public void validateByEmail(String email) {
        userRepository.existsByEmail(email).orElseThrow(
                () -> new CustomException(ExceptionStatus.WRONG_EMAIL));
    }
}

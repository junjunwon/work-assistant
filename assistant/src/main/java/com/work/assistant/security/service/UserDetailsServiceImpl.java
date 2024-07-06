package com.work.assistant.security.service;

import com.work.assistant.common.exception.CustomException;
import com.work.assistant.common.exception.ExceptionStatus;
import com.work.assistant.user.entity.User;
import com.work.assistant.repository.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = findByUserEmail(email);
        return new UserDetailsImpl(user, user.getEmail());
    }

    private User findByUserEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
            () -> new CustomException(ExceptionStatus.WRONG_EMAIL)
        );
    }
}

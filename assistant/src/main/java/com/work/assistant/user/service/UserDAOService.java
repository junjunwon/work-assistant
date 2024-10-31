package com.work.assistant.user.service;

import com.work.assistant.user.entity.User;

public interface UserDAOService {
    User getByEmail(String email);
    void validateByNickname(String nickname);
    void validateByEmail(String email);
}

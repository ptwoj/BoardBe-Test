package com.example.board_test.domain.request;

import com.example.board_test.domain.entity.UserEntity;

public record SignupRequest(
        String email,
        String pw,
        String username) {

    public UserEntity toEntity(){
        return UserEntity.builder()
                .email(email)
                .pw(pw)
                .build();
    }
}

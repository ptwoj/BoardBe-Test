package com.example.board_test.domain.request;

import com.example.board_test.domain.entity.BoardEntity;
import com.example.board_test.domain.entity.UserEntity;

public record BoardRequest(
        Long userId,
        String text) {

    public BoardEntity toEntity(){
        return BoardEntity.builder()
                .user(UserEntity.builder().userId(userId).build())
                .text(text)
                .build();
    }
}

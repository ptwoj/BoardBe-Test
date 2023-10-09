package com.example.board_test.domain.response;

import com.example.board_test.domain.dto.UserDto;
import com.example.board_test.domain.entity.UserEntity;

public class UserResponse extends UserDto {

    public UserResponse(UserEntity user){
        super(user);
    }
}

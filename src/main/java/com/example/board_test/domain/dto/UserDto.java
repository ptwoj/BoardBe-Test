package com.example.board_test.domain.dto;


import com.example.board_test.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserDto {
    public Long userId;
    private String email;
    private String username;
    private String pw;

    public UserDto(UserEntity user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }

    public UserDto(){

    }
}

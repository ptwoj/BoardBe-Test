package com.example.board_test.service;

import com.example.board_test.domain.entity.UserEntity;
import com.example.board_test.domain.request.LoginRequest;
import com.example.board_test.domain.request.SignupRequest;
import com.example.board_test.domain.response.LoginResponse;
import com.example.board_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signup(SignupRequest request) {

        UserEntity newUser = UserEntity.builder()
                .email(request.email())
                .username(request.username())
                .pw(request.pw())
                .build();
        userRepository.findByEmail(newUser.getEmail()).ifPresentOrElse(
                user -> {
                    throw new IllegalArgumentException("이미 사용 중입니다.");
                },
                () -> {
                    userRepository.save(newUser);
                }
        );
    }

    public LoginResponse login(LoginRequest request) {
        String email = request.email();
        String pw = request.pw();

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 일치하지 않습니다."));

        if (!user.getPw().equals(pw)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        LoginResponse response = new LoginResponse(user.getEmail(), user.getPw());
        return response;
    }
}

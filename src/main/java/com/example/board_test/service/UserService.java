package com.example.board_test.service;

import com.example.board_test.domain.entity.BoardEntity;
import com.example.board_test.domain.entity.UserEntity;
import com.example.board_test.domain.request.LoginRequest;
import com.example.board_test.domain.request.SignupRequest;
import com.example.board_test.domain.response.BoardResponse;
import com.example.board_test.domain.response.LoginResponse;
import com.example.board_test.domain.response.UserResponse;
import com.example.board_test.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    //회원가입 로직
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

    //로그인 로직
    public LoginResponse login(LoginRequest request, HttpServletResponse response) {
        String email = request.email();
        String pw = request.pw();

        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 일치하지 않습니다."));

        if (!user.getPw().equals(pw)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        LoginResponse loginResponse = new LoginResponse(user.getEmail(), user.getPw());
        return loginResponse;
    }
    
    //모든 정보
    public List<UserResponse> findAll(){
        List<UserEntity> all = userRepository.findAll();
        return all.stream().map(UserResponse::new).toList();
    }
}
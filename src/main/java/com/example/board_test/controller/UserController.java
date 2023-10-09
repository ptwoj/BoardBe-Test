package com.example.board_test.controller;

import com.example.board_test.domain.request.LoginRequest;
import com.example.board_test.domain.request.SignupRequest;
import com.example.board_test.domain.response.LoginResponse;
import com.example.board_test.domain.response.UserResponse;
import com.example.board_test.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j @RequiredArgsConstructor
@RequestMapping("api/v1/users")
@CrossOrigin("*")
public class UserController {
    private final UserService service;

    //회원가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(
            @RequestBody SignupRequest request){
        service.signup(request);
    }

    
    //로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request, HttpServletResponse response){
        LoginResponse loginResponse = service.login(request, response);
        return ResponseEntity.ok(loginResponse);
    }

    // 사용자 정보 조회
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> responses = service.findAll();
        return ResponseEntity.ok(responses);
    }
}

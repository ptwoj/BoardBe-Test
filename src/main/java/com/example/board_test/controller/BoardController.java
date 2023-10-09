package com.example.board_test.controller;

import com.example.board_test.domain.request.BoardRequest;
import com.example.board_test.domain.response.BoardResponse;
import com.example.board_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j @RequiredArgsConstructor
@RequestMapping("api/v1/boards")
@CrossOrigin("*")

public class BoardController {
    private final BoardService service;
    
    //게시물 작성
    @PostMapping("/insert")
    public void insert(@RequestBody BoardRequest request){
        service.insert(request);
    }

    //게시물 정보
    @GetMapping("/insert")
    public List<BoardResponse> findAll(){
        return service.findAll();
    }
}

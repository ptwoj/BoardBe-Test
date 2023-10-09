package com.example.board_test.service;

import com.example.board_test.domain.entity.BoardEntity;
import com.example.board_test.domain.request.BoardRequest;
import com.example.board_test.domain.response.BoardResponse;
import com.example.board_test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    //모든 게시물 조회 로직
    public List<BoardResponse> findAll(){
        List<BoardEntity> all = boardRepository.findAll();
        return all.stream().map(BoardResponse::new).toList();
    }
    
    //게시물 작성 로직
    public void insert(BoardRequest request){
        BoardEntity board = request.toEntity();
        boardRepository.save(board);
    }
}

package com.example.board_test.repository;

import com.example.board_test.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository
        extends JpaRepository<BoardEntity, Long> {
}

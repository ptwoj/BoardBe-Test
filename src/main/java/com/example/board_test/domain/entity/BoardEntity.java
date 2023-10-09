package com.example.board_test.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Entity @Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "boards")
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, name = "text")
    private String text;

//    @Column(name = "board_like", columnDefinition = "INT default 0")
//    private Integer like;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;


}

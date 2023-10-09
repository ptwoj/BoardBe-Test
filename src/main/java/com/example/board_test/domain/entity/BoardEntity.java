package com.example.board_test.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, name = "text")
    private String text;

    @Column(name = "like", columnDefinition = "INT default 0")
    private Integer like;

    @ManyToOne
//    @JoinColumn(name = "userId")
    private UserEntity user;


}

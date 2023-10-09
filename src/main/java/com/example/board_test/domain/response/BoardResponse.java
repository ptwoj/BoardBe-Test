package com.example.board_test.domain.response;


import com.example.board_test.domain.entity.BoardEntity;
import com.example.board_test.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder @Getter
public class BoardResponse {
    private Long boardId;
    private String text;

    public BoardResponse(BoardEntity board) {
        this.boardId = board.getBoardId();
        this.text = board.getText();
    }


    @Getter
    class UserBoard{
        private Long userId;
        private String email;
        private String username;

        public UserBoard(UserEntity user) {
            this.userId = user.getUserId();
            this.email = user.getEmail();
            this.username = user.getUsername();
        }
    }
}

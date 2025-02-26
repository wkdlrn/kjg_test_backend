package com.example.back.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {
    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class RegisterReq {
        private String title;
        private String content;
        private String writer;
        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .writer(writer)
                    .build();
        }
    }
    @Getter @Builder @AllArgsConstructor @NoArgsConstructor
    public static class RegisterResp {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        public static RegisterResp fromEntity(Board board) {
            return RegisterResp.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .build();
        }
    }
}

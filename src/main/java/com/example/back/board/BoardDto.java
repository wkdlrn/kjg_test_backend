package com.example.back.board;

import com.example.back.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

public class BoardDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
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

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CommentRegister {
        private String writer;
        private String content;

        public Comment toEntity(Board board) {
            return Comment.builder()
                    .writer(writer)
                    .content(content)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterResp {
        private Long idx;
        private String title;
        private String content;
        private String writer;
        private List<CommentResp> comments;

        public static RegisterResp fromEntity(Board board) {
            return RegisterResp.builder()
                    .idx(board.getIdx())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .comments(board.getComments().stream()
                            .map(CommentResp::fromEntity)
                            .collect(Collectors.toList()))
                    .build();
        }
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CommentResp {
        private Long idx;
        private String writer;
        private String content;

        public static CommentResp fromEntity(Comment comment) {
            return CommentResp.builder()
                    .idx(comment.getIdx())
                    .writer(comment.getWriter())
                    .content(comment.getContent())
                    .build();
        }
    }
}

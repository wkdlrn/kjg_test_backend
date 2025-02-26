package com.example.back.board;

import com.example.back.comment.Comment;
import com.example.back.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    public BoardDto.RegisterResp register (BoardDto.RegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());

        return BoardDto.RegisterResp.fromEntity(board);
    }

    public BoardDto.RegisterResp read (Long idx) {
        return BoardDto.RegisterResp.fromEntity(boardRepository.findById(idx).orElseThrow());
    }

    public List<BoardDto.ListResp> readAll() {
        return boardRepository.findAll().stream()
                .map(BoardDto.ListResp::fromEntity).collect(Collectors.toList());
    }
    public void commentRegister(Long boardIdx, BoardDto.CommentRegister dto) {
        Board board = boardRepository.findById(boardIdx).orElseThrow();

        Comment comment = Comment.builder()
                .board(board)
                .writer(dto.getWriter())
                .content(dto.getContent())
                .build();

        commentRepository.save(comment);
    }
}
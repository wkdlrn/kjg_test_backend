package com.example.back.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardDto.RegisterResp register (BoardDto.RegisterReq dto) {
        Board board = boardRepository.save(dto.toEntity());

        return BoardDto.RegisterResp.fromEntity(board);
    }

    public BoardDto.RegisterResp read (Long idx) {
        return BoardDto.RegisterResp.fromEntity(boardRepository.findById(idx).orElseThrow());
    }

    public List<BoardDto.RegisterResp> readAll() {
        return boardRepository.findAll().stream()
                .map(BoardDto.RegisterResp::fromEntity).collect(Collectors.toList());
    }
}

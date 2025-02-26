package com.example.back.board;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<BoardDto.RegisterResp> register(@RequestBody BoardDto.RegisterReq dto) {
        return ResponseEntity.ok(boardService.register(dto));
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.RegisterResp> read(@PathVariable Long idx) {
        return ResponseEntity.ok(boardService.read(idx));
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListResp>> list() {
        return ResponseEntity.ok(boardService.readAll());
    }
}

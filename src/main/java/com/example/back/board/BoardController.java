package com.example.back.board;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @Operation(summary = "게시글 등록", description = "게시글을 등록하는 기능입니다.")
    @PostMapping("/register")
    public ResponseEntity<BoardDto.RegisterResp> register(@RequestBody BoardDto.RegisterReq dto) {
        return ResponseEntity.ok(boardService.register(dto));
    }

    @Operation(summary = "게시글 조회", description = "특정 게시글을 조회하는 기능입니다.")
    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.RegisterResp> read(@PathVariable Long idx) {
        return ResponseEntity.ok(boardService.read(idx));
    }

    @Operation(summary = "게시글 조회", description = "모든 게시글을 조회하는 기능입니다.")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.ListResp>> list() {
        return ResponseEntity.ok(boardService.readAll());
    }

    @Operation(summary = "댓글 등록", description = "댓글을 등록하는 기능입니다.")
    @PostMapping("/{idx}/comment")
    public ResponseEntity<String> commentRegister(@PathVariable Long idx, @RequestBody BoardDto.CommentRegister request) {
        boardService.commentRegister(idx, request);
        return ResponseEntity.ok(new String("댓글이 등록되었습니다."));
    }


}
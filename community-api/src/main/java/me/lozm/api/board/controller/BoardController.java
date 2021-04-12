package me.lozm.api.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.lozm.api.board.service.BoardService;
import me.lozm.domain.board.dto.BoardDto;
import me.lozm.global.code.BoardType;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"게시판"})
@CrossOrigin
@RequestMapping("board")
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @ApiOperation("게시판 목록 조회")
    @GetMapping("boardType/{boardType}")
    public BoardDto.ResponseList getBoardList(@PathVariable("boardType") BoardType boardType, Pageable pageable) {

        return BoardDto.ResponseList.createBoardList(boardService.getBoardList(boardType, pageable));
    }

    @ApiOperation("게시판 상세 조회")
    @GetMapping("{boardId}")
    public BoardDto.ResponseOne getBoardDetail(@PathVariable("boardId") Long boardId) {

        return BoardDto.ResponseOne.from(boardService.getBoardDetail(boardId));
    }

    @ApiOperation("게시판 추가")
    @PostMapping
    public BoardDto.ResponseOne addBoard(@RequestBody @Valid BoardDto.AddRequest requestDto) {

        return BoardDto.ResponseOne.from(boardService.addBoard(requestDto));
    }

    @ApiOperation("게시판 수정")
    @PutMapping
    public BoardDto.ResponseOne editBoard(@RequestBody @Valid BoardDto.EditRequest requestDto) {

        return BoardDto.ResponseOne.from(boardService.editBoard(requestDto));
    }

    @ApiOperation("게시판 삭제")
    @DeleteMapping("{boardId}")
    public BoardDto.ResponseOne removeBoard(@PathVariable("boardId") Long boardId) {

        return BoardDto.ResponseOne.from(boardService.removeBoard(boardId));
    }

}

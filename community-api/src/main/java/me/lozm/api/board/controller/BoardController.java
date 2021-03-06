package me.lozm.api.board.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.lozm.api.board.service.BoardService;
import me.lozm.domain.board.dto.BoardDto;
import me.lozm.global.code.BoardType;
import me.lozm.global.object.dto.PageDto;
import me.lozm.global.object.dto.SearchDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = {"게시판"})
@RequestMapping("board")
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @ApiOperation("게시판 목록 조회")
    @GetMapping("boardType/{boardType}")
    public BoardDto.BoardList getBoardList(@PathVariable("boardType") BoardType boardType, PageDto pageDto, SearchDto searchDto) {
        return boardService.getBoardList(boardType, pageDto.getPageRequest(), searchDto);
    }

    @ApiOperation("게시판 상세 조회")
    @GetMapping("{boardId}")
    public BoardDto.BoardInfo getBoardDetail(@PathVariable("boardId") Long boardId) {
        return boardService.getBoardDetail(boardId);
    }

    @ApiOperation("신규 게시판 추가")
    @PostMapping
    public BoardDto.BoardInfo addBoard(@RequestBody @Valid BoardDto.AddRequest requestDto) {
        return boardService.addBoard(requestDto);
    }

    @ApiOperation("게시판 답글 추가")
    @PostMapping("reply")
    public BoardDto.BoardInfo addReplyBoard(@RequestBody @Valid BoardDto.AddReplyRequest requestDto) {
        return boardService.addReplyBoard(requestDto);
    }

    @ApiOperation("게시판 수정")
    @PutMapping("{boardId}")
    public BoardDto.BoardInfo editBoard(@PathVariable("boardId") Long boardId, @RequestBody @Valid BoardDto.EditRequest requestDto) {
        return boardService.editBoard(requestDto);
    }

    @ApiOperation("게시판 삭제")
    @DeleteMapping("{boardId}/user/{userId}")
    public BoardDto.BoardInfo removeBoard(@PathVariable("boardId") Long boardId, @PathVariable("userId") Long userId) {
        return boardService.removeBoard(boardId, userId);
    }

}

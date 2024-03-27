package whitekim.mybatisblog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public Board findById(@PathVariable("id") Long id) {
        return boardService.findById(id);
    }

    @PostMapping
    public String save(@RequestBody Board board) {
        boardService.save(board);

        return "성공";
    }

    @PostMapping("/update")
    public String update(@RequestBody Board board) {
        boardService.update(board);

        return "성공";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.deleteById(id);

        return "성공";
    }
}

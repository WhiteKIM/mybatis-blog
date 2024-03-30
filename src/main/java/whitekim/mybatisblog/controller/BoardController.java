package whitekim.mybatisblog.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.service.BoardService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public Board findById(@PathVariable("id") Long id) {
        Board findBoard = boardService.findById(id);
        System.out.println("findBoard = " + findBoard);
        return findBoard;
    }

    @PostMapping
    public void save(@ModelAttribute Board board, HttpServletResponse response) throws IOException {
        boardService.save(board);
        response.sendRedirect("/");
    }

    @PostMapping("/update")
    public void update(@ModelAttribute Board board, HttpServletResponse response) throws IOException {
        boardService.update(board);
        response.sendRedirect("/");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, HttpServletResponse response) throws IOException {
        boardService.deleteById(id);
        response.sendRedirect("/");
    }
}

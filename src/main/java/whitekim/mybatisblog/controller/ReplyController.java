package whitekim.mybatisblog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.model.Reply;
import whitekim.mybatisblog.service.BoardService;
import whitekim.mybatisblog.service.ReplyService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final BoardService boardService;

    @GetMapping
    public List<Reply> findAll() {
        return replyService.findAll();
    }

    @GetMapping("/{id}")
    public Reply findById(@PathVariable("id") Long id) {
        return replyService.findById(id);
    }

    @PostMapping
    public String save(@ModelAttribute Reply reply, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String[] refers = request.getHeader("Referer").split("/");
        Board targetBoard = boardService.findById(Long.valueOf(refers[4]));
        reply.setBoard(targetBoard);
        replyService.save(reply);
        response.sendRedirect(request.getHeader("Referer"));
        return "성공";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Reply reply) {
        replyService.update(reply);

        return "성공";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        replyService.deleteById(id);

        return "성공";
    }
}

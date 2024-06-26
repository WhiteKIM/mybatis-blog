package whitekim.mybatisblog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.service.BoardService;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BoardService boardService;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "member/MemberLogin";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "member/MemberRegister";
    }

    @GetMapping("/category/{category}")
    public String list(
            @PathVariable String category,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            Model model) {

        model.addAttribute("page", boardService.count()/10);
        model.addAttribute("boardList", boardService.findAll(page, size));
        return "board/BoardList";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/BoardWrite";
    }

    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable Long id, Model model) {
        Board findBoard = boardService.findById(id);
        System.out.println("findBoard = " + findBoard);
        model.addAttribute("board", findBoard);
        return "board/BoardDetail";
    }

    @GetMapping("/update/{id}")
    public String updateFomr(@PathVariable Long id, Model model) {
        Board findBoard = boardService.findById(id);
        model.addAttribute("board", findBoard);
        return "board/BoardUpdate";
    }
}

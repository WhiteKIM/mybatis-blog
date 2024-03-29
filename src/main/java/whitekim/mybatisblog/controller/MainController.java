package whitekim.mybatisblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

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
    public String list(@PathVariable String category) {
        return "board/BoardList";
    }

    @GetMapping("/write")
    public String writeForm() {
        return "board/BoardWrite";
    }
}

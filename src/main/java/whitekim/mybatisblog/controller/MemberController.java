package whitekim.mybatisblog.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import whitekim.mybatisblog.model.Member;
import whitekim.mybatisblog.service.MemberService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable("id") Long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public String save(@RequestBody Member member) {
        memberService.save(member);

        return "성공";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Member loginMember, HttpServletResponse response, HttpServletRequest request) throws IOException {
        memberService.login(loginMember, response, request);

        response.sendRedirect("/");
        return "로그인 성공";
    }

    @PostMapping("/update")
    public String update(@RequestBody Member member) {
        memberService.update(member);

        return "성공";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        memberService.deleteById(id);

        return "성공";
    }
}

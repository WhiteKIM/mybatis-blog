package whitekim.mybatisblog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import whitekim.mybatisblog.model.Reply;
import whitekim.mybatisblog.service.ReplyService;

import java.util.List;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping
    public List<Reply> findAll() {
        return replyService.findAll();
    }

    @GetMapping("/{id}")
    public Reply findById(@PathVariable("id") Long id) {
        return replyService.findById(id);
    }

    @PostMapping
    public String save(@RequestBody Reply member) {
        replyService.save(member);

        return "성공";
    }

    @PostMapping("/update")
    public String update(@RequestBody Reply member) {
        replyService.update(member);

        return "성공";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        replyService.deleteById(id);

        return "성공";
    }
}

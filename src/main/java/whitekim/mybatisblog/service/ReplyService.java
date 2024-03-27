package whitekim.mybatisblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whitekim.mybatisblog.model.Reply;
import whitekim.mybatisblog.repository.ReplyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    public void save(Reply reply) {
        replyRepository.save(reply);
    }
    public Reply findById(Long id) {
        return replyRepository.findById(id);
    }
    public List<Reply> findAll() {
        return replyRepository.findAll();
    }
    public void update(Reply reply) {
        replyRepository.update(reply);
    }
    public void deleteById(Long id) {
        replyRepository.deleteById(id);
    }
}

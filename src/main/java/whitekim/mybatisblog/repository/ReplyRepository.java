package whitekim.mybatisblog.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.model.Reply;

import java.util.List;

@Repository
public interface ReplyRepository {

    void save(Reply reply);
    Reply findById(Long id);
    List<Reply> findAll();
    void update(Reply reply);
    void deleteById(Long id);
}

package whitekim.mybatisblog.repository;

import org.springframework.stereotype.Repository;
import whitekim.mybatisblog.model.Board;

import java.util.List;

@Repository
public interface BoardRepository {

    void save(Board board);
    Board findById(Long id);
    List<Board> findAll();
    void update(Board board);
    void deleteById(Long id);
}

package whitekim.mybatisblog.repository;

import org.springframework.stereotype.Repository;
import whitekim.mybatisblog.dto.request.BoardRequestDto;
import whitekim.mybatisblog.model.Board;

import java.util.HashMap;
import java.util.List;

@Repository
public interface BoardRepository {

    void save(BoardRequestDto board);
    Board findById(Long id);
    List<Board> findAll(HashMap<String, Integer> param);
    void update(BoardRequestDto board);
    void deleteById(Long id);
    int count();
}

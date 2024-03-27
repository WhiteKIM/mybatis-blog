package whitekim.mybatisblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }
    public Board findById(Long id) {
        return boardRepository.findById(id);
    }
    public List<Board> findAll() {
        return boardRepository.findAll();
    }
    public void update(Board board) {
        boardRepository.update(board);
    }
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}

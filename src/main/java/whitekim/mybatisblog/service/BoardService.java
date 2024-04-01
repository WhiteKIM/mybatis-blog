package whitekim.mybatisblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import whitekim.mybatisblog.dto.request.BoardRequestDto;
import whitekim.mybatisblog.model.Board;
import whitekim.mybatisblog.repository.BoardRepository;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final ImageService imageService;

    public void save(BoardRequestDto board) {
        Long imageId = imageService.save(board.getImage());
        board.setImageId(imageId);
        boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Board> findAll(int page, int size) {
        HashMap<String, Integer> param = new HashMap<>();
        int offset = size;
        int limit = (offset * page) - offset;
        param.put("offset", offset);
        param.put("limit", limit);

        return boardRepository.findAll(param);
    }

    public void update(BoardRequestDto board) {
        boardRepository.update(board);
    }
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }

    public int count() {
        return boardRepository.count();
    }
}

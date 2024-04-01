package whitekim.mybatisblog.dto.response;

import lombok.Data;
import whitekim.mybatisblog.model.Board;

import java.util.List;

@Data
public class PagingBoardResponseDto {
    private int page;
    private int size;
    private int totalCount;
    private List<Board> boardList;


    private boolean isPrev;
    private boolean isNext;

    public PagingBoardResponseDto(int page, int size, int totalCount, List<Board> boardList) {
        this.page = page;
        this.size = size;
        this.totalCount = totalCount;
        this.boardList = boardList;
    }
}

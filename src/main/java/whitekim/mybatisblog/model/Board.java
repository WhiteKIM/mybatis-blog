package whitekim.mybatisblog.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Board {

    private Long id;
    private String title;
    private String content;

    private Member author;
    private List<Reply> replyList = new ArrayList<>();

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

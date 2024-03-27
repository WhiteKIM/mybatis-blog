package whitekim.mybatisblog.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Board {

    private Long id;
    private String title;
    private String content;

    private Member author;
    private List<Reply> replyList;

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

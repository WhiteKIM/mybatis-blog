package whitekim.mybatisblog.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class Reply {
    private Long id;
    private String message;

    private String member;
    private Board board;

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

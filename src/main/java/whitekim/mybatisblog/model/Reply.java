package whitekim.mybatisblog.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reply {
    private Long id;
    private String message;
    private Member member;
    private Board board;

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

package whitekim.mybatisblog.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Member {

    private Long id;
    private String username;
    private String password;
    private String nickname;

    private List<Board> boardList;
    private List<Reply> replyList;

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

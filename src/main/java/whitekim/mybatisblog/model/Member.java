package whitekim.mybatisblog.model;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Member {

    private Long id;
    private String username;
    private String password;
    private String nickname;

    private List<Board> boardList = new ArrayList<>();
    private List<Reply> replyList = new ArrayList<>();

    private LocalDateTime atCreatedTime;
    private LocalDateTime atUpdatedTime;

    private boolean isDeleted;
}

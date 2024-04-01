package whitekim.mybatisblog.dto.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BoardRequestDto {
    private String title;
    private String content;
    private Long authorId;
    private Long imageId;
    private MultipartFile image;
}

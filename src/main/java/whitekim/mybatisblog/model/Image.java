package whitekim.mybatisblog.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Image {
    private Long id;
    private String originalFileName;
    private String fileName;
    private String filepath;

    private LocalDateTime atCreatedTime;
}

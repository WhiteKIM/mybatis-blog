package whitekim.mybatisblog.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Image {
    private Long id;
    private String originalFilename;
    private String filename;
    private String filepath;

    private LocalDateTime atCreatedTime;
}

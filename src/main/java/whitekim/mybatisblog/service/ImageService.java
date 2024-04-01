package whitekim.mybatisblog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import whitekim.mybatisblog.model.Image;
import whitekim.mybatisblog.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;

    public Image getImageById(Long id) {
        return imageRepository.getImageById(id);
    }

    public Long save(MultipartFile multipartFile) {
        String osName = System.getProperty("os.name").toLowerCase();
        String uploadPath = "./upload/";

        if (osName.contains("win")) {
            uploadPath = "C:/upload/";
        }

        uploadPath += LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+"/";

        String prefix = multipartFile.getOriginalFilename().substring(
                multipartFile.getOriginalFilename().lastIndexOf(".") + 1
        );

        String filename = UUID.randomUUID() +"."+prefix;
        String pathname = uploadPath + filename;
        File file = new File(pathname);
        File folder = new File(uploadPath);
        System.out.println("pathname : "+pathname);
        if(!folder.isDirectory()) {
            folder.mkdirs();
        }

        try {
            multipartFile.transferTo(file);
            Image image = new Image();
            image.setFilename(filename);
            image.setFilepath(pathname);
            image.setOriginalFilename(multipartFile.getOriginalFilename());
            return imageRepository.save(image);

        } catch (IOException ie) {
            throw new RuntimeException();
        }
    }
}

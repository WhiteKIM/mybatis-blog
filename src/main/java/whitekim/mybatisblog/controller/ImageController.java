package whitekim.mybatisblog.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import whitekim.mybatisblog.model.Image;
import whitekim.mybatisblog.service.ImageService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping(("/api/image"))
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{id}")
    public void getImage(@PathVariable Long id, HttpServletResponse response) {
        Image image = imageService.getImageById(id);
        File file = new File(image.getFilepath());

        if(!file.isFile()) {
            throw new IllegalStateException();
        }

        try {
            response.setContentType(MediaType.IMAGE_PNG_VALUE);
            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

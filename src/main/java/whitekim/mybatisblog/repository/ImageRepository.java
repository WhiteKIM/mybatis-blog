package whitekim.mybatisblog.repository;

import org.springframework.stereotype.Repository;
import whitekim.mybatisblog.model.Image;

@Repository
public interface ImageRepository {
    Image getImageById(Long id);
    Long save(Image image);
}

package whitekim.mybatisblog.global.entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BaseEntity<T> {
    T data;
    String message;
    HttpStatus status;
}

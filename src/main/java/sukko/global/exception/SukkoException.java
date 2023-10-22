package sukko.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SukkoException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    public SukkoException() {
        CustomExceptionType customExceptionType = CustomExceptionType.of(this.getClass());
        this.message = customExceptionType.getMessage();
        this.httpStatus = customExceptionType.getHttpStatus();
    }
}

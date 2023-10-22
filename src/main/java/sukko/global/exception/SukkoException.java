package sukko.global.exception;

import org.springframework.http.HttpStatus;

public class SukkoException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public SukkoException() {
        CustomExceptionType customExceptionType = CustomExceptionType.of(this.getClass());
        this.message = customExceptionType.getMessage();
        this.httpStatus = customExceptionType.getHttpStatus();
    }
}

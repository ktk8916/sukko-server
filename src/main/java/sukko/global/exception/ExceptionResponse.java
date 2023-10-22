package sukko.global.exception;

import org.springframework.http.HttpStatus;

public record ExceptionResponse(
        HttpStatus code,
        String message
) {

    public static ExceptionResponse fromException(SukkoException e){
        return new ExceptionResponse(e.getHttpStatus(), e.getMessage());
    }
}

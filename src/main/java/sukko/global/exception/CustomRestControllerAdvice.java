package sukko.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRestControllerAdvice {

    @ExceptionHandler(SukkoException.class)
    @ResponseStatus(HttpStatus.OK)
    public ExceptionResponse sukkoExceptionHandler(SukkoException e){
        return ExceptionResponse.fromException(e);
    }
}

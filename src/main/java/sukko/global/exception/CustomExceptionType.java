package sukko.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import sukko.expedition.exception.InvalidCharacterNameException;
import sukko.expedition.exception.NoMatchingClassTypeException;
import sukko.expedition.exception.NoMatchingServerTypeException;
import sukko.taxidermy.exception.NoMatchingDungeonType;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionType {

    UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러", SukkoException.class),
    INVALID_CHARACTER_NAME(HttpStatus.BAD_REQUEST, "해당하는 캐릭터가 없습니다.", InvalidCharacterNameException.class),

    NoMatchingDungeonType(HttpStatus.BAD_REQUEST, "일치하는 레이드가 없습니다.", NoMatchingDungeonType.class),
    NoMatchingClassType(HttpStatus.BAD_REQUEST, "일치하는 직업이 없습니다.", NoMatchingClassTypeException.class),
    NoMatchingServerType(HttpStatus.BAD_REQUEST, "일치하는 서버가 없습니다.", NoMatchingServerTypeException.class),

    ;

    private final HttpStatus httpStatus;
    private final String message;
    private final Class<? extends SukkoException> type;

    public static CustomExceptionType of(Class<? extends SukkoException> classType) {
        return Arrays.stream(values())
                .filter(exception -> exception.type.equals(classType))
                .findFirst()
                .orElse(UNKNOWN);
    }
}

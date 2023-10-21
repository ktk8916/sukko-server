package sukko.expedition.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ServerType {

    LOOPAEON("루페온"),
    SILIAN("실리안"),
    AMAN("아만"),
    KARMAIN("카마인"),
    KAZEROS("카제로스"),
    ABRELSHUD("아브렐슈드"),
    KADAN("카단"),
    NINAVE("니나브"),

    ;

    private final String text;

    public static ServerType getServerType(String name){
        return Arrays.stream(ServerType.values())
                .filter(serverType -> serverType.getText().equals(name))
                .findFirst()
                .orElseThrow();
    }
}

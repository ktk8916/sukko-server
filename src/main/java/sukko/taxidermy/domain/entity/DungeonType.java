package sukko.taxidermy.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sukko.taxidermy.exception.NoMatchingDungeonTypeException;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum DungeonType {
    VALTAN("발탄"),
    BIACKISS("비아키스"),
    KOUKUSATON("쿠크세이튼"),
    ABRELSHUD("아브렐슈드"),
    ILLIAKAN("일리아칸"),
    KAMEN("카멘"),
    ELGACIA("카양겔"),
    VOLDAIK("상아탑"),

    ;

    private final String text;

    public static DungeonType getDungeonType(String name){
        return Arrays.stream(DungeonType.values())
                .filter(dungeonType -> dungeonType.getText().equals(name))
                .findFirst()
                .orElseThrow(NoMatchingDungeonTypeException::new);
    }
}

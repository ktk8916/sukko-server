package sukko.expedition.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum ClassType {

    // 슈사이어
    DESTROYER("디스트로이어"), WARLORD("워로드"), BERSERKER("버서커"), HOLYKNIGHT("홀리나이트"), SLAYER("슬레이어"),

    // 애니츠
    BATTLEMASTER("배틀마스터"), INFIGHTER("인파이터"), SOULMASTER("기공사"), LANCEMASTER("창술사"), STRIKER("스트라이커"),

    //아르데타인
    DEVILHUNTER("데빌헌터"), BLASTER("블래스터"), HAWKEYE("호크아이"), SCOUTER("스카우터"), GUNSLINGER("건슬링어"),

    // 실린
    BARD("바드"), SUMMONER("서머너"), ARCANA("아르카나"), SORCERESS("소서리스"),

    // 데런
    DEMONIC("데모닉"), BLADE("블레이드"), REAPER("리퍼"), SOULEATER("소울이터"),

    // 스페셜리스트
    ARTIST("도화가"), AEROMANCER("기상술사")

    ;

    private final String text;

    public static ClassType getClassType(String name){
        return Arrays.stream(ClassType.values())
                .filter(classType -> classType.getText().equals(name))
                .findFirst()
                .orElseThrow();
    }
}

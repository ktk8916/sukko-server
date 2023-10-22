package sukko.taxidermy.domain.request;

import sukko.expedition.domain.entity.LoaCharacter;
import sukko.taxidermy.domain.entity.DungeonType;
import sukko.taxidermy.domain.entity.Taxidermy;

public record TaxidermyRegisterRequest(
        String dungeon,
        String nickname,
        String title,
        String content,
        String password
) {

    public Taxidermy toEntity(LoaCharacter character){
        return Taxidermy.builder()
                .title(title)
                .content(content)
                .dungeonType(DungeonType.getServerType(dungeon))
                .password(password)
                .prisoner(character)
                .build();
    }
}

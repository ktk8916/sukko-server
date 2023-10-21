package sukko.taxidermy.domain.request;

import sukko.expedition.domain.entity.LoaCharacter;
import sukko.taxidermy.domain.entity.DungeonType;
import sukko.taxidermy.domain.entity.Taxidermy;

public record TaxidermyRegisterRequest(
        String dungeon,
        String prisonerName,
        String title,
        String content,
        String password
) {

    public Taxidermy toEntity(LoaCharacter character){
        return Taxidermy.builder()
                .title(title)
                .content(content)
                .dungeonType(DungeonType.BALTAN)
                .password(password)
                .prisoner(character)
                .build();
    }
}

package sukko.expedition.domain.dto;

import sukko.expedition.domain.entity.ClassType;
import sukko.expedition.domain.entity.LoaCharacter;
import sukko.expedition.domain.entity.ServerType;

public record LoaCharacterDto(
        ServerType serverType,
        ClassType classType,
        String name
) {
    public static LoaCharacterDto fromEntity(LoaCharacter loaCharacter){
        return new LoaCharacterDto(
                loaCharacter.getServerType(),
                loaCharacter.getClassType(),
                loaCharacter.getName()
        );
    }
}

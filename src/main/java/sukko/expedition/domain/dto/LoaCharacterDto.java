package sukko.expedition.domain.dto;

import sukko.expedition.domain.entity.LoaCharacter;

public record LoaCharacterDto(
        String serverType,
        String classType,
        String name
) {
    public static LoaCharacterDto fromEntity(LoaCharacter loaCharacter){
        return new LoaCharacterDto(
                loaCharacter.getServerType().getText(),
                loaCharacter.getClassType().getText(),
                loaCharacter.getName()
        );
    }
}

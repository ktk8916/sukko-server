package sukko.taxidermy.domain.response;

import sukko.expedition.domain.dto.LoaCharacterDto;
import sukko.expedition.domain.entity.ServerType;
import sukko.taxidermy.domain.entity.DungeonType;
import sukko.taxidermy.domain.entity.Taxidermy;

import java.time.LocalDateTime;

public record TaxidermySummaryResponse(
        Long id,
        String title,
        DungeonType dungeonType,
        LoaCharacterDto character,
        LocalDateTime createdAt
) {
    public static TaxidermySummaryResponse fromEntity(Taxidermy taxidermy){
        return new TaxidermySummaryResponse(
                taxidermy.getId(),
                taxidermy.getTitle(),
                taxidermy.getDungeonType(),
                LoaCharacterDto.fromEntity(taxidermy.getPrisoner()),
                taxidermy.getCreatedAt()
        );
    }
}

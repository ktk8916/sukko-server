package sukko.taxidermy.domain.response;

import sukko.expedition.domain.dto.LoaCharacterDto;
import sukko.taxidermy.domain.entity.Taxidermy;

import java.time.LocalDateTime;

public record TaxidermySummaryResponse(
        Long id,
        String title,
        String dungeonType,
        LoaCharacterDto character,
        LocalDateTime createdAt
) {
    public static TaxidermySummaryResponse fromEntity(Taxidermy taxidermy){
        return new TaxidermySummaryResponse(
                taxidermy.getId(),
                taxidermy.getTitle(),
                taxidermy.getDungeonType().getText(),
                LoaCharacterDto.fromEntity(taxidermy.getPrisoner()),
                taxidermy.getCreatedAt()
        );
    }
}

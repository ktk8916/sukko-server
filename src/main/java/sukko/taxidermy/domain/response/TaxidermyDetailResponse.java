package sukko.taxidermy.domain.response;

import sukko.expedition.domain.dto.LoaCharacterDto;
import sukko.taxidermy.domain.entity.Taxidermy;

import java.time.LocalDateTime;

public record TaxidermyDetailResponse(
        Long id,
        String title,
        String content,
        String dungeonType,
        LoaCharacterDto character,
        LocalDateTime createdAt) {

    public static TaxidermyDetailResponse fromEntity(Taxidermy taxidermy){
        return new TaxidermyDetailResponse(
                taxidermy.getId(),
                taxidermy.getTitle(),
                taxidermy.getContent(),
                taxidermy.getDungeonType().getText(),
                LoaCharacterDto.fromEntity(taxidermy.getPrisoner()),
                taxidermy.getCreatedAt()
        );
    }
}

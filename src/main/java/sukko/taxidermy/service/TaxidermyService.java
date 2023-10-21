package sukko.taxidermy.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sukko.expedition.domain.entity.LoaCharacter;
import sukko.expedition.service.ExpeditionRegisterService;
import sukko.taxidermy.domain.entity.Taxidermy;
import sukko.taxidermy.domain.request.TaxidermyRegisterRequest;
import sukko.taxidermy.domain.response.TaxidermySummaryResponse;
import sukko.taxidermy.repository.TaxidermyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaxidermyService {

    private final TaxidermyRepository taxidermyRepository;
    private final ExpeditionRegisterService expeditionRegisterService;

    public void save(TaxidermyRegisterRequest request){
        LoaCharacter character = expeditionRegisterService.register(request.prisonerName());

        Taxidermy taxidermy = request.toEntity(character);

        taxidermyRepository.save(taxidermy);
    }

    public List<TaxidermySummaryResponse> getByCharacterName(String name) {
        return taxidermyRepository.findByCharacterName(name).stream()
                .map(TaxidermySummaryResponse::fromEntity)
                .toList();
    }

    public List<TaxidermySummaryResponse> getRelationByCharacterName(String name) {
        return taxidermyRepository.findRelationByCharacterName(name).stream()
                .map(TaxidermySummaryResponse::fromEntity)
                .toList();
    }
}
package sukko.expedition.repository;

import sukko.expedition.domain.entity.Expedition;
import sukko.expedition.domain.entity.LoaCharacter;

import java.util.Optional;

public interface CustomExpeditionRepository {

    Optional<Expedition> findExpeditionByLoaCharacterName(String name);
    Optional<LoaCharacter> findLoaCharacterByName(String name);
}

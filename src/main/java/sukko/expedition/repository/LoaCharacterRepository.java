package sukko.expedition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukko.expedition.domain.entity.LoaCharacter;

import java.util.Optional;

public interface LoaCharacterRepository extends JpaRepository<LoaCharacter, Long> {

    Optional<LoaCharacter> findByName(String name);
}

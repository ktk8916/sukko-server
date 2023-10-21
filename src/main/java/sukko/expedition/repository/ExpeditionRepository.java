package sukko.expedition.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukko.expedition.domain.entity.Expedition;


public interface ExpeditionRepository extends JpaRepository<Expedition, Long>, CustomExpeditionRepository {

}

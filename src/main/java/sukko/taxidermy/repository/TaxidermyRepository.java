package sukko.taxidermy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sukko.taxidermy.domain.entity.Taxidermy;

public interface TaxidermyRepository extends JpaRepository<Taxidermy, Long>, CustomTaxidermyRepository {

}

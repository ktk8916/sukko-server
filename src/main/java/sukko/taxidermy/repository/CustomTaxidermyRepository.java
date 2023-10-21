package sukko.taxidermy.repository;

import sukko.taxidermy.domain.entity.Taxidermy;

import java.util.List;

public interface CustomTaxidermyRepository {

    List<Taxidermy> findByCharacterName(String name);
    List<Taxidermy> findRelationByCharacterName(String name);

}

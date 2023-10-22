package sukko.taxidermy.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import sukko.expedition.domain.entity.Expedition;
import sukko.taxidermy.domain.entity.Taxidermy;

import java.util.List;

import static sukko.expedition.domain.entity.QExpedition.expedition;
import static sukko.expedition.domain.entity.QLoaCharacter.loaCharacter;
import static sukko.taxidermy.domain.entity.QTaxidermy.taxidermy;

public class CustomTaxidermyRepositoryImpl implements CustomTaxidermyRepository{

    private final JPAQueryFactory queryFactory;
    public CustomTaxidermyRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Taxidermy> findByCharacterName(String name) {
        return queryFactory.selectFrom(taxidermy)
                .leftJoin(taxidermy.prisoner, loaCharacter)
                .fetchJoin()
                .where(loaCharacter.name.eq(name))
                .fetch();
    }

    @Override
    public List<Taxidermy> findRelationByCharacterName(String name) {

        Expedition findExpedition = queryFactory.selectFrom(expedition)
                .leftJoin(expedition.characters, loaCharacter)
                .where(loaCharacter.name.eq(name))
                .fetchOne();

        if(findExpedition==null){
            return List.of();
        }

        return queryFactory.selectFrom(taxidermy)
                .leftJoin(taxidermy.prisoner, loaCharacter)
                .fetchJoin()
                .where(loaCharacter.in(findExpedition.getCharacters()))
                .fetch();
    }
}

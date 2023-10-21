package sukko.expedition.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import sukko.expedition.domain.entity.Expedition;
import sukko.expedition.domain.entity.LoaCharacter;

import java.util.Optional;

import static sukko.expedition.domain.entity.QExpedition.expedition;
import static sukko.expedition.domain.entity.QLoaCharacter.loaCharacter;

public class CustomExpeditionRepositoryImpl implements CustomExpeditionRepository{

    private final JPAQueryFactory queryFactory;
    public CustomExpeditionRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Optional<Expedition> findExpeditionByLoaCharacterName(String name) {
        Expedition findExpedition = queryFactory.selectFrom(expedition)
                .leftJoin(expedition.characters, loaCharacter)
                .fetchJoin()
                .where(loaCharacter.name.eq(name))
                .fetchOne();
        return Optional.ofNullable(findExpedition);
    }

    @Override
    public Optional<LoaCharacter> findLoaCharacterByName(String name) {
        LoaCharacter character = queryFactory.selectFrom(loaCharacter)
                .leftJoin(loaCharacter.expedition)
                .fetchJoin()
                .where(loaCharacter.name.eq(name))
                .fetchOne();
        return Optional.ofNullable(character);
    }
}

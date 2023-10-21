package sukko.expedition.service;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import sukko.client.lostark.CharacterDto;
import sukko.client.lostark.LostArkApiClient;
import org.springframework.stereotype.Service;
import sukko.expedition.domain.entity.ClassType;
import sukko.expedition.domain.entity.Expedition;
import sukko.expedition.domain.entity.LoaCharacter;
import sukko.expedition.domain.entity.ServerType;
import sukko.expedition.repository.ExpeditionRepository;
import sukko.expedition.repository.LoaCharacterRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpeditionRegisterService {

    private final LostArkApiClient lostArkApiClient;
    private final ExpeditionRepository expeditionRepository;
    private final LoaCharacterRepository loaCharacterRepository;

    public LoaCharacter register(String name){

        Optional<LoaCharacter> findCharacter = expeditionRepository.findLoaCharacterByName(name);

        if(findCharacter.isPresent()){
            return findCharacter.get();
        }

        Expedition expedition = expeditionRepository.save(Expedition.createEmptyExpedition());

        List<CharacterDto> characters = lostArkApiClient.getCharacterList(name);

        if(characters.isEmpty()){
            throw new RuntimeException("없음");
        }

        List<LoaCharacter> loaCharacters = characters.stream()
                .map(character ->
                        LoaCharacter.createLoaCharacter(
                                expedition,
                                ServerType.getServerType(character.ServerName()),
                                ClassType.getClassType(character.CharacterClassName()),
                                character.CharacterName()))
                .toList();

        loaCharacterRepository.saveAll(loaCharacters);

        return loaCharacterRepository.findByName(name)
                .orElseThrow(()->new NoSuchElementException("머선129"));
    }
}

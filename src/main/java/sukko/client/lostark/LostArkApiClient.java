package sukko.client.lostark;

import java.util.List;

public interface LostArkApiClient {

    public List<CharacterDto> getCharacterList(String name);
}

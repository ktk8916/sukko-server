package sukko.client.lostark;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class LostArkApiClientImpl implements LostArkApiClient{

    @Value("${lostArk.key}")
    private String API_KEY;
    private final String API_URL = "https://developer-lostark.game.onstove.com/characters";
    @Override
    public List<CharacterDto> getCharacterList(String name) {
        return WebClient.create()
                .get()
                .uri(getUri(name))
                .headers(header->header.setBearerAuth(API_KEY))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CharacterDto>>() {})
                .block();
    }

    private String getUri(String name){
        return API_URL +"/" + name + "/siblings";
    }
}

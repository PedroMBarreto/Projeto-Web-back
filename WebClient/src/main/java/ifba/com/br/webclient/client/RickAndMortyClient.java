package ifba.com.br.webclient.client;

import ifba.com.br.webclient.model.CharacterResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RickAndMortyClient {

    private final WebClient webClient;

    public RickAndMortyClient(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:8080/usuario_cadastro").build();
    }

    public Mono<CharacterResponse> findCharacterById(String id) {
        return webClient.get().uri("/findbyid/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(CharacterResponse.class);
    }
}

package ifba.com.br.webclient.controller;


import ifba.com.br.webclient.client.RickAndMortyClient;
import ifba.com.br.webclient.model.CharacterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class RickAndMortyController {

    private final RickAndMortyClient rickAndMortyClient;

    @Autowired
    public RickAndMortyController(RickAndMortyClient rickAndMortyClient) {
        this.rickAndMortyClient = rickAndMortyClient;
    }
    @GetMapping("/character/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CharacterResponse> getCharacterById(@PathVariable String id) {
        return rickAndMortyClient.findCharacterById(id);
    }
}

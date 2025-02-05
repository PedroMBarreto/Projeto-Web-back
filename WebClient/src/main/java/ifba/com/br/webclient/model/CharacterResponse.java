package ifba.com.br.webclient.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CharacterResponse(Integer id, String nome, String email, String telefone, String senha) {
}

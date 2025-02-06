package ifba.com.br.back.repository;

import ifba.com.br.back.dto.UsuarioPostRequestDto;
import ifba.com.br.back.entity.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class IUsuarioTest {

    @Autowired
    IUsuario iUsuario;

    @Autowired
    EntityManager em;

    @Test
    @DisplayName("Should get user successfully from BD")
    void findByEmailSuccess() {
        String email = "test@test.com";

        // Cria um DTO com valores válidos
        UsuarioPostRequestDto usuarioDTO = new UsuarioPostRequestDto(
                "Pedro", // Nome
                email,   // Email
                "1234567899", // CPF
                "123456" // Senha
        );

        // Persiste o usuário no banco de dados
        this.createUser(usuarioDTO);

        // Realiza a busca pelo email
        Optional<Usuario> found = this.iUsuario.findByEmail(email);

        // Verifica se o usuário foi encontrado
        assertThat(found.isPresent()).isTrue();
    }

    // Método para criar e persistir o usuário
    private Usuario createUser(UsuarioPostRequestDto usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setSenha(usuarioDTO.getSenha());

        // Persiste a entidade no banco de dados
        this.em.persist(usuario);
        return usuario;
    }
}

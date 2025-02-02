package ifba.com.br.back.DAO;

import ifba.com.br.back.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
}

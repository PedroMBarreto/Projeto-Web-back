package ifba.com.br.back.repository;

import ifba.com.br.back.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUsuario extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    Page<Usuario> findAll(Pageable pageable);
}

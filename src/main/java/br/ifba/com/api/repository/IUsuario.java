package br.ifba.com.api.repository;

import br.ifba.com.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}

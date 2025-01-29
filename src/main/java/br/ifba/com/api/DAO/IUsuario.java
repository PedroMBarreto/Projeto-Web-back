package br.ifba.com.api.DAO;

import br.ifba.com.api.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

}

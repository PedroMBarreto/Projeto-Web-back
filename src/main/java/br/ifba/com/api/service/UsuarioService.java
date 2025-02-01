package br.ifba.com.api.service;

import br.ifba.com.api.entity.Usuario;
import br.ifba.com.api.infrastructure.exception.BusinessException;
import br.ifba.com.api.repository.IUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario save(Usuario usuario) {
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public Usuario update(Integer id, Usuario usuario) {
        Usuario usuarioSalvo = repository.findById(id).orElseThrow(() -> new BusinessException("Usuário não encontrado"));
        usuarioSalvo.setNome(usuario.getNome());
        usuarioSalvo.setSenha(usuario.getSenha());
        return repository.save(usuarioSalvo);
    }

    public Boolean delete(Integer id){
        repository.deleteById(id);
        return true;
    }

}

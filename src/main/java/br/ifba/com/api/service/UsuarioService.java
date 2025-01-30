package br.ifba.com.api.service;

import br.ifba.com.api.model.Usuario;
import br.ifba.com.api.repository.IUsuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;

    public UsuarioService(IUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> listarUsuario() {
        List<Usuario> lista = repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario) {
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }
}

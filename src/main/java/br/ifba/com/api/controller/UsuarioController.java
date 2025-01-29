package br.ifba.com.api.controller;

import br.ifba.com.api.DAO.IUsuario;
import br.ifba.com.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuario dao;

    @GetMapping
    public List<Usuario> listaUsuarios() {
        return (List<Usuario>) dao.findAll();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return usuarioNovo;
    }

    @PutMapping
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioNovo = dao.save(usuario);
        return dao.save(usuario);
    }

    @DeleteMapping("/{id}")
    public Optional<Usuario> deletarUsuario (@PathVariable Integer id) {
        Optional<Usuario> usuario = dao.findById(id);
        dao.deleteById(id);
        return usuario;
    }
}

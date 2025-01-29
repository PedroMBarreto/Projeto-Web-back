package controller;

import DAO.UsuarioDAO;
import entity.Usuario;

import java.util.List;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para adicionar usuário
    public void adicionarUsuario(String nome, String senha) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);

        usuarioDAO.inserirUsuario(usuario);
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioDAO.buscarTodosUsuarios();
    }

    // Método para buscar usuário por ID
    public Usuario buscarUsuarioPorId(int id) {
        return usuarioDAO.buscarUsuarioPorId(id);
    }

    // Método para atualizar usuário
    public void atualizarUsuario(int id, String novoNome, String novaSenha) {
        Usuario usuario = new Usuario();
        usuario.setCodigo(id);
        usuario.setNome(novoNome);
        usuario.setSenha(novaSenha);

        usuarioDAO.atualizarUsuario(usuario);
    }

    // Método para excluir usuário
    public void excluirUsuario(int id) {
        usuarioDAO.excluirUsuario(id);
    }
}

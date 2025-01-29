import DAO.UsuarioDAO;
import entity.Usuario;

public class Main {
    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        usuario.setNome("Pedro");
        usuario.setSenha("123456");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.inserirUsuario(usuario);
    }
}

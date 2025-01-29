import controller.UsuarioController;
import entity.Usuario;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();

        // Adicionando um usuário
        //usuarioController.adicionarUsuario("Predo", "123456");

        // Listando usuários
        List<Usuario> usuario = usuarioController.listarUsuarios();
        for (Usuario u : usuario) {
            System.out.println("ID: " + u.getCodigo() + " | Nome: " + u.getNome());
        }

        // Buscar usuário por ID
        Usuario usuarioEncontrado = usuarioController.buscarUsuarioPorId(1);
        if (usuarioEncontrado != null) {
            System.out.println("Usuário encontrado: " + usuarioEncontrado.getNome());
        } else {
            System.out.println("Usuário não encontrado.");
        }

        // Atualizar usuário
        //usuarioController.atualizarUsuario(3, "Maria Silva", "novaSenha123");

    }
}

package ifba.com.br.back.service;

import ifba.com.br.back.DAO.IUsuario;
import ifba.com.br.back.entity.Usuario;
import ifba.com.br.back.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuario iusuario;

    @Transactional
    public Usuario save(Usuario usuario) {
        // Verificar se o email já está cadastrado
        Optional<Usuario> usuarioExistente = iusuario.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new BusinessException("Já existe um usuário cadastrado com este e-mail.");
        }

        return iusuario.save(usuario);
    }

    public Usuario update(Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistente = iusuario.findById(usuarioAtualizado.getId());

        if (usuarioExistente.isEmpty()) {
            throw new BusinessException("Usuário não encontrado para atualização.");
        }

        Usuario usuario = usuarioExistente.get();

        // Atualiza os dados apenas se forem fornecidos
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTelefone(usuarioAtualizado.getTelefone());

        // Se a senha for nula no DTO, mantém a senha antiga
        if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
            usuario.setSenha(usuarioAtualizado.getSenha());
        }

        return iusuario.save(usuario);
    }

    public void delete(Integer id) {
        Optional<Usuario> usuarioExistente = iusuario.findById(id);
        if (usuarioExistente.isEmpty()) {
            throw new BusinessException("Usuário não encontrado para exclusão.");
        }
        iusuario.deleteById(id);
    }

    public Usuario findById(Integer id) {
        return iusuario.findById(id).orElse(null);
    }

    public List<Usuario> findall() {
        return iusuario.findAll();
    }
}

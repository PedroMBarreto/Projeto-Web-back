package ifba.com.br.back.mapper;

import ifba.com.br.back.dto.UsuarioGetResponseDto;
import ifba.com.br.back.dto.UsuarioPostRequestDto;
import ifba.com.br.back.dto.UsuarioPutRequestDto;
import ifba.com.br.back.entity.Usuario;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    // Método para converter entidade → DTO (GET)
    public static UsuarioGetResponseDto toDto(Usuario usuario) {
        return new UsuarioGetResponseDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone()
        );
    }

    // Método para converter uma lista de entidades → lista de DTOs (GET)
    public static List<UsuarioGetResponseDto> mapAll(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioMapper::toDto)
                .collect(Collectors.toList());
    }

    // 🔹 Novo método para converter Page<Usuario> → Page<UsuarioGetResponseDto>
    public static Page<UsuarioGetResponseDto> toDtoPage(Page<Usuario> usuariosPage) {
        return usuariosPage.map(UsuarioMapper::toDto);
    }

    // Método para converter DTO (POST) → Entidade
    public static Usuario toEntity(UsuarioPostRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setSenha(dto.getSenha()); // Senha será salva diretamente
        return usuario;
    }

    // Método para converter DTO (PUT) → Entidade
    public static Usuario toEntity(UsuarioPutRequestDto dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefone(dto.getTelefone());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }
}

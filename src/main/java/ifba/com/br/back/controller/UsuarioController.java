package ifba.com.br.back.controller;

import ifba.com.br.back.dto.UsuarioGetResponseDto;
import ifba.com.br.back.dto.UsuarioPostRequestDto;
import ifba.com.br.back.dto.UsuarioPutRequestDto;
import ifba.com.br.back.entity.Usuario;
import ifba.com.br.back.exception.BusinessException;
import ifba.com.br.back.mapper.UsuarioMapper;
import ifba.com.br.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/usuario_cadastro")
@RestController
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // GET - Buscar todos os usuários
    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UsuarioGetResponseDto>> findAll(Pageable pageable) {
        Page<UsuarioGetResponseDto> usuarios = usuarioService.findall(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    // POST - Criar um novo usuário
    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody UsuarioPostRequestDto usuarioDto) {
        try {
            Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
            Usuario novoUsuario = usuarioService.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(novoUsuario));
        } catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    // PUT - Atualizar um usuário existente
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UsuarioPutRequestDto usuarioDto) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioDto);
        Usuario updatedUsuario = usuarioService.update(usuario);
        if (updatedUsuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado para atualização.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(UsuarioMapper.toDto(updatedUsuario));
    }

    // DELETE - Deletar um usuário pelo ID
    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            usuarioService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuário excluído com sucesso.");
        } catch (BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }
}


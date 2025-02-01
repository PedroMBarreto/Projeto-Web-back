package br.ifba.com.api.controller;

import br.ifba.com.api.dto.UsuarioGetResponseDto;
import br.ifba.com.api.dto.UsuarioPostRequestDto;
import br.ifba.com.api.dto.UsuarioUpdateRequestDto;
import br.ifba.com.api.entity.Usuario;
import br.ifba.com.api.infrastructure.mapper.ObjectMapperUtil;
import br.ifba.com.api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(path = "/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(ObjectMapperUtil.mapList(this.usuarioService.findAll(), UsuarioGetResponseDto.class));
    }


    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody @Valid UsuarioPostRequestDto usuarioPostRequestDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ObjectMapperUtil.map(usuarioService.save(
                                (ObjectMapperUtil.map(usuarioPostRequestDto, Usuario.class))),
                        UsuarioGetResponseDto.class
                ));
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody UsuarioUpdateRequestDto usuarioUpdateRequestDto) {
        Usuario usuarioAtualizado = usuarioService.update(id,
                ObjectMapperUtil.map(usuarioUpdateRequestDto, Usuario.class));

        return ResponseEntity.status(HttpStatus.OK)
                .body(ObjectMapperUtil.map(usuarioAtualizado, UsuarioGetResponseDto.class));
    }

    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("LOG", "Usuario excluido com sucesso"));
    }
}

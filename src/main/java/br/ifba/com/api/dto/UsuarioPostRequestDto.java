package br.ifba.com.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDto {

    @JsonProperty(value = "nome")
    @NotNull(message = "Campo Obrigatorio")
    @NotBlank(message = "Insira um nome")
    private String nome;

    @JsonProperty(value = "senha")
    @NotNull(message = "Campo Obrigatorio")
    @NotBlank(message = "Insira uma senha")
    private String senha;
}

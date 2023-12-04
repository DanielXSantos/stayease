package br.com.stayease.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
    private String password;

}

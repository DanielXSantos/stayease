package br.com.stayease.dto;

import br.com.stayease.entities.UserRole;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class UsuarioDto {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String cpf;
    private String email;
    private String password;
    private UserRole role;
}

package br.com.stayease.dto;

import br.com.stayease.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {
    private String email;
    private String password;
    private UserRole role;
}

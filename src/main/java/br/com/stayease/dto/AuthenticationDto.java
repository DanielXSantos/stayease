package br.com.stayease.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthenticationDto {
    private String email;
    private String password;
}

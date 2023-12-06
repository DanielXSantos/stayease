package br.com.stayease.repositories;

import br.com.stayease.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);

    Usuario findByCpf(String cpf);

    Boolean existsByCpf(String cpf);

    Boolean existsByEmail(String email);
}

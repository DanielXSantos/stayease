//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package br.com.stayease.services;

import br.com.stayease.entities.Usuario;
import br.com.stayease.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

@ActiveProfiles({"test"})
@AutoConfigureTestDatabase(
        replace = Replace.NONE
)
class UsuarioServiceTest {
    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    UsuarioServiceTest() {
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create User when everything is OK")
    void createUserWhenEverythingIsOk() {
        Usuario usuario = new Usuario(1L, "Gustavo", LocalDate.of(1997, 8, 18), "12547896547", "gustavo@gmail.com", "senha123");
        Mockito.when((Usuario)this.usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario savedUsuario = this.usuarioService.create(usuario);
        Assertions.assertEquals(savedUsuario, usuario);
    }

    @Test
    @DisplayName("Should throw Exception when some User's information are missing")
    void throwsExceptionWhenUsersInfoAreMissing() {
        Usuario usuario = new Usuario(1L, "Gustavo", null, "12547896547", "gustavo@gmail.com", "senha123");
        Assertions.assertThrows(IllegalArgumentException.class, () -> this.usuarioService.create(usuario));
    }

    @Test
    @DisplayName("Should throw Exception when the user created already exists")
    void createUserAlreadyExistis() {
    }

}

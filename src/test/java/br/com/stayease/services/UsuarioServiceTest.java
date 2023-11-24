package br.com.stayease.services;

import br.com.stayease.entities.Usuario;
import br.com.stayease.repositories.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @Autowired
    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create User when everything is OK")
    void createCase1() {
        Usuario usuario = new Usuario(1L, "Gustavo", LocalDate.of(1997, 8, 18), "12547896547", "gustavo@gmail.com", "senha123");
        when(usuarioRepository.save(usuario)).thenReturn(usuario);

        Usuario savedUsuario = usuarioService.create(usuario);
        assertEquals(savedUsuario, usuario);
    }

    @Test
    @DisplayName("Should throw Exception when some User's information are missing")
    void createCase2() {
    }
}
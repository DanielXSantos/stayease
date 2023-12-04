package br.com.stayease.controllers;

import br.com.stayease.dto.UsuarioDto;
import br.com.stayease.entities.Usuario;
import br.com.stayease.exception.DefaltException;
import br.com.stayease.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid UsuarioDto usuarioDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(usuarioDto));
    }


    @Transactional
    @PutMapping(value = "/teste/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = service.update(id, usuario);

        if (usuarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuarioAtualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (DefaltException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDto> findByEmail (@PathVariable String email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findByEmail(email));
        } catch (DefaltException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public List<UsuarioDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}

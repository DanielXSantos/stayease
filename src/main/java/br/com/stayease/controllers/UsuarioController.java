package br.com.stayease.controllers;

import br.com.stayease.entities.Usuario;
import br.com.stayease.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        return service.create(usuario);
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
    public Optional<Usuario> findById(@PathVariable Long id){
        return service.findById(id);
    }


    @GetMapping("/email/{email}")
    public Usuario findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }


    @GetMapping
    public List<Usuario> findAll(){
        return service.findAll();
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        service.delete(id);
    }

}

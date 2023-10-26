package br.com.stayease.controllers;

import br.com.stayease.entities.Usuario;
import br.com.stayease.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        return service.create(usuario);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario usuarioThatExists = service.findById(id);

        if(usuarioThatExists == null){
            return ResponseEntity.notFound().build();
        }

        usuarioThatExists.setName(usuario.getName());
        usuarioThatExists.setBirthDate(usuario.getBirthDate());
        usuarioThatExists.setCpf(usuario.getCpf());
        usuarioThatExists.setEmail(usuario.getEmail());
        usuarioThatExists.setPassword(usuario.getPassword());

        return ResponseEntity.ok(service.update(usuarioThatExists));
    }

    @GetMapping("/id")
    public Usuario findById(@RequestParam Long id){
        return service.findById(id);
    }

    @GetMapping("/email")
    public Usuario findByEmail(@RequestParam String email){
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

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
    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        return service.create(usuario);
    }

    @Transactional
    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        Optional<Usuario> usuarioThatExists = service.findById(id);

        if(usuarioThatExists.isPresent()){
            return ResponseEntity.notFound().build();
        }

        Usuario existingUsuario = usuarioThatExists.get();

        existingUsuario.setName(usuario.getName());
        existingUsuario.setBirthDate(usuario.getBirthDate());
        existingUsuario.setCpf(usuario.getCpf());
        existingUsuario.setEmail(usuario.getEmail());
        existingUsuario.setPassword(usuario.getPassword());

        return ResponseEntity.ok(service.update(existingUsuario));
    }

    @Transactional
    @GetMapping(value = "/{id}")
    public Optional<Usuario> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/email/{email}")
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

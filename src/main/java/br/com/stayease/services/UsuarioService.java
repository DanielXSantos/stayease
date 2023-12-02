package br.com.stayease.services;

import br.com.stayease.entities.Usuario;
import br.com.stayease.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);
    }

    public Usuario findByEmail(String email){
        return repository.findByEmail(email);
    }

//    public Usuario create(Usuario usuario) {
//        if (usuario.getEmail() != null && repository.findByEmail(usuario.getEmail()) != null) {
//            throw new IllegalArgumentException("E-mail já cadastrado");
//        }
//        return repository.save(usuario);
//    }

    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioExistenteOpt = repository.findById(id);

        if (usuarioExistenteOpt.isEmpty()) {
            return null;
        }

        Usuario usuarioExistente = usuarioExistenteOpt.get();

        // Atualiza apenas os campos não nulos do usuário existente com os valores do usuário atualizado
        if (usuarioAtualizado.getName() != null) {
            usuarioExistente.setName(usuarioAtualizado.getName());
        }

        if (usuarioAtualizado.getBirthDate() != null) {
            usuarioExistente.setBirthDate(usuarioAtualizado.getBirthDate());
        }

        if (usuarioAtualizado.getCpf() != null) {
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
        }

        if (usuarioAtualizado.getEmail() != null) {
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
        }

        if (usuarioAtualizado.getPassword() != null) {
            usuarioExistente.setPassword(usuarioAtualizado.getPassword());
        }

        return repository.save(usuarioExistente);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}

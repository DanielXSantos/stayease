package br.com.stayease.services;

import br.com.stayease.entities.Usuario;
import br.com.stayease.exceptions.DuplicateObjectException;
import br.com.stayease.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Optional<Usuario> findById(Long id){
        return repository.findById(id);
    }

    public Usuario findByEmail(String email){
        return repository.findByEmail(email);
    }

    public Usuario create(Usuario usuario) {
        if(repository.findByEmail(usuario.getEmail()).equals(true)){
            throw new DuplicateObjectException("Já existe um usuário com o e-mail informado!");
        }else if(repository.findByCpf(usuario.getCpf()).equals(true)){
            throw new DuplicateObjectException("Já existe um usuário com o CPF informado!");
        }else {
            return repository.save(usuario);
        }

    }

    public Usuario update(Usuario usuarioAtualizado) {
        Optional<Usuario> usuarioDesatualizadoOpt = repository.findById(usuarioAtualizado.getId()); //acho o usuario que quero atualizar
        //pego as informacoes do usuario que esta atualizado e passo para o que esta desatualizado
        if(usuarioDesatualizadoOpt.isEmpty()) {
            return null;
        }
        Usuario usuarioDesatualizado = usuarioDesatualizadoOpt.get();
        // TODO: mudar para mapperStruct
        usuarioDesatualizado.setName(usuarioAtualizado.getName());
        usuarioDesatualizado.setCpf(usuarioAtualizado.getCpf());
        usuarioDesatualizado.setEmail(usuarioAtualizado.getEmail());
        usuarioDesatualizado.setBirthDate(usuarioAtualizado.getBirthDate());
        usuarioDesatualizado.setPassword(usuarioDesatualizado.getPassword());
        return repository.save(usuarioDesatualizado);

    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}

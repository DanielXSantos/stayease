package services;

import entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Long id){
        return repository.getOne(id);
    }

    public Usuario create(Usuario usuario){
        return repository.save(usuario);
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

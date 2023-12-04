package br.com.stayease.services;

import br.com.stayease.dto.UsuarioDto;
import br.com.stayease.entities.Usuario;
import br.com.stayease.exception.DefaltException;
import br.com.stayease.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.stayease.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper usuarioMapper;


    public List<UsuarioDto> findAll() {
        return usuarioMapper.toListDto(repository.findAll());
    }


    public UsuarioDto findById(Long id) {
        Optional<Usuario> usuarioEntity = repository.findById(id);
        if (usuarioEntity.isEmpty()){
            throw new DefaltException("Usuario não existe no cadastro");
        }
        return usuarioMapper.usuarioDto(usuarioEntity.get());
    }


    public UsuarioDto findByEmail(String email) {
        Usuario byEmail = repository.findByEmail(email);
        if (byEmail == null) {
            throw new DefaltException("Email não encontrado");
        }
        return usuarioMapper.usuarioDto(byEmail); // Corrigido aqui
    }

//    public Usuario create(Usuario usuario) {
//        if (usuario.getEmail() != null && repository.findByEmail(usuario.getEmail()) != null) {
//            throw new IllegalArgumentException("E-mail já cadastrado");
//        }
//        return repository.save(usuario);
//    }

//    public Usuario create(Usuario usuario) {
//        return repository.save(usuario);
//    }


    public Usuario create(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        // Verificar se o email já está cadastrado
        if (repository.existsByEmail(usuario.getEmail())) {
            throw new DefaltException("E-mail já cadastrado");
        }
        // Verificar se o CPF já está cadastrado
        if (repository.existsByCpf(usuario.getCpf())) {
            throw new DefaltException("CPF já cadastrado");
        }

        // Se tudo estiver OK, salvar o usuário
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

    public void delete(Long id) {
        repository.deleteById(id);
    }


}

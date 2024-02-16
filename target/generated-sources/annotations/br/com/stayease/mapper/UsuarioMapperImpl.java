package br.com.stayease.mapper;

import br.com.stayease.dto.UsuarioDto;
import br.com.stayease.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-16T09:36:00-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.22 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public UsuarioDto usuarioDto(Usuario usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId( usuarioEntity.getId() );
        usuarioDto.setName( usuarioEntity.getName() );
        usuarioDto.setBirthDate( usuarioEntity.getBirthDate() );
        usuarioDto.setCpf( usuarioEntity.getCpf() );
        usuarioDto.setEmail( usuarioEntity.getEmail() );
        usuarioDto.setPassword( usuarioEntity.getPassword() );
        usuarioDto.setRole( usuarioEntity.getRole() );

        return usuarioDto;
    }

    @Override
    public UsuarioDto userDetailsToDto(UserDetails usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setPassword( usuario.getPassword() );

        return usuarioDto;
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setName( dto.getName() );
        usuario.setBirthDate( dto.getBirthDate() );
        usuario.setCpf( dto.getCpf() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPassword( dto.getPassword() );
        usuario.setRole( dto.getRole() );

        return usuario;
    }

    @Override
    public List<UsuarioDto> toListDto(List<Usuario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( entityList.size() );
        for ( Usuario usuario : entityList ) {
            list.add( usuarioDto( usuario ) );
        }

        return list;
    }

    @Override
    public Usuario usuarioDto(String email) {
        if ( email == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setEmail( email );

        return usuario;
    }
}

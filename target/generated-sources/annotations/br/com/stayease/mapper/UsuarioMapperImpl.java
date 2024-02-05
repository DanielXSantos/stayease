package br.com.stayease.mapper;

import br.com.stayease.dto.UsuarioDto;
import br.com.stayease.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T17:22:54-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.21 (Ubuntu)"
)
@Component
public class UsuarioMapperImpl extends UsuarioMapper {

    @Override
    public UsuarioDto usuarioDto(Usuario usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setName( usuarioEntity.getName() );
        usuarioDto.setBirthDate( usuarioEntity.getBirthDate() );
        usuarioDto.setCpf( usuarioEntity.getCpf() );
        usuarioDto.setEmail( usuarioEntity.getEmail() );

        return usuarioDto;
    }

    @Override
    public Usuario toEntity(UsuarioDto dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setName( dto.getName() );
        usuario.setBirthDate( dto.getBirthDate() );
        usuario.setCpf( dto.getCpf() );
        usuario.setEmail( dto.getEmail() );

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

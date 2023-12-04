package br.com.stayease.mapper;


import br.com.stayease.dto.UsuarioDto;
import br.com.stayease.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UsuarioMapper {

    public abstract UsuarioDto usuarioDto(Usuario usuarioEntity);

    public abstract Usuario toEntity(UsuarioDto dto);

    public abstract List<UsuarioDto> toListDto(List<Usuario> entityList);

    @Mapping(source = "email", target = "email") // Adicionado mapeamento para o email
    public abstract Usuario usuarioDto(String email);
}
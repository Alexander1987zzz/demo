package com.example;

import com.example.dto.UserDto;
import com.example.generic.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User> {
    @Override
    UserDto toDto(User entity);

    @Override
    User toEntity(UserDto dto);

    @Override
    List<UserDto> toDtoList(List<User> entities);

    void updateEntity(UserDto dto, @MappingTarget User entity);
}

package com.example.generic;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDtoList(List<E> entities);
    void updateEntity(D dto, @MappingTarget E entity);
}

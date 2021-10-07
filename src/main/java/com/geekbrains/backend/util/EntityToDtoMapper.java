package com.geekbrains.backend.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityToDtoMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public EntityToDtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <E, D> D convertToDto(E entity, Class<D> dClass) {
        return modelMapper.map(entity, dClass);
    }

    public <E, D> E convertToEntity(D dto, Class<E> eClass) {
        return modelMapper.map(dto, eClass);
    }

}

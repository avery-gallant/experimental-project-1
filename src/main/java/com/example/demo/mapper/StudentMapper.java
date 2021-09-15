package com.example.demo.mapper;

import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.StudentResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "dateOfBirth", target = "dob")
    public StudentEntity toEntity(StudentResource studentResource);

    @Mapping(source = "dob", target = "dateOfBirth")
    public StudentResource toResource(StudentEntity studentEntity);

    public List<StudentEntity> toEntities(List<StudentResource> studentResources);

    public List<StudentResource> toResources(List<StudentEntity> studentEntities);

}

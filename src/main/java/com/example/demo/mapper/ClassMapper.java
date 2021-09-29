package com.example.demo.mapper;

import com.example.demo.dao.ClassEntity;
import com.example.demo.dto.ClassResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(target = "teacherEntity.teacherId", source = "teacherId")
    //@Mapping(source = "grades", target = "gradeEntityList")
    public ClassEntity toEntity(ClassResource classResource);

    @Mapping(target = "teacherId", source = "teacherEntity.teacherId")
    //@Mapping(source = "gradeEntityList", target = "grades")
    public ClassResource toResource(ClassEntity classEntity);

    public List<ClassEntity> toEntities(List<ClassResource> classResources);

    public List<ClassResource> toResources(List<ClassEntity> classEntities);

}

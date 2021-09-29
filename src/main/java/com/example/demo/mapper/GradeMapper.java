package com.example.demo.mapper;

import com.example.demo.dao.GradeEntity;
import com.example.demo.dto.GradeResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GradeMapper {

    GradeMapper INSTANCE = Mappers.getMapper(GradeMapper.class);

    @Mapping(source = "course", target = "classEntity")
    @Mapping(source = "record", target = "recordEntity")

    public GradeEntity toEntity(GradeResource gradeResource);

    @Mapping(source = "classEntity", target = "course")
    @Mapping(source = "recordEntity", target = "record")

    public GradeResource toResource(GradeEntity gradeEntity);

    public List<GradeEntity> toEntities(List<GradeResource> gradeResources);

    public List<GradeResource> toResources(List<GradeEntity> gradeEntities);

}

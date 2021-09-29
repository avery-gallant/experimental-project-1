package com.example.demo.mapper;

import com.example.demo.dao.TeacherEntity;
import com.example.demo.dto.TeacherResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    @Mapping(source = "dateOfBirth", target = "dob")
    //@Mapping(target = "classEntityList", source = "classIds")
    public TeacherEntity toEntity(TeacherResource teacherResource);

    @Mapping(source = "dob", target = "dateOfBirth")
    //@Mapping(target = "classIds", source = "classEntityList")
    public TeacherResource toResource(TeacherEntity teacherEntity);

    public List<TeacherEntity> toEntities(List<TeacherResource> teacherResources);

    public List<TeacherResource> toResources(List<TeacherEntity> teacherEntities);

}

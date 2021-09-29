package com.example.demo.mapper;

import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.StudentResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Student mapper.
 */
@Component
@Mapper
public interface StudentMapper {
    /**
     * The constant INSTANCE.
     */
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    /**
     * To entity student entity.
     *
     * @param studentResource the student resource
     * @return the student entity
     */
    @Mapping(source = "dateOfBirth", target = "dob")
    @Mapping(target = "recordEntity.recordId", source = "recordId")
    public StudentEntity toEntity(StudentResource studentResource);

    /**
     * To resource student resource.
     *
     * @param studentEntity the student entity
     * @return the student resource
     */
    @Mapping(source = "dob", target = "dateOfBirth")
    @Mapping(target = "recordId", source = "recordEntity.recordId")
    public StudentResource toResource(StudentEntity studentEntity);

    /**
     * To entities list.
     *
     * @param studentResources the student resources
     * @return the list
     */
    public List<StudentEntity> toEntities(List<StudentResource> studentResources);

    /**
     * To resources list.
     *
     * @param studentEntities the student entities
     * @return the list
     */
    public List<StudentResource> toResources(List<StudentEntity> studentEntities);

}

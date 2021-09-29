package com.example.demo.mapper;

import com.example.demo.dao.RecordEntity;
import com.example.demo.dto.RecordResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RecordMapper {

    RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);

    @Mapping(source = "gradePointAverage", target = "gpa")
    @Mapping(target = "studentEntity.studentId", source = "studentId")
    public RecordEntity toEntity(RecordResource recordResource);

    @Mapping(source = "gpa", target = "gradePointAverage")
    @Mapping(target = "studentId", source = "studentEntity.studentId")
    public RecordResource toResource(RecordEntity recordEntity);

    public List<RecordEntity> toEntities(List<RecordResource> recordResources);

    public List<RecordResource> toResources(List<RecordEntity> recordEntities);

}

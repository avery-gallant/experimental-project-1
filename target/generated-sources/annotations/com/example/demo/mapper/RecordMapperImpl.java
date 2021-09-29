package com.example.demo.mapper;

import com.example.demo.dao.RecordEntity;
import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.RecordResource;
import com.example.demo.dto.RecordResource.RecordResourceBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:54:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class RecordMapperImpl implements RecordMapper {

    @Override
    public RecordEntity toEntity(RecordResource recordResource) {
        if ( recordResource == null ) {
            return null;
        }

        RecordEntity recordEntity = new RecordEntity();

        recordEntity.setStudentEntity( recordResourceToStudentEntity( recordResource ) );
        recordEntity.setGpa( recordResource.getGradePointAverage() );
        recordEntity.setRecordId( recordResource.getRecordId() );

        return recordEntity;
    }

    @Override
    public RecordResource toResource(RecordEntity recordEntity) {
        if ( recordEntity == null ) {
            return null;
        }

        RecordResourceBuilder recordResource = RecordResource.builder();

        recordResource.gradePointAverage( recordEntity.getGpa() );
        recordResource.studentId( recordEntityStudentEntityStudentId( recordEntity ) );
        recordResource.recordId( recordEntity.getRecordId() );

        return recordResource.build();
    }

    @Override
    public List<RecordEntity> toEntities(List<RecordResource> recordResources) {
        if ( recordResources == null ) {
            return null;
        }

        List<RecordEntity> list = new ArrayList<RecordEntity>( recordResources.size() );
        for ( RecordResource recordResource : recordResources ) {
            list.add( toEntity( recordResource ) );
        }

        return list;
    }

    @Override
    public List<RecordResource> toResources(List<RecordEntity> recordEntities) {
        if ( recordEntities == null ) {
            return null;
        }

        List<RecordResource> list = new ArrayList<RecordResource>( recordEntities.size() );
        for ( RecordEntity recordEntity : recordEntities ) {
            list.add( toResource( recordEntity ) );
        }

        return list;
    }

    protected StudentEntity recordResourceToStudentEntity(RecordResource recordResource) {
        if ( recordResource == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setStudentId( recordResource.getStudentId() );

        return studentEntity;
    }

    private Long recordEntityStudentEntityStudentId(RecordEntity recordEntity) {
        if ( recordEntity == null ) {
            return null;
        }
        StudentEntity studentEntity = recordEntity.getStudentEntity();
        if ( studentEntity == null ) {
            return null;
        }
        Long studentId = studentEntity.getStudentId();
        if ( studentId == null ) {
            return null;
        }
        return studentId;
    }
}

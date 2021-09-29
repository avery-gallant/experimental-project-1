package com.example.demo.mapper;

import com.example.demo.dao.RecordEntity;
import com.example.demo.dao.StudentEntity;
import com.example.demo.dto.StudentResource;
import com.example.demo.dto.StudentResource.StudentResourceBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:54:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity toEntity(StudentResource studentResource) {
        if ( studentResource == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setRecordEntity( studentResourceToRecordEntity( studentResource ) );
        studentEntity.setDob( studentResource.getDateOfBirth() );
        studentEntity.setName( studentResource.getName() );
        studentEntity.setAge( studentResource.getAge() );
        studentEntity.setStudentId( studentResource.getStudentId() );
        studentEntity.setEmail( studentResource.getEmail() );

        return studentEntity;
    }

    @Override
    public StudentResource toResource(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentResourceBuilder studentResource = StudentResource.builder();

        studentResource.dateOfBirth( studentEntity.getDob() );
        studentResource.recordId( studentEntityRecordEntityRecordId( studentEntity ) );
        studentResource.studentId( studentEntity.getStudentId() );
        studentResource.name( studentEntity.getName() );
        studentResource.email( studentEntity.getEmail() );
        studentResource.age( studentEntity.getAge() );

        return studentResource.build();
    }

    @Override
    public List<StudentEntity> toEntities(List<StudentResource> studentResources) {
        if ( studentResources == null ) {
            return null;
        }

        List<StudentEntity> list = new ArrayList<StudentEntity>( studentResources.size() );
        for ( StudentResource studentResource : studentResources ) {
            list.add( toEntity( studentResource ) );
        }

        return list;
    }

    @Override
    public List<StudentResource> toResources(List<StudentEntity> studentEntities) {
        if ( studentEntities == null ) {
            return null;
        }

        List<StudentResource> list = new ArrayList<StudentResource>( studentEntities.size() );
        for ( StudentEntity studentEntity : studentEntities ) {
            list.add( toResource( studentEntity ) );
        }

        return list;
    }

    protected RecordEntity studentResourceToRecordEntity(StudentResource studentResource) {
        if ( studentResource == null ) {
            return null;
        }

        RecordEntity recordEntity = new RecordEntity();

        recordEntity.setRecordId( studentResource.getRecordId() );

        return recordEntity;
    }

    private Long studentEntityRecordEntityRecordId(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }
        RecordEntity recordEntity = studentEntity.getRecordEntity();
        if ( recordEntity == null ) {
            return null;
        }
        Long recordId = recordEntity.getRecordId();
        if ( recordId == null ) {
            return null;
        }
        return recordId;
    }
}

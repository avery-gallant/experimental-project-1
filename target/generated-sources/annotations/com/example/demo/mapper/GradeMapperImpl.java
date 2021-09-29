package com.example.demo.mapper;

import com.example.demo.dao.ClassEntity;
import com.example.demo.dao.GradeEntity;
import com.example.demo.dao.RecordEntity;
import com.example.demo.dto.ClassResource;
import com.example.demo.dto.ClassResource.ClassResourceBuilder;
import com.example.demo.dto.GradeResource;
import com.example.demo.dto.GradeResource.GradeResourceBuilder;
import com.example.demo.dto.RecordResource;
import com.example.demo.dto.RecordResource.RecordResourceBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:54:07-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class GradeMapperImpl implements GradeMapper {

    @Override
    public GradeEntity toEntity(GradeResource gradeResource) {
        if ( gradeResource == null ) {
            return null;
        }

        GradeEntity gradeEntity = new GradeEntity();

        gradeEntity.setClassEntity( classResourceToClassEntity( gradeResource.getCourse() ) );
        gradeEntity.setRecordEntity( recordResourceToRecordEntity( gradeResource.getRecord() ) );
        if ( gradeResource.getGrade() != null ) {
            gradeEntity.setGrade( gradeResource.getGrade() );
        }

        return gradeEntity;
    }

    @Override
    public GradeResource toResource(GradeEntity gradeEntity) {
        if ( gradeEntity == null ) {
            return null;
        }

        GradeResourceBuilder gradeResource = GradeResource.builder();

        gradeResource.course( classEntityToClassResource( gradeEntity.getClassEntity() ) );
        gradeResource.record( recordEntityToRecordResource( gradeEntity.getRecordEntity() ) );
        gradeResource.grade( gradeEntity.getGrade() );

        return gradeResource.build();
    }

    @Override
    public List<GradeEntity> toEntities(List<GradeResource> gradeResources) {
        if ( gradeResources == null ) {
            return null;
        }

        List<GradeEntity> list = new ArrayList<GradeEntity>( gradeResources.size() );
        for ( GradeResource gradeResource : gradeResources ) {
            list.add( toEntity( gradeResource ) );
        }

        return list;
    }

    @Override
    public List<GradeResource> toResources(List<GradeEntity> gradeEntities) {
        if ( gradeEntities == null ) {
            return null;
        }

        List<GradeResource> list = new ArrayList<GradeResource>( gradeEntities.size() );
        for ( GradeEntity gradeEntity : gradeEntities ) {
            list.add( toResource( gradeEntity ) );
        }

        return list;
    }

    protected ClassEntity classResourceToClassEntity(ClassResource classResource) {
        if ( classResource == null ) {
            return null;
        }

        ClassEntity classEntity = new ClassEntity();

        classEntity.setClassId( classResource.getClassId() );
        classEntity.setName( classResource.getName() );
        classEntity.setAttendees( classResource.getAttendees() );

        return classEntity;
    }

    protected RecordEntity recordResourceToRecordEntity(RecordResource recordResource) {
        if ( recordResource == null ) {
            return null;
        }

        RecordEntity recordEntity = new RecordEntity();

        recordEntity.setRecordId( recordResource.getRecordId() );

        return recordEntity;
    }

    protected ClassResource classEntityToClassResource(ClassEntity classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassResourceBuilder classResource = ClassResource.builder();

        classResource.classId( classEntity.getClassId() );
        classResource.name( classEntity.getName() );
        classResource.attendees( classEntity.getAttendees() );

        return classResource.build();
    }

    protected RecordResource recordEntityToRecordResource(RecordEntity recordEntity) {
        if ( recordEntity == null ) {
            return null;
        }

        RecordResourceBuilder recordResource = RecordResource.builder();

        recordResource.recordId( recordEntity.getRecordId() );

        return recordResource.build();
    }
}

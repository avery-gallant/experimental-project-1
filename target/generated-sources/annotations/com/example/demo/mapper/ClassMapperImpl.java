package com.example.demo.mapper;

import com.example.demo.dao.ClassEntity;
import com.example.demo.dao.TeacherEntity;
import com.example.demo.dto.ClassResource;
import com.example.demo.dto.ClassResource.ClassResourceBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:54:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class ClassMapperImpl implements ClassMapper {

    @Override
    public ClassEntity toEntity(ClassResource classResource) {
        if ( classResource == null ) {
            return null;
        }

        ClassEntity classEntity = new ClassEntity();

        classEntity.setTeacherEntity( classResourceToTeacherEntity( classResource ) );
        classEntity.setClassId( classResource.getClassId() );
        classEntity.setName( classResource.getName() );
        classEntity.setAttendees( classResource.getAttendees() );

        return classEntity;
    }

    @Override
    public ClassResource toResource(ClassEntity classEntity) {
        if ( classEntity == null ) {
            return null;
        }

        ClassResourceBuilder classResource = ClassResource.builder();

        classResource.teacherId( classEntityTeacherEntityTeacherId( classEntity ) );
        classResource.classId( classEntity.getClassId() );
        classResource.name( classEntity.getName() );
        classResource.attendees( classEntity.getAttendees() );

        return classResource.build();
    }

    @Override
    public List<ClassEntity> toEntities(List<ClassResource> classResources) {
        if ( classResources == null ) {
            return null;
        }

        List<ClassEntity> list = new ArrayList<ClassEntity>( classResources.size() );
        for ( ClassResource classResource : classResources ) {
            list.add( toEntity( classResource ) );
        }

        return list;
    }

    @Override
    public List<ClassResource> toResources(List<ClassEntity> classEntities) {
        if ( classEntities == null ) {
            return null;
        }

        List<ClassResource> list = new ArrayList<ClassResource>( classEntities.size() );
        for ( ClassEntity classEntity : classEntities ) {
            list.add( toResource( classEntity ) );
        }

        return list;
    }

    protected TeacherEntity classResourceToTeacherEntity(ClassResource classResource) {
        if ( classResource == null ) {
            return null;
        }

        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setTeacherId( classResource.getTeacherId() );

        return teacherEntity;
    }

    private Long classEntityTeacherEntityTeacherId(ClassEntity classEntity) {
        if ( classEntity == null ) {
            return null;
        }
        TeacherEntity teacherEntity = classEntity.getTeacherEntity();
        if ( teacherEntity == null ) {
            return null;
        }
        Long teacherId = teacherEntity.getTeacherId();
        if ( teacherId == null ) {
            return null;
        }
        return teacherId;
    }
}

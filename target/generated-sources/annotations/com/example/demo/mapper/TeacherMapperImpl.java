package com.example.demo.mapper;

import com.example.demo.dao.TeacherEntity;
import com.example.demo.dto.TeacherResource;
import com.example.demo.dto.TeacherResource.TeacherResourceBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-29T12:54:08-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.1 (Oracle Corporation)"
)
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherEntity toEntity(TeacherResource teacherResource) {
        if ( teacherResource == null ) {
            return null;
        }

        TeacherEntity teacherEntity = new TeacherEntity();

        teacherEntity.setDob( teacherResource.getDateOfBirth() );
        teacherEntity.setName( teacherResource.getName() );
        teacherEntity.setAge( teacherResource.getAge() );
        teacherEntity.setTeacherId( teacherResource.getTeacherId() );
        if ( teacherResource.getSalary() != null ) {
            teacherEntity.setSalary( teacherResource.getSalary() );
        }

        return teacherEntity;
    }

    @Override
    public TeacherResource toResource(TeacherEntity teacherEntity) {
        if ( teacherEntity == null ) {
            return null;
        }

        TeacherResourceBuilder teacherResource = TeacherResource.builder();

        teacherResource.dateOfBirth( teacherEntity.getDob() );
        teacherResource.teacherId( teacherEntity.getTeacherId() );
        teacherResource.name( teacherEntity.getName() );
        teacherResource.salary( teacherEntity.getSalary() );
        teacherResource.age( teacherEntity.getAge() );

        return teacherResource.build();
    }

    @Override
    public List<TeacherEntity> toEntities(List<TeacherResource> teacherResources) {
        if ( teacherResources == null ) {
            return null;
        }

        List<TeacherEntity> list = new ArrayList<TeacherEntity>( teacherResources.size() );
        for ( TeacherResource teacherResource : teacherResources ) {
            list.add( toEntity( teacherResource ) );
        }

        return list;
    }

    @Override
    public List<TeacherResource> toResources(List<TeacherEntity> teacherEntities) {
        if ( teacherEntities == null ) {
            return null;
        }

        List<TeacherResource> list = new ArrayList<TeacherResource>( teacherEntities.size() );
        for ( TeacherEntity teacherEntity : teacherEntities ) {
            list.add( toResource( teacherEntity ) );
        }

        return list;
    }
}

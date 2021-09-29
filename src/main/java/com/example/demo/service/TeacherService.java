package com.example.demo.service;


import com.example.demo.dao.TeacherEntity;
import com.example.demo.dto.TeacherResource;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<TeacherResource> getTeachers() {
        return TeacherMapper.INSTANCE.toResources(teacherRepository.findAll());
    }

    public TeacherResource getTeacher(Long id) throws Exception {
        teacherExists(id);
        return TeacherMapper.INSTANCE.toResource(teacherRepository.findById(id).get());
    }

    private void teacherExists(Long id) throws EntityNotFoundException {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Teacher does not exist");
        }
    }

    public void deleteTeacher(Long id) throws EntityNotFoundException {
        teacherExists(id);
        teacherRepository.deleteById(id);
    }

    public TeacherResource addNewTeacher(TeacherResource teacher) {
        return TeacherMapper.INSTANCE.toResource(teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacher)));
    }

    public TeacherResource updateFullTeacher(TeacherResource teacher, Long id) throws EntityNotFoundException {
        teacherExists(id);
        if (teacher.getTeacherId() == null) {
            teacher.setTeacherId(id);
        }
        return TeacherMapper.INSTANCE.toResource(teacherRepository.save(TeacherMapper.INSTANCE.toEntity(teacher)));
    }

    public TeacherResource updatePartialTeacher(TeacherResource teacherResource, Long id) throws EntityNotFoundException {
        teacherExists(id);
        TeacherEntity teacherEntity = teacherRepository.getById(id);

        if (teacherResource.getAge() != null)
            teacherEntity.setAge(teacherResource.getAge());

        if (teacherResource.getTeacherId() != null)
            teacherEntity.setTeacherId(teacherResource.getTeacherId());

        if (teacherResource.getDateOfBirth() != null)
            teacherEntity.setDob(teacherResource.getDateOfBirth());

        if (teacherResource.getSalary() != null)
            teacherEntity.setSalary(teacherResource.getSalary());

        if (teacherResource.getName() != null)
            teacherEntity.setName(teacherResource.getName());

        //if (teacherResource.getClassIds() != null)
        //    teacherEntity.setClassEntityList(ClassMapper.INSTANCE.toEntities(teacherResource.getClassIds()));

        return TeacherMapper.INSTANCE.toResource(teacherRepository.save(teacherEntity));

    }
}

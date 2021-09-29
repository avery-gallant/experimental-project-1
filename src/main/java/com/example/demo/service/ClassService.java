package com.example.demo.service;


import com.example.demo.dao.ClassEntity;
import com.example.demo.dto.ClassResource;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassResource> getClasses() {
        return ClassMapper.INSTANCE.toResources(classRepository.findAll());
    }

    public ClassResource getClass(Long id) throws Exception {
        classExists(id);
        return ClassMapper.INSTANCE.toResource(classRepository.findById(id).get());
    }

    private void classExists(Long id) throws EntityNotFoundException {
        if (!classRepository.existsById(id)) {
            throw new EntityNotFoundException("Class does not exist");
        }
    }

    public void deleteClass(Long id) throws EntityNotFoundException {
        classExists(id);
        classRepository.deleteById(id);
    }

    public ClassResource addNewClass(ClassResource classResource) {
        return ClassMapper.INSTANCE.toResource(classRepository.save(ClassMapper.INSTANCE.toEntity(classResource)));
    }

    public ClassResource updateFullClass(ClassResource classResource, Long id) throws EntityNotFoundException {
        classExists(id);
        if (classResource.getClassId() == null) {
            classResource.setClassId(id);
        }
        return ClassMapper.INSTANCE.toResource(classRepository.save(ClassMapper.INSTANCE.toEntity(classResource)));
    }

    public ClassResource updatePartialClass(ClassResource classResource, Long id) throws EntityNotFoundException {
        classExists(id);
        ClassEntity classEntity = classRepository.getById(id);

        if (classResource.getAttendees() != null)
            classEntity.setAttendees(classResource.getAttendees());

        if (classResource.getClassId() != null)
            classEntity.setClassId(classResource.getClassId());

        //if (classResource.getTeacher() != null)
        //    classEntity.setTeacherEntity(TeacherMapper.INSTANCE.toEntity(classResource.getTeacher()));

        if (classResource.getName() != null)
            classEntity.setName(classResource.getName());

        //if (classResource.getGrades() != null)
        //    classEntity.setGradeEntityList(GradeMapper.INSTANCE.toEntities(classResource.getGrades()));

        //if (classResource.getStudents() != null)
        //    classEntity.setStudentEntityList(StudentMapper.INSTANCE.toEntities(classResource.getStudents()));
        return ClassMapper.INSTANCE.toResource(classRepository.save(classEntity));

    }
}

package com.example.demo.service;


import com.example.demo.dao.GradeEntity;
import com.example.demo.dto.GradeResource;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.GradeMapper;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public List<GradeResource> getGrades() {
        return GradeMapper.INSTANCE.toResources(gradeRepository.findAll());
    }

    public GradeResource getGrade(Long id) throws Exception {
        gradeExists(id);
        return GradeMapper.INSTANCE.toResource(gradeRepository.findById(id).get());
    }

    private void gradeExists(Long id) throws EntityNotFoundException {
        if (!gradeRepository.existsById(id)) {
            throw new EntityNotFoundException("Grade does not exist");
        }
    }

    public void deleteGrade(Long id) throws EntityNotFoundException {
        gradeExists(id);
        gradeRepository.deleteById(id);
    }

    public GradeResource addNewGrade(GradeResource grade) {
        return GradeMapper.INSTANCE.toResource(gradeRepository.save(GradeMapper.INSTANCE.toEntity(grade)));
    }

    public GradeResource updateFullGrade(GradeResource grade, Long id) throws EntityNotFoundException {
        gradeExists(id);
        //if (grade.getGradeId() == null) {
        //    grade.setGradeId(id);
        //}
        return GradeMapper.INSTANCE.toResource(gradeRepository.save(GradeMapper.INSTANCE.toEntity(grade)));
    }

    public GradeResource updatePartialGrade(GradeResource gradeResource, Long id) throws EntityNotFoundException {
        gradeExists(id);
        GradeEntity gradeEntity = gradeRepository.getById(id);

        if (gradeResource.getGrade() != null)
            gradeEntity.setGrade(gradeResource.getGrade());

        if (gradeResource.getCourse() != null)
            gradeEntity.setClassEntity(ClassMapper.INSTANCE.toEntity(gradeResource.getCourse()));

        if (gradeResource.getRecord() != null)
            gradeEntity.setRecordEntity(RecordMapper.INSTANCE.toEntity(gradeResource.getRecord()));

        return GradeMapper.INSTANCE.toResource(gradeRepository.save(gradeEntity));

    }
}

package com.example.demo.service;

import com.example.demo.dao.RecordEntity;
import com.example.demo.dto.RecordResource;
import com.example.demo.mapper.RecordMapper;
import com.example.demo.repository.RecordRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private StudentRepository studentRepository;

    public List<RecordResource> getRecords() {
        return RecordMapper.INSTANCE.toResources(recordRepository.findAll());
    }

    public RecordResource getRecord(Long id) throws Exception {
        recordExists(id);
        return RecordMapper.INSTANCE.toResource(recordRepository.findById(id).get());
    }

    private void recordExists(Long id) throws EntityNotFoundException {
        if (!recordRepository.existsById(id)) {
            throw new EntityNotFoundException("Record does not exist");
        }
    }

    public void deleteRecord(Long id) throws EntityNotFoundException {
        recordExists(id);
        recordRepository.deleteById(id);
    }

    public RecordResource addNewRecord(RecordResource record) {
        /*record.setStudent(
                StudentMapper.INSTANCE.toResource(
                        studentRepository.getById(record.getStudentId())
                )
        );*/
        RecordEntity recordEntity = new RecordEntity();
        recordEntity = RecordMapper.INSTANCE.toEntity(record);
        return RecordMapper.INSTANCE.toResource(recordRepository.save(recordEntity));
    }

    public RecordResource updateFullRecord(RecordResource record, Long id) throws EntityNotFoundException {
        recordExists(id);
        if (record.getRecordId() == null) {
            record.setRecordId(id);
        }
        return RecordMapper.INSTANCE.toResource(recordRepository.save(RecordMapper.INSTANCE.toEntity(record)));
    }

    public RecordResource updatePartialRecord(RecordResource recordResource, Long id) throws EntityNotFoundException {
        recordExists(id);
        RecordEntity recordEntity = recordRepository.getById(id);

        if (recordResource.getRecordId() != null)
            recordEntity.setRecordId(recordResource.getRecordId());

        if (recordResource.getGradePointAverage() != null)
            recordEntity.setGpa(recordResource.getGradePointAverage());

        //if (recordResource.getGradeIds() != null)
        //    recordEntity.setGrade(GradeMapper.INSTANCE.toEntities(recordResource.getGrades()));

        //if (recordResource.getStudent() != null)
        //    recordEntity.setStudentEntity(StudentMapper.INSTANCE.toEntity(recordResource.getStudent()));

        return RecordMapper.INSTANCE.toResource(recordRepository.save(recordEntity));

    }
}

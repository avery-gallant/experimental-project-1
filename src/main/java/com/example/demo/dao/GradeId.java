package com.example.demo.dao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class GradeId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long recordId;
    private Long classId;

    public GradeId() {

    }

    public GradeId(Long recordId, Long classId) {
        super();
        this.recordId = recordId;
        this.classId = classId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((recordId == null) ? 0 : recordId.hashCode());
        result = prime * result
                + ((classId == null) ? 0 : classId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GradeId other = (GradeId) obj;
        return Objects.equals(getRecordId(), other.getRecordId()) && Objects.equals(getClassId(), other.getClassId());
    }
}

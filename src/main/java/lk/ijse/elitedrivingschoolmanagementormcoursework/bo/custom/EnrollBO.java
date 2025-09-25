package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.StudentsDTO;

public interface EnrollBO extends SuperBO {
    public boolean saveStudents(StudentsDTO dto) throws Exception;
    public boolean updateStudents(StudentsDTO dto) throws Exception;
}
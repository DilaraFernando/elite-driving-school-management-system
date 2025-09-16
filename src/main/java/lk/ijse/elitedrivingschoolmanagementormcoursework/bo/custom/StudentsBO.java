package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.StudentsDTO;

import java.util.List;
import java.util.Optional;

public interface StudentsBO extends SuperBO {
    List<StudentsDTO> getAllUsers() throws Exception;

    String getLastStudentId() throws Exception;

    boolean saveStudents(StudentsDTO t) throws Exception;

    boolean updateStudents(StudentsDTO t) throws Exception;

    boolean deleteStudents(String id) throws Exception;

    List<String> getAllStudentIds() throws Exception;

    Optional<StudentsDTO> findByStudentId(String id) throws Exception;
}


package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.StudentsBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.StudentsDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.StudentsDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentsBOImpl implements StudentsBO {

    private final StudentsDAO studentsDAO = (StudentsDAO) DAOFactory.getInstance().getDAO(DAOTypes.STUDENTS);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<StudentsDTO> getAllStudents() throws Exception {
        List<Students> studentsList = studentsDAO.getAll();
        List<StudentsDTO> studentsDTOList = new ArrayList<>();
        for (Students students : studentsList) {
            studentsDTOList.add(converter.getStudentsDTO(students));
        }
        return studentsDTOList;
    }

    @Override
    public String getLastStudentId() throws Exception {
        return studentsDAO.getLastId();
    }

    @Override
    public boolean saveStudents(StudentsDTO t) throws Exception {
        Optional<Students> students = studentsDAO.findById(t.getStudentId());
        if (students.isPresent()) {
            throw new DuplicateException("Student already exists");
        }
        return studentsDAO.save(converter.getStudentsEntity(t));
    }

    @Override
    public boolean updateStudents(StudentsDTO t) throws Exception {
        Optional<Students> students = studentsDAO.findById(t.getStudentId());
        if (students.isEmpty()) {
            throw new Exception("Student not found");
        }
        return studentsDAO.update(converter.getStudentsEntity(t));
    }

    @Override
    public boolean deleteStudents(String id) throws Exception {
        Optional<Students> students = studentsDAO.findById(id);
        if (students.isEmpty()) {
            throw new Exception("Student not found");
        }
        return studentsDAO.delete(id);
    }

    @Override
    public List<String> getAllStudentIds() throws Exception {
        return studentsDAO.getAllIds();
    }

    @Override
    public Optional<StudentsDTO> findByStudentId(String id) throws Exception {
        Optional<Students> students = studentsDAO.findById(id);
        if (students.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(converter.getStudentsDTO(students.get()));
    }

    @Override
    public String generateNewStudentId() {
        return studentsDAO.generateNewId();
    }
}
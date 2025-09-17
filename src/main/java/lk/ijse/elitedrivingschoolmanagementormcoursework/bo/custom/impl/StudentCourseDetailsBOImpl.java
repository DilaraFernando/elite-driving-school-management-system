package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.StudentCourseDetailsBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.CourseDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.StudentCourseDetailsDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.StudentsDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.StudentCourseDetailsDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.Course;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.StudentsCourseDetails;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentCourseDetailsBOImpl implements StudentCourseDetailsBO {

    private final StudentCourseDetailsDAO studentCourseDetailsDAO = (StudentCourseDetailsDAO) DAOFactory.getInstance().getDAO(DAOTypes.STUDENT_COURSE_DETAILS);
    private final StudentsDAO studentsDAO =(StudentsDAO) DAOFactory.getInstance().getDAO(DAOTypes.STUDENTS);
    private final CourseDAO courseDAO = (CourseDAO) DAOFactory.getInstance().getDAO(DAOTypes.COURSE);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<StudentCourseDetailsDTO> getAllStudentCourseDetails() throws Exception {
        List<StudentsCourseDetails> studentCourseDetails = studentCourseDetailsDAO.getAll();
        List<StudentCourseDetailsDTO> studentCourseDetailsDTOs = new ArrayList<>();
        for (StudentsCourseDetails details : studentCourseDetails) {
            studentCourseDetailsDTOs.add(converter.getStudentCourseDetailsDTO(details));
        }
        return studentCourseDetailsDTOs;
    }

    @Override
    public String getLastStudentCourseDetailId() throws Exception {
        return studentCourseDetailsDAO.getLastId();
    }

    @Override
    public boolean saveStudentCourseDetails(StudentCourseDetailsDTO t) throws Exception {
        Optional<Students> studentExist = studentsDAO.findById(t.getStudentId());
        Optional<Course> courseExist = courseDAO.findById(t.getCourseId());
        Optional<StudentsCourseDetails> detailsExist = studentCourseDetailsDAO.findById(t.getStudentCourseId());

        if (detailsExist.isPresent()) {
            throw new DuplicateException("Student Course details already exists");
        }

        if (studentExist.isPresent() && courseExist.isPresent()) {
            return studentCourseDetailsDAO.save(converter.getStudentCourseDetailsEntity(t));
        }
        throw new NotFoundException("Course or Student not found");

    }

    @Override
    public boolean updateStudentCourseDetails(StudentCourseDetailsDTO t) throws Exception {
        Optional<StudentsCourseDetails> detailsExists = studentCourseDetailsDAO.findById(t.getStudentCourseId());

        if (detailsExists.isPresent()) {
            return studentCourseDetailsDAO.update(converter.getStudentCourseDetailsEntity(t));
        }
        throw new NotFoundException("StudentCourseDetails not found");
    }

    @Override
    public boolean deleteStudentCourseDetails(String id) throws Exception {
        Optional<StudentsCourseDetails> detailsExists = studentCourseDetailsDAO.findById(id);

        if (detailsExists.isPresent()) {
            return studentCourseDetailsDAO.delete(id);
        }
        throw new NotFoundException("StudentCourseDetails not found");
    }

    @Override
    public List<String> getAllStudentCourseDetailIds() throws Exception {
        return studentCourseDetailsDAO.getAllIds();
    }

    @Override
    public Optional<StudentCourseDetailsDTO> findByStudentCourseDetailId(String id) throws Exception {
        Optional<StudentsCourseDetails> details = studentCourseDetailsDAO.findById(id);
        if (details.isPresent()) {
            return Optional.of(converter.getStudentCourseDetailsDTO(details.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String generateNewStudentCourseDetailsId() {
        return "";
    }
}
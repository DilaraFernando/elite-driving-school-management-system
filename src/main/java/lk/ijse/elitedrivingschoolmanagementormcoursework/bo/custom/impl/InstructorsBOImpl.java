package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.InstructorsBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.InstructorsDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.InstructorsDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.Instructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InstructorsBOImpl implements InstructorsBO {

    private final InstructorsDAO instructorsDAO = (InstructorsDAO) DAOFactory.getInstance().getDAO(DAOTypes.INSTRUCTORS);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<InstructorsDTO> getAllInstructors() throws Exception {
        List<Instructors> instructorsList = instructorsDAO.getAll();
        List<InstructorsDTO> instructorsDTOList = new ArrayList<>();
        for (Instructors instructors : instructorsList) {
            instructorsDTOList.add(converter.getInstructorsDTO(instructors));
        }
        return instructorsDTOList;
    }

    @Override
    public String getLastInstructorId() throws Exception {
        return  instructorsDAO.getLastId();
    }

    @Override
    public boolean saveInstructors(InstructorsDTO t) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(t.getInstructor_id());
        if (instructors.isPresent()) {
            throw new DuplicateException("Instructor already exists");
        }
        return instructorsDAO.save(converter.getInstructorsEntity(t));
    }

    @Override
    public boolean updateInstructors(InstructorsDTO t) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(t.getInstructor_id());
        if (instructors.isEmpty()) {
            throw new NotFoundException("Instructor not found");
        }
        return instructorsDAO.update(converter.getInstructorsEntity(t));
    }

    @Override
    public boolean deleteInstructors(String id) throws Exception {
        Optional<Instructors> instructors = instructorsDAO.findById(id);
        if (instructors.isEmpty()) {
            throw new NotFoundException("Instructor not found");
        }
        return instructorsDAO.delete(id);
    }

    @Override
    public List<String> getAllInstructorIds() throws Exception {
        return instructorsDAO.getAllIds();
    }

    @Override
    public Optional<InstructorsDTO> findByInstructorId(String id) throws Exception {

        Optional<Instructors> instructors = instructorsDAO.findById(id);
        if (instructors.isPresent()) {
            return Optional.of(converter.getInstructorsDTO(instructors.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewInstructorId() {
        return "";
    }
}
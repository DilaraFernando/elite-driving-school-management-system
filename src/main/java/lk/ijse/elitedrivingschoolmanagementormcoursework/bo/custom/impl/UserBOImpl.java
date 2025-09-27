package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.UserBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.UserDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.UserDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOTypes.USER);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<UserDTO> getAllUsers() throws Exception {
        List<User> userList = userDAO.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(converter.getUserDTO(user));
        }
        return userDTOList;
    }

    @Override
    public String getLastUserId() throws Exception {
        return userDAO.getLastId();
    }

    @Override
    public boolean saveUsers(UserDTO t) throws Exception {
        Optional<User> user = userDAO.findById(t.getUserId());
        if (user.isPresent()) {
            throw new DuplicateException("User already exists");
        }
        return userDAO.save(converter.getUserEntity(t));
    }

    @Override
    public boolean updateUsers(UserDTO t) throws Exception {
        Optional<User> user = userDAO.findById(t.getUserId());
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.update(converter.getUserEntity(t));
    }

    @Override
    public boolean deleteUsers(String id) throws Exception {
        Optional<User> user = userDAO.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }
        return userDAO.delete(id);
    }

    @Override
    public List<String> getAllUserIds() throws Exception {
        return userDAO.getAllIds();
    }

    @Override
    public Optional<UserDTO> findByUserId(String id) throws Exception {
        Optional<User> user = userDAO.findById(id);
        if (user.isPresent()) {
            return Optional.of(converter.getUserDTO(user.get()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String generateNewUserId() {
        return userDAO.generateNewId();
    }

    @Override
    public UserDTO getUserByUsername(String inputUsername) {
        User user = userDAO.getUserByUsername(inputUsername);
        return converter.getUserDTO(user);
    }
}
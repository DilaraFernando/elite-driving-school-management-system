package lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom;

import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.CrudDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.User;

public interface UserDAO extends CrudDAO<User> {
    public User getUserByUsername(String userName);
}

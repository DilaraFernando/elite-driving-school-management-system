package lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom;

import jakarta.persistence.Query;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.CrudDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.SuperDAO;

public interface QueryDAO extends SuperDAO {
    public int getStudentCountForLesson(String lessonId);
}

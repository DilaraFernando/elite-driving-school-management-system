package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.QueryBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.QueryDAO;

public class QueryBOImpl implements QueryBO {
    private final QueryDAO queryDAO = (QueryDAO) DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
    @Override
    public double getTotalCourseAmountByStudentId(String studentId) throws Exception {
        return queryDAO.getTotalCourseAmountByStudentId(studentId);
    }

}
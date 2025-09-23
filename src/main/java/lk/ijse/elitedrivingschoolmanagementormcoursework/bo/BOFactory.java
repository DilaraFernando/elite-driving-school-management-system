package lk.ijse.elitedrivingschoolmanagementormcoursework.bo;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl.*;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.SuperDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){
        return boFactory == null ? (boFactory=new BOFactory()) : boFactory;
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){

            case COURSE :
                return new CourseBOImpl();
                case INSTRUCTORS:
                return new InstructorsBOImpl();
            case LESSONS:
                return new LessonsBOImpl();
            case PAYMENTS:
                return new PaymentsBOImpl();
            case QUERY:
                return new QueryBOImpl();
            case STUDENTS:
                return new StudentsBOImpl();
            case USER:
                return new UserBOImpl();

            default:
                return null;

        }
    }
}
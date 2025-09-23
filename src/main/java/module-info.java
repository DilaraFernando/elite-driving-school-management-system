module lk.ijse.elite_driving_school_management_orm_coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;   // if you're using JDBC
    requires org.hibernate.orm.core; // if Hibernate is used
    requires jakarta.persistence;    // if JPA is used
    requires static lombok;
    requires jbcrypt;
    requires java.naming;
    requires javafx.graphics;

    opens lk.ijse.elitedrivingschoolmanagementormcoursework.entity to org.hibernate.orm.core, javafx.base;
    opens lk.ijse.elitedrivingschoolmanagementormcoursework.dto.tm to javafx.base;

    opens lk.ijse.elitedrivingschoolmanagementormcoursework.Controller to javafx.fxml;

    exports lk.ijse.elitedrivingschoolmanagementormcoursework.Controller;
    exports lk.ijse.elitedrivingschoolmanagementormcoursework;
    exports lk.ijse.elitedrivingschoolmanagementormcoursework.dto;
    exports lk.ijse.elitedrivingschoolmanagementormcoursework.dto.tm;
    exports lk.ijse.elitedrivingschoolmanagementormcoursework.entity;
}

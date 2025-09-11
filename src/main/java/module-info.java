module lk.ijse.elite_driving_school_management_orm_coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires jakarta.persistence;


    opens lk.ijse.elite_driving_school_management_orm_coursework to javafx.fxml;
    exports lk.ijse.elitedrivingschoolmanagementormcoursework;
}
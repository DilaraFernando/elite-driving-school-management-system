package lk.ijse.elitedrivingschoolmanagementormcoursework.dto;

import lombok.*;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class InstructorsDTO {
    private String instructor_id;
    private  String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String specialization;
    private String availability;
    private ArrayList<LessonsDTO> lessons;
    private ArrayList<CourseDTO> courses;
}

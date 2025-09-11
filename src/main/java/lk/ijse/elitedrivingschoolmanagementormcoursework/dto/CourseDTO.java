package lk.ijse.elitedrivingschoolmanagementormcoursework.dto;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class CourseDTO {

    private String course_id;
    private String course_name;
    private String duration;
    private double fee;
    private String description;
    private String instructor_id;
    private ArrayList<StudentCourseDetailsDTO> student_course_details;
    private ArrayList<LessonsDTO> lessons;

}


package lk.ijse.elitedrivingschoolmanagementormcoursework.dto;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class StudentsDTO {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private Date dob;
    private Date registrationDate;
    private ArrayList<StudentCourseDetailsDTO> studentCourseDetails;
    private ArrayList<LessonsDTO> lessons;
    private ArrayList<PaymentDTO> payments;
}

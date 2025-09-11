package lk.ijse.elitedrivingschoolmanagementormcoursework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "students_course_details")
public class StudentsCourseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String studentCourseId;

    @ManyToOne
    @JoinColumn(name = "studentId" , referencedColumnName = "studentId")
    private Students student;

    @ManyToOne
    @JoinColumn(name = "course_id" , referencedColumnName = "course_id")
    private Course course;
    @Column
    private Date enrollmentDate;

    @Column
    private String status;

    @Column
    private String grade;
}

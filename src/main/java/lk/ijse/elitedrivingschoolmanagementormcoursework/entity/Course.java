package lk.ijse.elitedrivingschoolmanagementormcoursework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column
    private String course_id;

    @Column(nullable = false)
    private String course_name;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private double fee;

    @Column(nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "instructor_id")
    private Instructors instructors;

    @ManyToMany
    private List<Students> students ;


    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.ALL
    )
    private List<Lessons> lessons;
}
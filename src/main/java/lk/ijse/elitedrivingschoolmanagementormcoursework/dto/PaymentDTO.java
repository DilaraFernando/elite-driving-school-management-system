package lk.ijse.elitedrivingschoolmanagementormcoursework.dto;

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class PaymentsDTO {
    private String paymentId;
    private String studentId;
    private Date paymentDate;
    private double amount;
    private String paymentMethod;
    private String status;
}

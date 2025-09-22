package lk.ijse.elitedrivingschoolmanagementormcoursework.dto;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class PaymentDTO {
    private String paymentId;
    private Date paymentDate;
    private double amount;
    private String paymentMethod;
    private String status;
    private String studentId;
}
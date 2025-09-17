package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom;


import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.SuperBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.PaymentDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.PaymentDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentsBO extends SuperBO {
    List<PaymentDTO> getAllPayments() throws Exception;

    String getLastPaymentId() throws Exception;

    boolean savePayments(PaymentDTO t) throws Exception;

    boolean updatePayments(PaymentDTO t) throws Exception;

    boolean deletePayments(String id) throws Exception;

    List<String> getAllPaymentIds() throws Exception;

    Optional<PaymentDTO> findByPaymentId(String id) throws Exception;

    String generateNewPaymentId();


}

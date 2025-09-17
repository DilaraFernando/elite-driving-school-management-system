package lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.impl;

import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.custom.PaymentsBO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.DuplicateException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.exception.NotFoundException;
import lk.ijse.elitedrivingschoolmanagementormcoursework.bo.util.EntityDTOConverter;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOFactory;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.DAOTypes;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dao.custom.PaymentDAO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.dto.PaymentDTO;
import lk.ijse.elitedrivingschoolmanagementormcoursework.entity.Payments;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentsBOImpl implements PaymentsBO {

    private final PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOTypes.PAYMENTS);
    private final EntityDTOConverter converter = new EntityDTOConverter();

    @Override
    public List<PaymentDTO> getAllPayments() throws Exception {
        List<Payments> paymentsList = paymentDAO.getAll();
        List<PaymentDTO> paymentsDTOList = new ArrayList<>();
        for (Payments payments : paymentsList) {
            paymentsDTOList.add(converter.getPaymentsDTO(payments));
        }
        return paymentsDTOList;
    }

    @Override
    public String getLastPaymentId() throws Exception {
        return paymentDAO.getLastId();
    }

    @Override
    public boolean savePayments(PaymentDTO t) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(t.getPaymentId());
        if (payments.isPresent()) {
            throw new DuplicateException("Payment already exists");
        }
        if(t.getStudentId()==null){
            throw new NotFoundException("Student ID cannot be null");
        }
        return paymentDAO.save(converter.getPaymentsEntity(t));
    }

    @Override
    public boolean updatePayments(PaymentDTO t) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(t.getPaymentId());
        if (payments.isEmpty()) {
            throw new NotFoundException("Payment not found");
        }
        return paymentDAO.update(converter.getPaymentsEntity(t));
    }

    @Override
    public boolean deletePayments(String id) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(id);
        if (payments.isEmpty()) {
            throw new NotFoundException("Payment not found");
        }
        return paymentDAO.delete(id);
    }

    @Override
    public List<String> getAllPaymentIds() throws Exception {
        return paymentDAO.getAllIds();
    }

    @Override
    public Optional<PaymentDTO> findByPaymentId(String id) throws Exception {
        Optional<Payments> payments = paymentDAO.findById(id);
        if (payments.isPresent()) {
            return Optional.of(converter.getPaymentsDTO(payments.get()));
        }
        return Optional.empty();
    }

    @Override
    public String generateNewPaymentId() {
        return paymentDAO.generateNewId();
    }
}
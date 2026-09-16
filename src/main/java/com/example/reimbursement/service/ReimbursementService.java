package com.example.reimbursement.service;

import com.example.reimbursement.dto.ReimbursementRequest;
import com.example.reimbursement.entity.Reimbursement;
import com.example.reimbursement.repository.ReimbursementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReimbursementService {

    private final ReimbursementRepository repository;
    private final ApprovalService approvalService;

    public ReimbursementService(
            ReimbursementRepository repository,
            ApprovalService approvalService) {

        this.repository = repository;
        this.approvalService = approvalService;
    }

    public Reimbursement createReimbursement(
            ReimbursementRequest request) {

        Reimbursement reimbursement =
                new Reimbursement();

        reimbursement.setEmployeeId(
                request.getEmployeeId());

        reimbursement.setExpenseType(
                request.getExpenseType());

        reimbursement.setAmount(
                request.getAmount());

        reimbursement.setDescription(
                request.getDescription());

        reimbursement.setStatus(
                approvalService.determineStatus(
                        request.getAmount()));

        return repository.save(
                reimbursement);
    }

    public List<Reimbursement> getAll() {

        return repository.findAll();
    }

    public Reimbursement getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Reimbursement not found"));
    }

    public Reimbursement approveReimbursement(
            Long id) {

        Reimbursement reimbursement =
                getById(id);

        reimbursement.setStatus(
                "APPROVED");

        return repository.save(
                reimbursement);
    }

    public Reimbursement rejectReimbursement(
            Long id) {

        Reimbursement reimbursement =
                getById(id);

        reimbursement.setStatus(
                "REJECTED");

        return repository.save(
                reimbursement);
    }

    public List<Reimbursement> getByStatus(
            String status) {

        return repository.findByStatus(status);
    }
}
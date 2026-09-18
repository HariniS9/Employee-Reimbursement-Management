package com.example.reimbursement.service;

import com.example.reimbursement.dto.ReimbursementRequest;
import com.example.reimbursement.entity.Reimbursement;
import com.example.reimbursement.repository.ReimbursementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.junit.jupiter.api.Assertions;

@ExtendWith(MockitoExtension.class)
class ReimbursementServiceTest {

    @Mock
    private ReimbursementRepository repository;

    @Mock
    private ApprovalService approvalService;

    @Mock
    private AuditService auditService;

    @InjectMocks
    private ReimbursementService reimbursementService;

    @Test
    void shouldCreateReimbursement() {

        ReimbursementRequest request =
                new ReimbursementRequest();

        request.setEmployeeId(1001L);
        request.setExpenseType("TRAVEL");
        request.setAmount(3000.0);
        request.setDescription("Client Visit");

        Mockito.when(
                        approvalService.determineStatus(
                                3000.0))
                .thenReturn("APPROVED");

        Reimbursement reimbursement =
                new Reimbursement();

        reimbursement.setId(1L);

        Mockito.when(
                        repository.save(
                                ArgumentMatchers.any(
                                        Reimbursement.class)))
                .thenReturn(reimbursement);

        Reimbursement result =
                reimbursementService
                        .createReimbursement(
                                request);

        Assertions.assertNotNull(result);

        Mockito.verify(repository)
                .save(
                        ArgumentMatchers.any(
                                Reimbursement.class));
    }
}
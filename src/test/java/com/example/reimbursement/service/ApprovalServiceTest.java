package com.example.reimbursement.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApprovalServiceTest {

    private final ApprovalService approvalService =
            new ApprovalService();

    @Test
    void shouldApproveAmountLessThan5000() {

        String status =
                approvalService.determineStatus(
                        3000.0);

        assertEquals(
                "APPROVED",
                status);
    }

    @Test
    void shouldReturnUnderReviewForAmountGreaterThan5000() {

        String status =
                approvalService.determineStatus(
                        12000.0);

        assertEquals(
                "UNDER_REVIEW",
                status);
    }
}
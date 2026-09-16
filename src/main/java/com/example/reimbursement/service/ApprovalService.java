package com.example.reimbursement.service;

import org.springframework.stereotype.Service;

@Service
public class ApprovalService {

    public String determineStatus(
            Double amount) {

        if (amount <= 5000) {
            return "APPROVED";
        }

        return "UNDER_REVIEW";
    }
}


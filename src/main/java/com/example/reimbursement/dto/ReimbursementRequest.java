package com.example.reimbursement.dto;

import lombok.Data;

@Data
public class ReimbursementRequest {

    private Long employeeId;

    private String expenseType;

    private Double amount;

    private String description;
}
package com.example.reimbursement.repository;

import com.example.reimbursement.entity.ReimbursementAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReimbursementAuditRepository
        extends JpaRepository<
        ReimbursementAuditLog,
        Long> {
}
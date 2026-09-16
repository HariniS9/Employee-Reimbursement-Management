package com.example.reimbursement.repository;

import com.example.reimbursement.entity.Reimbursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReimbursementRepository
        extends JpaRepository<Reimbursement, Long> {

    List<Reimbursement> findByStatus(String status);
}
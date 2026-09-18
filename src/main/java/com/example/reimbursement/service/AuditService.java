package com.example.reimbursement.service;

import com.example.reimbursement.entity.ReimbursementAuditLog;
import com.example.reimbursement.repository.ReimbursementAuditRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuditService {

    private final
    ReimbursementAuditRepository repository;

    public AuditService(
            ReimbursementAuditRepository repository) {

        this.repository = repository;
    }

    public List<ReimbursementAuditLog> getAllLogs() {

        return repository.findAll();
    }

    public void log(

            Long reimbursementId,

            String action,

            String source) {

        ReimbursementAuditLog log =
                ReimbursementAuditLog
                        .builder()
                        .reimbursementId(
                                reimbursementId)
                        .action(action)
                        .source(source)
                        .timestamp(
                                LocalDateTime.now())
                        .build();

        repository.save(log);
    }
}
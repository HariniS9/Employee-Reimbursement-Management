package com.example.reimbursement.controller;

import com.example.reimbursement.dto.ReimbursementRequest;
import com.example.reimbursement.entity.Reimbursement;
import com.example.reimbursement.service.ReimbursementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reimbursements")
public class ReimbursementController {

    private final ReimbursementService reimbursementService;

    public ReimbursementController(
            ReimbursementService reimbursementService) {

        this.reimbursementService = reimbursementService;
    }

    @PostMapping
    public ResponseEntity<Reimbursement> createReimbursement(
            @RequestBody ReimbursementRequest request) {

        return ResponseEntity.ok(
                reimbursementService.createReimbursement(
                        request));
    }

    @GetMapping
    public ResponseEntity<List<Reimbursement>> getAllReimbursements() {

        return ResponseEntity.ok(
                reimbursementService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reimbursement> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reimbursementService.getById(id));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<Reimbursement> approveReimbursement(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reimbursementService.approveReimbursement(id));
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Reimbursement> rejectReimbursement(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                reimbursementService.rejectReimbursement(id));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reimbursement>> getByStatus(
            @PathVariable String status) {

        return ResponseEntity.ok(
                reimbursementService.getByStatus(status));
    }
}
package com.example.manufacturingwebservice.controllers;

import com.example.manufacturingwebservice.dto.TransactionHistoryDTO;
import com.example.manufacturingwebservice.services.TransactionHistoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/transactionhistories")
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping("")
    public List<TransactionHistoryDTO> getAllTransactionHistories() {
        return transactionHistoryService.getAll();
    }

    @GetMapping("/{transactionID}")
    public ResponseEntity<TransactionHistoryDTO> getTransactionHistoryById(@PathVariable Integer transactionID) {
        Optional<TransactionHistoryDTO> transactionHistory = transactionHistoryService.getById(transactionID);
        return transactionHistory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public ResponseEntity<TransactionHistoryDTO> createTransactionHistory(@RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        TransactionHistoryDTO createdTransactionHistory = transactionHistoryService.create(transactionHistoryDTO);
        return ResponseEntity.ok(createdTransactionHistory);
    }

    @PutMapping("/{transactionID}")
    public ResponseEntity<TransactionHistoryDTO> updateTransactionHistory(
            @PathVariable Integer transactionID,
            @RequestBody TransactionHistoryDTO transactionHistoryDTO) {
        TransactionHistoryDTO updatedTransactionHistory = transactionHistoryService.update(transactionID, transactionHistoryDTO);
        if (updatedTransactionHistory != null) {
            return ResponseEntity.ok(updatedTransactionHistory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{transactionID}")
    public ResponseEntity<Void> deleteTransactionHistory(@PathVariable Integer transactionID) {
        transactionHistoryService.delete(transactionID);
        return ResponseEntity.noContent().build();
    }
}

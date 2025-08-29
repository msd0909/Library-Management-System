package com.wipro.libsystem.controller;

import com.wipro.libsystem.entity.BorrowTransaction;
import com.wipro.libsystem.service.BorrowTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class BorrowTransactionController {

    @Autowired
    private BorrowTransactionService transactionService;

    // Create
    @PostMapping
    public BorrowTransaction createTransaction(@RequestBody BorrowTransaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    // Get All
    @GetMapping
    public List<BorrowTransaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    // Get One
    @GetMapping("/{id}")
    public BorrowTransaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    // Update
    @PutMapping("/{id}")
    public BorrowTransaction updateTransaction(@PathVariable Long id, @RequestBody BorrowTransaction updated) {
        return transactionService.updateTransaction(id, updated);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return "Transaction with ID " + id + " deleted successfully!";
    }
}
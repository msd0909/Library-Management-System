package com.wipro.libsystem.service;

import com.wipro.libsystem.entity.BorrowTransaction;
import com.wipro.libsystem.entity.Book;
import com.wipro.libsystem.entity.Student;
import com.wipro.libsystem.repository.BorrowTransactionRepository;
import com.wipro.libsystem.repository.BookRepository;
import com.wipro.libsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowTransactionService {

    @Autowired
    private BorrowTransactionRepository transactionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BookRepository bookRepository;

    // Create new transaction
    public BorrowTransaction createTransaction(BorrowTransaction transaction) {
        Student student = studentRepository.findById(transaction.getStudent().getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Book book = bookRepository.findById(transaction.getBook().getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        transaction.setStudent(student);
        transaction.setBook(book);

        return transactionRepository.save(transaction);
    }

    // Get all transactions
    public List<BorrowTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Get single transaction
    public BorrowTransaction getTransactionById(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id " + id));
    }

    // Update transaction (e.g. return date)
    public BorrowTransaction updateTransaction(Long id, BorrowTransaction updated) {
        BorrowTransaction tx = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        tx.setIssueDate(updated.getIssueDate());
        tx.setDueDate(updated.getDueDate());
        tx.setReturnDate(updated.getReturnDate());

        return transactionRepository.save(tx);
    }

    // Delete transaction
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
package com.wipro.libsystem.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "transactions")
public class BorrowTransaction {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate issueDate;
	    private LocalDate dueDate;
	    private LocalDate returnDate;

	    @ManyToOne
	    @JoinColumn(name = "student_id")
	    private Student student;

	    @ManyToOne
	    @JoinColumn(name = "book_id")
	    private Book book;

	    public BorrowTransaction() {}

	    public BorrowTransaction(LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, Student student, Book book) {
	        this.issueDate = issueDate;
	        this.dueDate = dueDate;
	        this.returnDate = returnDate;
	        this.student = student;
	        this.book = book;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getIssueDate() {
			return issueDate;
		}

		public void setIssueDate(LocalDate issueDate) {
			this.issueDate = issueDate;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public LocalDate getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(LocalDate returnDate) {
			this.returnDate = returnDate;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

	    
	}



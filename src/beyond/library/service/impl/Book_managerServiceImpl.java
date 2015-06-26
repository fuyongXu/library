package beyond.library.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import beyond.library.dao.Book_managerDAO;
import beyond.library.medol.Book_manager;
import beyond.library.service.BookService;
import beyond.library.service.Book_managerService;
import beyond.library.service.StudentService;

@Component
public class Book_managerServiceImpl implements Book_managerService {

	private Book_managerDAO book_managerDAO;
	private BookService bookService;
	private StudentService studentService;

	public Book_manager login(String book_manager_id, String password) {

		Book_manager bookManager = book_managerDAO
				.getBookManagerbyId(book_manager_id);
		if (bookManager != null && bookManager.getPassword().equals(password))
			
			return bookManager;
		return null;
	}
	
	@Resource(name = "book_mangerDAOImpl")
	public void setBook_managerDAO(Book_managerDAO bookManagerDAO) {
		book_managerDAO = bookManagerDAO;
	}

	public Book_managerDAO getBook_managerDAO() {
		return book_managerDAO;
	}

	public BookService getBookService() {
		return bookService;
	}

	@Resource(name="bookServiceImpl")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name="studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}

package beyond.library.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Student;
import beyond.library.service.BookService;

import com.opensymphony.xwork2.Action;

@Component("borrowBookAction")
@Scope("prototype")
public class BorrowBookAction implements Action, SessionAware {

	private String book_id;
	private BookService bookService;
	private Map<String, Object> session;
	private String borrowedResult;

	public String execute() throws Exception {
		borrowBook();
		return "borrow_result";
	}

	private void borrowBook() {

		Student student = (Student) session.get("STUDENT_INFO");
		borrowedResult = bookService.borrow_book(student
				.getStudent_id(), book_id);
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_id() {
		return book_id;
	}

	@Resource(name = "bookServiceImpl")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public void setBorrowedResult(String borrowedResult) {
		this.borrowedResult = borrowedResult;
	}

	public String getBorrowedResult() {
		return borrowedResult;
	}

}

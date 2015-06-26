package beyond.library.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.service.BookService;

import com.opensymphony.xwork2.Action;
/**
 * 学生书本的续借业务
 * @author Administrator
 *
 */
@Component("renewBookAction")
@Scope("prototype")
public class RenewBookAction implements Action {

	private String book_id;
	private String student_id;
	private BookService bookService;
	private String renewResult;
	
	public String execute() throws Exception {
		renewBook();
		return "renew";
	}
	
	private void renewBook() {
		student_id = bookService.getBookByBook_Id(book_id).getStudent().getStudent_id();
		setRenewResult(bookService.renewBook(book_id));
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

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setRenewResult(String renewResult) {
		this.renewResult = renewResult;
	}

	public String getRenewResult() {
		return renewResult;
	}
	
}

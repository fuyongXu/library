package beyond.library.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book;
import beyond.library.service.BookService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 学生还书业务办理
 * @author Administrator
 *
 */
@Component("returnBookAction")
@Scope("prototype")
public class ReturnBookAction implements Action, SessionAware {

    private String book_id;
    private BookService bookService;
    private Map<String, Object> session;
    private String returnResult;

    public String execute() throws Exception {
	returnBook();
	return "returnResult";
    }

    private void returnBook() {

	Book book = bookService.getBookByBook_Id(book_id);
	returnResult = bookService.cancel_borrowed(book_id);
	if (returnResult.equals(InfoUtil.RETURN_SUCCESS)) {
	    List<Book> returnedBooks =  (List<Book>) session
		    .get("RETURNED_BOOKS");
	    returnedBooks.add(0, book);
	    session.put("RETURNED_BOOKS", returnedBooks);
	}
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
	this.session = arg0;
    }

    public void setReturnResult(String returnResult) {
	this.returnResult = returnResult;
    }

    public String getReturnResult() {
	return returnResult;
    }

}

package beyond.library.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Component;

import beyond.library.medol.Student;
import beyond.library.service.BookService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;
@Component
public class ReservationBookAction implements Action, SessionAware {

    private Map<String, Object> session;
    private BookService bookService;
    private String book_id;
    private String result;
    
    public String execute() throws Exception {
	reservation();
	return "result";
    }
    
    private void reservation(){
	String student_id = ((Student) session.get("STUDENT_LOGIN")).getStudent_id();
	result = bookService.book_reservation(book_id, student_id);
	if("".equals(result))
	    result = InfoUtil.RESERVATION_SUCCESS;
    }

    @Resource(name="bookServiceImpl")
    public void setBookService(BookService bookService) {
	this.bookService = bookService;
    }

    public BookService getBookService() {
	return bookService;
    }

    public void setBook_id(String book_id) {
	this.book_id = book_id;
    }

    public String getBook_id() {
	return book_id;
    }

    public void setResult(String result) {
	this.result = result;
    }

    public String getResult() {
	return result;
    }

    public void setSession(Map<String, Object> arg0) {
	session = arg0;
    }

}

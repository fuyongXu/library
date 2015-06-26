package beyond.library.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book_view;
import beyond.library.medol.Student;
import beyond.library.service.StudentService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 由这个action可以让管理员转到对某一学生的业务办理页面
 * 
 * @author Administrator
 * 
 */
@Component("studentHandlerAction")
@Scope("prototype")
public class StudentHandlerAction implements Action, SessionAware {

	private StudentService studentService;
	private String student_id;
	private List<Book_view> books;
	// 已经预阅的书本
	private List<Book_view> reservationBooks;
	private Map<String, Object> session;
	private String borrowedResult;
	private String result;

	public String execute() throws Exception {
		if (getStudentAndBorrowedBooksByStudent_id())
			return "studentHandler";
		return "noexist";
	}

	// 得到学生的信息和学生借书的书本信息，并存到session会话中
	private boolean getStudentAndBorrowedBooksByStudent_id() {

		if (student_id != null && !"".equals(student_id)) {
			Student student = studentService.get_student_by_id(student_id);
			getReservationBooks(student_id);
			if (student == null) {
				result = InfoUtil.STUDENT_NO_EXIST;
				return false;
			}
			session.put("STUDENT_INFO", student);
		} else {
			Student student = (Student) session.get("STUDENT_INFO");
			if (student != null) {
				student_id = student.getStudent_id();
			} else {
				result = InfoUtil.STUDENT_ID_NULL;
				return false;
			}
		}
		books = studentService.get_borrow_books(student_id);

		return true;
	}

	private void getReservationBooks(String student_id) {
		reservationBooks = studentService
				.get_books_by_reservation_student_id(student_id);
	}

	public List<Book_view> getBooks() {
		return books;
	}

	public void setBooks(List<Book_view> books) {
		this.books = books;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String studentId) {
		student_id = studentId;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public void setBorrowedResult(String borrowedResult) {
		this.borrowedResult = borrowedResult;
	}

	public String getBorrowedResult() {
		return borrowedResult;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public void setReservationBooks(List<Book_view> reservationBooks) {
		this.reservationBooks = reservationBooks;
	}

	public List<Book_view> getReservationBooks() {
		return reservationBooks;
	}
}

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

import com.opensymphony.xwork2.Action;

@Component("borrowedInfo")
@Scope("prototype")
public class BorrowedInfoAction implements Action, SessionAware {

	private StudentService studentService;
	private List<Book_view> borrowedBooks;
	private List<Book_view> reservationBooks;
	private Map<String, Object> session;
	private String isSucess;

	public String execute() throws Exception {
		Student student = (Student) session.get("STUDENT_LOGIN");
		getReservationBooks(student.getStudent_id());
		this.borrowedBooks = studentService.get_borrow_books(student
				.getStudent_id());
		return "borrowedInfo";
	}

	private void getReservationBooks(String student_id) {
		reservationBooks = studentService
				.get_books_by_reservation_student_id(student_id);
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public List<Book_view> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book_view> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	@Resource(name = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setIsSucess(String isSucess) {
		this.isSucess = isSucess;
	}

	public String getIsSucess() {
		return isSucess;
	}

	public void setReservationBooks(List<Book_view> reservationBooks) {
		this.reservationBooks = reservationBooks;
	}

	public List<Book_view> getReservationBooks() {
		return reservationBooks;
	}

}

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
/**
 * 学生的欠款结算
 * @author Administrator
 *
 */
@Component("settleAccountsAction")
@Scope("prototype")
public class SettleAccountsAction implements Action, SessionAware {
	
	private Map<String, Object> session;
	private StudentService studentService;
	private List<Book_view> books;

	public String execute() throws Exception {
		if(settleAccounts())
			return "success";
		return "failed";
	}

	private boolean settleAccounts() {
		Student student = (Student) session.get("STUDENT_INFO");
		studentService.reduct_money(student.getStudent_id());
		student = studentService.get_student_by_id(student.getStudent_id());
		session.put("STUDENT_INFO", student);
		books = studentService.get_borrow_books(student.getStudent_id());
		if (student.getReduceMoney() == 0)
			return true;
		return false;
	}

	public List<Book_view> getBooks() {
		return books;
	}

	public void setBooks(List<Book_view> books) {
		this.books = books;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	@Resource(name = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

}

package beyond.library.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book;
import beyond.library.medol.Book_manager;
import beyond.library.service.Book_managerService;

import com.opensymphony.xwork2.Action;

/**
 * 图书管理员用户登录
 * @author Administrator
 *
 */
@Component("managerLoginAction")
@Scope("prototype")
public class ManagerLoginAction implements Action, SessionAware {

	private String id;
	private String password;
	private Book_managerService bookManagerService;
	private Book_manager bookManager;
	private Map<String, Object> session;

	public String execute() throws Exception {

		if (checkLogin()) {
			List<Book> returnedBooks = new ArrayList<Book>();
			session.put("RETURNED_BOOKS", returnedBooks);
			session.put("MANAGER_LOGIN", bookManager);
			if (session.get("STUDENT_LOGIN") != null)
				session.remove("STUDENT_LOGIN");
			return "success";
		}
		return "failed";
	}

	public Book_manager getBookManager() {
		return bookManager;
	}

	public void setBookManager(Book_manager bookManager) {
		this.bookManager = bookManager;
	}

	private boolean checkLogin() {
		if (id != null && !id.equals(""))
			bookManager = bookManagerService.login(id, password);
		if (bookManager != null)
			return true;
		return false;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Resource(name = "book_managerServiceImpl")
	public void setBookManagerService(Book_managerService bookManagerService) {
		this.bookManagerService = bookManagerService;
	}

	public Book_managerService getBookManagerService() {
		return bookManagerService;
	}
}

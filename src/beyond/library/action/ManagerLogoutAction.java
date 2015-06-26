package beyond.library.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book_manager;

import com.opensymphony.xwork2.Action;

/**
 * 管理员登录注销
 * @author Administrator
 *
 */
@Component("managerLogoutAction")
@Scope("prototype")
public class ManagerLogoutAction implements Action, SessionAware {

	private Map<String, Object> session;

	public String execute() throws Exception {

		if (logout())
			return "logoutSuccess";
		return "logoutFailed";
	}

	private boolean logout() {

		Book_manager bookManager = (Book_manager) session.get("MANAGER_LOGIN");
		if (bookManager != null)
			session.remove("MANAGER_LOGIN");
			session.remove("RETURNED_BOOKS");
			session.remove("STUDENT_INFO");
		return true;
	}

	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

}

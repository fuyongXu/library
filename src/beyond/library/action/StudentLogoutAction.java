package beyond.library.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

/**
 * 学生用户登录注销
 * @author Administrator
 *
 */
@Component("logoutAction")
@Scope("prototype")
public class StudentLogoutAction implements Action, SessionAware {

	private Map<String, Object> session;

	public String execute() throws Exception {

		logout();
		return "STUDENT_LOGOUT_SUCCESS";
	}

	private void logout() {
		if (session.get("STUDENT_LOGIN") != null)
			session.remove("STUDENT_LOGIN");
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}

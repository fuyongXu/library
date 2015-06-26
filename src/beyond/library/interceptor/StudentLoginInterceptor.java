package beyond.library.interceptor;

import java.util.Map;

import beyond.library.medol.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 拦截学生未登录就去访问一些action
 * @author Administrator
 *
 */
public class StudentLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		Student student = (Student) (session.get("STUDENT_LOGIN"));
		if (student != null)
			return invocation.invoke();
		return "STUDENT_LOGIN";
	}

}

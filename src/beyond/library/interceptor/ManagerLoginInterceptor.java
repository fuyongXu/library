package beyond.library.interceptor;

import java.util.Map;

import beyond.library.medol.Book_manager;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截管理员未登录就去访问一些action
 * @author Administrator
 *
 */
public class ManagerLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		Book_manager bookManager = (Book_manager) (session.get("MANAGER_LOGIN"));
		if (bookManager != null)
			return invocation.invoke();
		return "MANAGER_LOGIN";
	}

}

package beyond.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beyond.library.medol.Book_manager;

/**
 * 该过滤器是为了防止管理员未登录就去访问一些jsp页面
 * 
 * @author Administrator
 * 
 */
public class ManagerFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();
	Book_manager manager = (Book_manager) session
		.getAttribute("MANAGER_LOGIN");
	if (manager == null) {
	     request.getRequestDispatcher("/manager/managerLogin.jsp").forward(
	     request, response);
	    return;
	}
	filterChain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}

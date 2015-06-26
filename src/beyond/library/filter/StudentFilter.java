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

import beyond.library.medol.Student;

/**
 * 该过滤器是为了防止学生未登录就去访问一些jsp页面
 * 
 * @author Administrator
 * 
 */
public class StudentFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response,
	    FilterChain filterChain) throws IOException, ServletException {
	HttpServletRequest req = (HttpServletRequest) request;
	HttpSession session = req.getSession();
	Student student = (Student) session.getAttribute("STUDENT_LOGIN");
	if (student == null) {
	     request.getRequestDispatcher("/student/studentLogin.jsp").forward(
	     request, response);
	    return;
	}
	filterChain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}

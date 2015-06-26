package beyond.library.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book_manager;
import beyond.library.medol.Student;
import beyond.library.service.StudentService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 学生登录
 * 
 * @author Administrator
 * 
 */
@Component("studentLoginAction")
@Scope("prototype")
public class StudentLoginAction implements Action, SessionAware {

    private String student_id;
    private String password;

    private Student student;
    private StudentService studentService;
    private String loginResult;
    private Map<String, Object> session;

    public String execute() throws Exception {
	loginResult = studentLogin();
	// 如果成功登录，检查一下manager是不是已经登录，一个会话中不能登录两个用户
	if ("".equals(loginResult)) {
	    Book_manager bookManager = (Book_manager) session
		    .get("MANAGER_LOGIN");
	    if (bookManager != null)
		session.remove("MANAGER_LOGIN");
	    session.put("STUDENT_LOGIN", student);
	    return "loginSuccess";
	}
	return "loginFailed";
    }

    private String studentLogin() {
	// 如果输入的id号不存在，就返回不存在的错误信息
	if (studentService.get_student_by_id(student_id) == null) {
	    return InfoUtil.USER_ID_NOT_EXIST;
	}
	student = studentService.login_by_idAndpassword(student_id, password);
	//学生不存在，就返回学生不存在的错误信息
	if (student == null) {
	    return InfoUtil.PASSWORD_WRONG;
	}
	//如果学生等级为0，说明该学生帐号被冻结，不能时行任何操作
	if (student.getGrade() == 0) {
	    return InfoUtil.USER_LOCKED;
	}

	return "";
    }

    @Resource(name = "studentServiceImpl")
    public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
    }

    public StudentService getStudentService() {
	return studentService;
    }

    public Student getStudent() {
	return student;
    }

    public void setSession(Map<String, Object> arg0) {
	this.session = arg0;
    }

    public void setLoginResult(String loginResult) {
	this.loginResult = loginResult;
    }

    public String getLoginResult() {
	return loginResult;
    }

    public String getStudent_id() {
	return student_id;
    }

    public void setStudent_id(String studentId) {
	student_id = studentId;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setStudent(Student student) {
	this.student = student;
    }

}

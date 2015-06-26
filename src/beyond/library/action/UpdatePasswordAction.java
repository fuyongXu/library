package beyond.library.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import beyond.library.medol.Student;
import beyond.library.service.StudentService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 学生密码修改的action
 * @author Administrator
 *
 */
public class UpdatePasswordAction implements Action, SessionAware {

    private StudentService studentService;
    private Map<String, Object> session;
    private String newPassword;
    private String reNewPassword;
    private String oldPassword;
    private String updateResult;

    public String execute() throws Exception {
	if (updatePassword()) {
	    session.remove("STUDENT_LOGIN");
	    updateResult = InfoUtil.PASSWOED_UPDATE_SUCCESS;
	    return "success";
	}
	return "failed";
    }

    public String getNewPassword() {
	return newPassword;
    }

    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }
/**
 * 密码修改
 * @return
 */
    private boolean updatePassword() {
	//得到已登录学生的id号
	String studentId = ((Student) session.get("STUDENT_LOGIN"))
		.getStudent_id();
	//由旧密码和学生id得到学生对象实例
	Student student = studentService.login_by_idAndpassword(studentId,
		oldPassword);
	//如果学生为空，说明密码错误，并停止运算
	if (student == null) {
	    updateResult = InfoUtil.PASSWORD_WRONG;
	    return false;
	}
	//两次密码输入不一致，把错误信息传到页面
	if (!newPassword.equals(reNewPassword)) {
	    updateResult = InfoUtil.PASSWORD_AND_REPASSWORD_NOT_SAME;
	    return false;
	}
	//旧密码和新密码不能相同
	if(oldPassword.equals(newPassword)){
	    updateResult = InfoUtil.NEWPASSWORD_AND_OLDPASSWORD_SAME;
	    return false;
	}
	return studentService.updatePassword(student.getStudent_id(),
		newPassword);
    }

    @Resource(name = "studentServiceImpl")
    public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
    }

    public StudentService getStudentService() {
	return studentService;
    }

    public void setSession(Map<String, Object> arg0) {
	this.session = arg0;
    }

    public void setUpdateResult(String updateResult) {
	this.updateResult = updateResult;
    }

    public String getUpdateResult() {
	return updateResult;
    }

    public void setOldPassword(String oldPassword) {
	this.oldPassword = oldPassword;
    }

    public String getOldPassword() {
	return oldPassword;
    }

    public void setReNewPassword(String reNewPassword) {
	this.reNewPassword = reNewPassword;
    }

    public String getReNewPassword() {
	return reNewPassword;
    }
}

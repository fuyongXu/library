package beyond.library.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.dto.StudentRegisterDto;
import beyond.library.medol.Student;
import beyond.library.service.StudentService;
import beyond.library.util.Id_factory;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 学生注册
 * 
 * @author Administrator
 * 
 */
@Component("studentRegisterAction")
@Scope("prototype")
public class StudentRegisterAction implements Action,
	ModelDriven<StudentRegisterDto> {

    private StudentRegisterDto studentRegisterDto;
    // 用来传递注册失败的信息
    private String registerResult;
    private StudentService studentService;
    private String student_id;

    public String execute() throws Exception {
	if (addStudent())
	    return "success";
	return "failed";
    }

    private boolean addStudent() {
	// 密码不能为空
	if (studentRegisterDto.getPassword() == null
		|| "".equals(studentRegisterDto.getPassword())) {
	    registerResult = InfoUtil.PASSWORD_IS_NULL;
	    return false;
	}
	// 两次密码输入是不是一致
	if (!studentRegisterDto.getPassword().equals(
		studentRegisterDto.getRepassword())) {
	    registerResult = InfoUtil.PASSWORD_AND_REPASSWORD_NOT_SAME;
	    return false;
	}

	//生成id号
	do {
	    student_id = Id_factory.student_id_factory();
	} while (studentService.get_student_by_id(student_id) != null);

	//设置默认属性
	Student student = new Student();
	student.setStudent_name(studentRegisterDto.getName());
	student.setStudent_id(student_id);
	student.setPassword(studentRegisterDto.getPassword());
	return studentService.registerStudent(student);
    }

    public StudentRegisterDto getStudentRegisterDto() {
	return studentRegisterDto;
    }

    @Resource(name = "studentRegisterDto")
    public void setStudentRegisterDto(StudentRegisterDto studentRegisterDto) {
	this.studentRegisterDto = studentRegisterDto;
    }

    public StudentRegisterDto getModel() {
	return studentRegisterDto;
    }

    @Resource(name = "studentServiceImpl")
    public void setStudentService(StudentService studentService) {
	this.studentService = studentService;
    }

    public StudentService getStudentService() {
	return studentService;
    }

    public void setStudent_id(String student_id) {
	this.student_id = student_id;
    }

    public String getStudent_id() {
	return student_id;
    }

    public void setRegisterResult(String registerResult) {
	this.registerResult = registerResult;
    }

    public String getRegisterResult() {
	return registerResult;
    }

}

package beyond.library.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.Action;

/**
 * 学生信息显示（这个action本来可以不用的，因为我是从session获得出的学生信
 * 息，所以这个action完全可以去掉，但是这是我开始写的时候加上的，没来得及去掉）
 * @author Administrator
 *
 */
@Component("student_infoAction")
@Scope("prototype")
public class Student_infoAction implements Action {
	public String execute() throws Exception {
		return "success";
	}

}

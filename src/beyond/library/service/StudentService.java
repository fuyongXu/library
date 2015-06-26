package beyond.library.service;

import java.util.List;

import beyond.library.medol.Book_view;
import beyond.library.medol.Student;

public interface StudentService {

    /**
     * 学生欠款结算
     * 
     * @param student_id
     */
    public abstract void reduct_money(String student_id);

    /**
     * 由学生号得到对应的学生信息
     * 
     * @param studentId
     * @return 学生对象
     */
    public abstract Student get_student_by_id(String studentId);

    /**
     * 学生注册
     * 
     * @param student
     * @return 注册是否成功
     */
    public abstract boolean registerStudent(Student student);

    /**
     * 由于累积超期天数达到一定值，进行对该学生降低借阅等级处罚
     * 
     * @param studentId
     */
    public abstract void student_down_grade(String studentId);

    /**
     * 由于累积书本借阅量达到一定量，进行对该学生的提高借阅等级奖励
     * @param studentId
     */
    public abstract void student_up_grade(String studentId);

    /**
     * 得到该学生的所有已借阅书本
     * @param studentId
     * @return
     */
    public abstract List<Book_view> get_borrow_books(String studentId);

    /**
     * 跟据学生号和密码，进行学生登录
     * @param studentId
     * @param password
     * @return
     */
    public abstract Student login_by_idAndpassword(String studentId,
	    String password);

    /**
     * 判断学生是否可以借阅该书
     * @param studentId
     * @param bookId
     * @return
     */
    public abstract String is_borrowBook_able(String studentId, String bookId);

    /**
     * 学生密码修改
     * @param student_id
     * @param password
     * @return
     */
    public abstract boolean updatePassword(String student_id, String password);
    
    /**
     * 得到该学生对应的预约的书本
     * @param student_id
     * @return
     */
    public List<Book_view> get_books_by_reservation_student_id(String student_id);
}
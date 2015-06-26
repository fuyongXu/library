package beyond.library.medol;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 这是一个学生表，详细信息查看文档
 * @author Administrator
 *
 */
@Entity
public class Student {

	private String student_id;
	private String student_name;
	private int max_borrow_count = 3;
	private int max_borrow_time = 30;
	private int grade = 1;
	private float money = 100;
	private String password = "0000";
	private int accumulate_borrow_books;
	private int accumulate_beyond_borrow_max_days;
	private int reduceMoney;

	@Id
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String studentId) {
		student_id = studentId;
	}

	public int getMax_borrow_count() {
		return max_borrow_count;
	}

	public void setMax_borrow_count(int maxBorrowCount) {
		max_borrow_count = maxBorrowCount;
	}

	public int getMax_borrow_time() {
		return max_borrow_time;
	}

	public void setMax_borrow_time(int maxBorrowTime) {
		max_borrow_time = maxBorrowTime;
	}

	public int getBorrowed_count() {
		return borrowed_count;
	}

	public void setBorrowed_count(int borrowedCount) {
		borrowed_count = borrowedCount;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float getMoney() {
		return money;
	}

	public void setAccumulate_borrow_books(int accumulate_borrow_books) {
		this.accumulate_borrow_books = accumulate_borrow_books;
	}

	public int getAccumulate_borrow_books() {
		return accumulate_borrow_books;
	}

	public void setAccumulate_beyond_borrow_max_days(
			int accumulate_beyond_borrow_max_days) {
		this.accumulate_beyond_borrow_max_days = accumulate_beyond_borrow_max_days;
	}

	public int getAccumulate_beyond_borrow_max_days() {
		return accumulate_beyond_borrow_max_days;
	}

	public void setReduceMoney(int reduceMoney) {
		this.reduceMoney = reduceMoney;
	}

	public int getReduceMoney() {
		return reduceMoney;
	}

	private int borrowed_count;
}

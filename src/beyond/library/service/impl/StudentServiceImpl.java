package beyond.library.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import beyond.library.dao.BookDAO;
import beyond.library.dao.Book_viewDAO;
import beyond.library.dao.StudentDAO;
import beyond.library.medol.Book;
import beyond.library.medol.Book_view;
import beyond.library.medol.Student;
import beyond.library.service.StudentService;
import beyond.library.util.DateUtil;
import beyond.library.util.InfoUtil;

@Component("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	private BookDAO bookDAO;
	private StudentDAO studentDAO;
	private Book_viewDAO book_viewDAO;

	public void reduct_money(String student_id) {

		Student student = studentDAO.query_student_by_id(student_id);
		float money = student.getMoney() - student.getReduceMoney();
		student.setMoney(money);
		student.setReduceMoney(0);
		studentDAO.save_or_update_Student(student);
	}

	public Student get_student_by_id(String studentId) {
		return studentDAO.query_student_by_id(studentId);
	}

	public boolean registerStudent(Student student) {

		studentDAO.save_or_update_Student(student);
		if (studentDAO.query_student_by_id(student.getStudent_id()) != null)
			return true;
		return false;
	}

	public void student_down_grade(String studentId) {
		Student student = studentDAO.query_student_by_id(studentId);
		int accumulate_beyond_borrow_max_days = student
				.getAccumulate_beyond_borrow_max_days();
		int grade = student.getGrade();
		if (accumulate_beyond_borrow_max_days == 25 && grade != 0
				&& student.getBorrowed_count() == 0) {
			student.setGrade(student.getGrade() - 1);
			student.setMax_borrow_count(student.getMax_borrow_count() - 2);
			student.setMax_borrow_time(student.getMax_borrow_time() - 10);
			student.setAccumulate_beyond_borrow_max_days(0);
			student.setAccumulate_borrow_books(0);
			studentDAO.save_or_update_Student(student);
		}
	}

	public void student_up_grade(String studentId) {
		Student student = studentDAO.query_student_by_id(studentId);
		int accumulate_borrow_books = student.getAccumulate_borrow_books();
		if (accumulate_borrow_books >= 30) {
			student.setGrade(student.getGrade() + 1);
			student.setMax_borrow_count(student.getMax_borrow_count() + 2);
			student.setMax_borrow_time(student.getMax_borrow_time() + 10);
			student.setAccumulate_borrow_books(0);
			student.setAccumulate_beyond_borrow_max_days(0);
		}
		studentDAO.save_or_update_Student(student);
	}

	public List<Book_view> get_borrow_books(String studentId) {
		List<Book_view> books = book_viewDAO
				.query_books_by_student_id(studentId);
		for (Book_view book : books) {
			Book book2 = bookDAO.query_book_by_id(book.getBook_id());
			int beyondDays = DateUtil.getDays(book2.getReturnDate(),
					DateUtil.getNowDate());
			if (beyondDays > 0) {
				book2.setIsBeyondBorrowDate(true);
			}
			bookDAO.update_book(book2);
		}

		return books;
	}

	public Student login_by_idAndpassword(String studentId, String password) {
		Student student = studentDAO.query_student_by_id(studentId);
		if (student != null && password != null
				&& password.equals(student.getPassword()))
			return student;
		return null;
	}

	public String is_borrowBook_able(String studentId, String bookId) {
		Student student = studentDAO.query_student_by_id(studentId);
		Book book = bookDAO.query_book_by_id(bookId);
		int borrowed_count = student.getBorrowed_count();
		int borrow_grade = student.getGrade();

		// 判断该学生是不是达到最大借阅量
		if ((borrow_grade == 1 && borrowed_count == 3)
				|| (borrow_grade == 2 && borrowed_count == 5)
				|| (borrow_grade == 3 && borrowed_count == 7)
				|| (borrow_grade == 4 && borrowed_count == 9)
				|| (borrow_grade == 5 && borrowed_count == 11)
				|| (borrow_grade == 6 && borrowed_count == 13)
				|| (borrow_grade == 7 && borrowed_count == 15)
				|| (borrow_grade == 8 && borrowed_count == 17)
				|| (borrow_grade == 9 && borrowed_count == 19)
				|| (borrow_grade == 10 && borrowed_count == 21))
			return InfoUtil.BORROWED_BOOKS_FULL;
		if (student.getReduceMoney() > 0)
			return InfoUtil.ARREARAGE;
		if (book.getStudent() != null)
			return InfoUtil.IS_BORROWED;
		if (student.getGrade() == 0)
			return InfoUtil.USER_LOCKED;

		return "true";
	}

	public List<Book_view> get_books_by_reservation_student_id(String student_id) {
		return book_viewDAO.query_by_reservation_student_id(student_id);
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	@Resource(name = "bookDAOImpl")
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	@Resource(name = "studentDAOImpl")
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public boolean updatePassword(String studentId, String password) {

		Student student = studentDAO.query_student_by_id(studentId);
		student.setPassword(password);
		studentDAO.save_or_update_Student(student);

		student = studentDAO.query_student_by_id(studentId);
		if (password.equals(student.getPassword()))
			return true;
		return false;
	}

	@Resource(name = "book_viewDAOImpl")
	public void setBook_viewDAO(Book_viewDAO book_viewDAO) {
		this.book_viewDAO = book_viewDAO;
	}

	public Book_viewDAO getBook_viewDAO() {
		return book_viewDAO;
	}
}

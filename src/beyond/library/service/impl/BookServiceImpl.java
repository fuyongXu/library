package beyond.library.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import beyond.library.dao.BookDAO;
import beyond.library.dao.Book_viewDAO;
import beyond.library.dao.StudentDAO;
import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book;
import beyond.library.medol.Book_view;
import beyond.library.medol.Student;
import beyond.library.service.BookService;
import beyond.library.service.StudentService;
import beyond.library.util.DateUtil;
import beyond.library.util.InfoUtil;

@Component("bookServiceImpl")
public class BookServiceImpl implements BookService {

	private BookDAO bookDAO;
	private StudentDAO studentDAO;
	private StudentService studentService;
	private Book_viewDAO book_ViewDAO;

	public void addBook(Book book) {
		bookDAO.save_book(book);
	}

	public boolean deleteBook(Book book) {
		if (book.getStudent() == null) {
			bookDAO.delete_book(book);
			return true;
		}
		return false;
	}

	public Book getBookByBook_Id(String bookId) {
		Book book = bookDAO.query_book_by_id(bookId);

		Date reservation_date = book.getReservation_date();
		Date nowDate = DateUtil.getNowDate();
		if (reservation_date != null && nowDate != null) {
			int days = DateUtil.getDays(reservation_date, nowDate);
			if (days >= 7) {
				book.setReservation_date(null);
				book.setReservation_student_id(null);
				bookDAO.update_book(book);
			}
		}
		return book;
	}

	public int get_book_borrowed_days(String bookId) {

		Book book = bookDAO.query_book_by_id(bookId);
		Date borroweDate = book.getBorrowed_date();
		if (borroweDate != null) {
			Date nowDate = new Date();
			int days = DateUtil.getDays(borroweDate, nowDate);
			return days;
		}
		return 0;
	}

	public String cancel_borrowed(String bookId) {
		Book book = bookDAO.query_book_by_id(bookId);
		if (book == null) {
			return InfoUtil.ID_IS_NOTEXIST;
		}

		Student student = book.getStudent();
		if (student == null) {

			return InfoUtil.BOOK_NOT_BORROWED;
		}

		student.setBorrowed_count(student.getBorrowed_count() - 1);

		int beyond_borrow_days = student.getReduceMoney();

		int borrowed_days = get_book_borrowed_days(bookId);

		if (!book.getIsRenewed()
				&& borrowed_days > student.getMax_borrow_time()) {
			beyond_borrow_days += borrowed_days - student.getMax_borrow_time();
		}
		if (book.getIsRenewed()
				&& borrowed_days > (2 * student.getMax_borrow_time())) {
			beyond_borrow_days += borrowed_days - student.getMax_borrow_time()
					* 2;
		}
		student.setReduceMoney(beyond_borrow_days);
		studentService.student_down_grade(student.getStudent_id());
		studentService.student_up_grade(student.getStudent_id());
		studentDAO.save_or_update_Student(student);

		book.setBorrowed_date(null);
		book.setReturnDate(null);
		book.setIsRenewed(false);
		book.setStudent(null);
		book.setIsBeyondBorrowDate(false);
		bookDAO.update_book(book);

		return InfoUtil.RETURN_SUCCESS;
	}

	public boolean isExistByBook_name(String bookName) {
		List<Book_view> books = book_ViewDAO.query_book_by_name(bookName);
		if (books != null && books.size() != 0)
			return true;
		return false;
	}

	public void updeteBook(Book book) {
		bookDAO.update_book(book);
	}

	public String borrow_book(String studentId, String bookId) {
		Book book = bookDAO.query_book_by_id(bookId);
		if (bookId == null || book == null)
			return InfoUtil.ID_IS_NOTEXIST;
		String student_id = book.getReservation_student_id();
		if (student_id != null && !"".equals(student_id))
			return InfoUtil.BOOK_RESERVATION_CANT_RENEW;
		Student student = studentDAO.query_student_by_id(studentId);
		int borrow_count = student.getBorrowed_count();
		int accumulate_borrow_books = student.getAccumulate_borrow_books();
		if (!"true"
				.equals(studentService.is_borrowBook_able(studentId, bookId))) {
			return studentService.is_borrowBook_able(studentId, bookId);
		}

		student.setBorrowed_count(borrow_count + 1);
		student.setAccumulate_borrow_books(accumulate_borrow_books + 1);
		int max_borrow_time = student.getMax_borrow_time();
		studentDAO.save_or_update_Student(student);

		book.setStudent(student);

		book.setBorrowed_date(DateUtil.getNowDate());

		Date returnDate = DateUtil.getDateAfterDate(DateUtil.getNowDate(),
				max_borrow_time);
		book.setReturnDate(returnDate);

		bookDAO.update_book(book);
		return InfoUtil.BORROW_SUCCESS;
	}

	public List<Book_view> index_book(PageInfoDto pageInfo) {

		return book_ViewDAO.query_by_dimName(pageInfo);
	}

	public String renewBook(String book_id) {
		Book book = bookDAO.query_book_by_id(book_id);
		int max_borrow_time = book.getStudent().getMax_borrow_time();
		int borrowedDay = get_book_borrowed_days(book_id);
		String student_id = book.getReservation_student_id();
		if (book.getIsRenewed())
			return InfoUtil.ONLY_ONCE_CAN_RENEW;
		if (borrowedDay > max_borrow_time)
			return InfoUtil.BEYOND_RETURNED_DATE;
		System.out.println(max_borrow_time - borrowedDay);
		if (max_borrow_time - borrowedDay > 3) {
			return InfoUtil.NO_TIME;
		}
		if (student_id != null && !"".equals(student_id))
			return InfoUtil.BOOK_RESERVATION_CANT_RENEW;

		book.setIsRenewed(true);
		Date date = DateUtil.getDateAfterDate(DateUtil.getNowDate(),
				max_borrow_time);
		book.setReturnDate(date);

		updeteBook(book);

		return InfoUtil.RENEW_SUCCESS;
	}

	public String book_reservation(String bookId, String studentId) {
		Book book = bookDAO.query_book_by_id(bookId);
		if (book.getBorrowed_date() != null
				&& book.getStudent().getStudent_id().equals(studentId))
			return InfoUtil.YOU_HAVE_BORROW_BOOK;
		if (book.getStudent() == null && book.getReservation_date() == null)
			return InfoUtil.BOOK_IS_NOT_BORROWED_AND_RESERVATION;
		if (book.getReservation_date() != null) {
			return InfoUtil.BOOK_IS_RESERVATION;
		}

		int returnDay = DateUtil.getDays(DateUtil.getNowDate(),
				book.getReturnDate());
		if (returnDay >= 5) {
			return InfoUtil.BOOK_RETURNED_DAY_FIVE;
		} else {
			book.setReservation_date(DateUtil.getNowDate());
			book.setReservation_student_id(studentId);
			bookDAO.update_book(book);
			return "";
		}
	}

	public List<Book_view> getBooksByAfterThisDate(Date afterThisDate,
			PageInfoDto pageInfoDto) {

		return book_ViewDAO.query_by_addedDate(afterThisDate, pageInfoDto);
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

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name = "studentServiceImpl")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@Resource(name = "book_viewDAOImpl")
	public void setBook_ViewDAO(Book_viewDAO book_ViewDAO) {
		this.book_ViewDAO = book_ViewDAO;
	}

	public Book_viewDAO getBook_ViewDAO() {
		return book_ViewDAO;
	}

}

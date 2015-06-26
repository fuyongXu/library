package beyond.library.medol;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 这是一个书籍表，详细信息查看文档
 * @author Administrator
 *
 */
@Entity
public class Book {

	private String book_id;
	private String book_name;
	private String author;
	private String publishing_company;
	private Date publishing_date;
	private Date borrowed_date;
	private float price;
	private Student student;
	private String image;
	private String introduce;
	private Date returnDate;
	private boolean isRenewed;
	private Date addedDate;
	private boolean isBeyondBorrowDate;
	private String reservation_student_id;
	private Date reservation_date;

	@Id
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String bookId) {
		book_id = bookId;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String bookName) {
		book_name = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishing_company() {
		return publishing_company;
	}

	public void setPublishing_company(String publishingCompany) {
		publishing_company = publishingCompany;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setPublishing_date(Date publishing_date) {
		this.publishing_date = publishing_date;
	}

	public Date getPublishing_date() {
		return publishing_date;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setBorrowed_date(Date borrowed_date) {
		this.borrowed_date = borrowed_date;
	}

	public Date getBorrowed_date() {
		return borrowed_date;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setIsRenewed(boolean isRenewed) {
	    this.isRenewed = isRenewed;
	}
	
	public boolean getIsRenewed() {
	    return isRenewed;
	}

	public void setIsBeyondBorrowDate(boolean isBeyondBorrowDate) {
	    this.isBeyondBorrowDate = isBeyondBorrowDate;
	}

	public boolean getIsBeyondBorrowDate() {
	    return isBeyondBorrowDate;
	}

	public void setReservation_student_id(String reservation_student_id) {
	    this.reservation_student_id = reservation_student_id;
	}

	public String getReservation_student_id() {
	    return reservation_student_id;
	}

	public void setReservation_date(Date reservation_date) {
	    this.reservation_date = reservation_date;
	}

	public Date getReservation_date() {
	    return reservation_date;
	}
}

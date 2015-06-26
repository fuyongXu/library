package beyond.library.medol;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 这是一个视图，只能进行查询， 一是为了减少对无用数据的查询，二是为了保证数据安全
 * 
 * @author Administrator
 * 
 */
@Entity
public class Book_view {

    private String book_id;
    private String book_name;
    private String author;
    private String publishing_company;
    private Date publishing_date;
    private Date borrowed_date;
    private float price;
    private String student_id;
    private Date returnDate;
    private boolean isRenewed;
    private Date addedDate;
    private String reservation_student_id;
    private Date reservation_date;

    public Date getReturnDate() {
	return returnDate;
    }

    public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
    }

    public boolean getIsRenewed() {
	return isRenewed;
    }

    public void setIsRenewed(boolean isRenewed) {
	this.isRenewed = isRenewed;
    }

    public boolean getIsBeyondBorrowDate() {
	return isBeyondBorrowDate;
    }

    public void setIsBeyondBorrowDate(boolean isBeyondBorrowDate) {
	this.isBeyondBorrowDate = isBeyondBorrowDate;
    }

    private boolean isBeyondBorrowDate;

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

    public Date getPublishing_date() {
	return publishing_date;
    }

    public void setPublishing_date(Date publishingDate) {
	publishing_date = publishingDate;
    }

    public Date getBorrowed_date() {
	return borrowed_date;
    }

    public void setBorrowed_date(Date borrowedDate) {
	borrowed_date = borrowedDate;
    }

    public float getPrice() {
	return price;
    }

    public void setPrice(float price) {
	this.price = price;
    }

    public void setStudent_id(String student_id) {
	this.student_id = student_id;
    }

    public String getStudent_id() {
	return student_id;
    }

    public void setAddedDate(Date addedDate) {
	this.addedDate = addedDate;
    }

    public Date getAddedDate() {
	return addedDate;
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

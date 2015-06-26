package beyond.library.dto;

import java.io.File;

import org.springframework.stereotype.Component;

@Component
public class BookDto {

	private String book_id;
	private String book_name;
	private String author;
	private String publishing_company;
	private String publishing_date;
	private float price;
	private File image;
	private String introduce;
	private String addedDate;
	private String kind_id;

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

	public String getPublishing_date() {
		return publishing_date;
	}

	public void setPublishing_date(String publishingDate) {
		publishing_date = publishingDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_id() {
		return book_id;
	}

	
	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public File getImage() {
		return image;
	}

	public void setKind_id(String kind_id) {
	    this.kind_id = kind_id;
	}

	public String getKind_id() {
	    return kind_id;
	}
}

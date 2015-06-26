package beyond.library.action;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book;
import beyond.library.service.BookService;
import beyond.library.util.FileUtil;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 获得书本详细的信息
 * @author Administrator
 *
 */
@Component("bookDetailsAction")
@Scope("prototype")
public class BookDetailsAction implements Action {

	private String book_id;
	private BookService bookService;
	private Book book;
	private String result;

	public String execute() throws Exception {

		if (!getBookDetails()) {
			return "failed";
		}
		return "success";
	}


	private boolean getBookDetails() {

		book = bookService.getBookByBook_Id(book_id);
		if (book == null)
			return false;
		loadImage();
		return true;
	}
	
	private void loadImage(){
	    String bookImage = ServletActionContext.getServletContext()
		.getRealPath("bookImages");
	    String bookImagePath = InfoUtil.UPLOAD_URL;
		File imageFile = new File(bookImagePath, book.getImage());
		if (imageFile != null)
		    FileUtil.Upload(bookImage, imageFile, book.getImage());
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_id() {
		return book_id;
	}

	@Resource(name = "bookServiceImpl")
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}


	public void setResult(String result) {
	    this.result = result;
	}


	public String getResult() {
	    return result;
	}

}

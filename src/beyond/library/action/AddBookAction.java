package beyond.library.action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.dto.BookDto;
import beyond.library.medol.Book;
import beyond.library.service.BookService;
import beyond.library.util.DateUtil;
import beyond.library.util.FileUtil;
import beyond.library.util.Id_factory;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

@Component("addBookAction")
@Scope("prototype")
public class AddBookAction implements ModelDriven<BookDto>, Action {

    private BookDto bookDto;
    private String addResult;
    private Book book;
    private BookService bookService;
    private int count;
    private List<String> book_ids = new ArrayList<String>();

    public String execute() throws Exception {
	if (AddBook()) {
	    Id_factory.updateBookId(bookDto.getKind_id());
	    return "addSuccess";
	}
	return "addFailed";
    }

    private boolean AddBook() {
	for (int i = 0; i < count; i++) {
	    if (!assignmentBook(i))
		return false;
	    bookService.addBook(book);
	}
	return true;
    }

    /**
     * 把bookDto中的所有信息转到book中
     * 
     * @return 如果bookDto中的信息不符合标准，返回false
     */
    private boolean assignmentBook(int i) {
	if (bookDto.getKind_id() == null && "".equals(bookDto.getKind_id())) {
	    return false;
	}
	bookDto
		.setBook_id(Id_factory.book_id_factory(bookDto.getKind_id())
			+ i);
	String book_name = bookDto.getBook_name();
	String author = bookDto.getAuthor();
	String publishing_company = bookDto.getPublishing_company();
	String publishing_date = bookDto.getPublishing_date();
	float price = bookDto.getPrice();
	String image = imageUpload();
	String introduce = bookDto.getIntroduce();
	if (book_name == null || book_name == "" || author == null
		|| author == "" || publishing_company == null
		|| publishing_company == "" || publishing_date == null
		|| publishing_date == "" || price <= 1 || image == null)
	    return false;
	book = new Book();
	book.setBook_id(bookDto.getBook_id());
	book_ids.add(book.getBook_id());
	this.book.setAuthor(author);
	this.book.setBook_name(book_name);
	book.setPrice(price);
	book.setPublishing_company(publishing_company);
	book.setIntroduce(introduce);
	book.setAddedDate(DateUtil.getNowDate());
	Date date = null;
	try {
	    date = new SimpleDateFormat("yyyy-MM-dd").parse(publishing_date);
	} catch (ParseException e) {
	    return false;
	}
	book.setPublishing_date(date);
	book.setImage(image);
	return true;
    }

    /**
     * 上传要增加书本的图片信息
     * 
     * @return 返回书本图片的名称
     */
    private String imageUpload() {
	String bookImagePath = InfoUtil.UPLOAD_URL;
	File imageFile = bookDto.getImage();
	String bookImageName = (bookDto.getBook_id()).split("\\.")[0] + ".jpg";
	if (imageFile != null)
	    FileUtil.Upload(bookImagePath, imageFile, bookImageName);

	return bookImageName;
    }

    public BookDto getModel() {
	return bookDto;
    }

    public Book getBook() {
	return book;
    }

    public void setBook(Book book) {
	this.book = book;
    }

    public void setBookDto(BookDto bookDto) {
	this.bookDto = bookDto;
    }

    public BookDto getBookDto() {
	return bookDto;
    }

    @Resource(name = "bookServiceImpl")
    public void setBookService(BookService bookService) {
	this.bookService = bookService;
    }

    public BookService getBookService() {
	return bookService;
    }

    public void setCount(int count) {
	this.count = count;
    }

    public int getCount() {
	return count;
    }

    public void setBook_ids(List<String> book_ids) {
	book_ids = new ArrayList<String>();
    }

    public List<String> getBook_ids() {
	return book_ids;
    }

    public void setAddResult(String addResult) {
	this.addResult = addResult;
    }

    public String getAddResult() {
	return addResult;
    }

}

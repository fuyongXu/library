package beyond.library.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.medol.Book;
import beyond.library.service.BookService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

/**
 * 管理员对书本的删除
 * 
 * @author Administrator
 * 
 */

@Component("deleteBookAction")
@Scope("prototype")
public class DeleteBookAction implements Action {

    private String book_id;
    private BookService bookService;
    private String deleteResult;

    public String execute() throws Exception {
	if (deleteBook())
	    return "success";
	return "failed";
    }

    private boolean deleteBook() {
	Book book = bookService.getBookByBook_Id(book_id);
	if (bookService.deleteBook(book)) {
	    return true;
	} else {
	    deleteResult = InfoUtil.BOOK_IS_BORROWED;
	    return false;
	}
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

    public void setDaleteResult(String deleteResult) {
	this.deleteResult = deleteResult;
    }

    public String getDeleteResult() {
	return deleteResult;
    }

}

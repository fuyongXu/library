package beyond.library.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book_view;
import beyond.library.service.BookService;
import beyond.library.util.DateUtil;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;

@Component("newBooksAction")
@Scope("prototype")
public class NewBooksAction implements Action, SessionAware {

    private BookService bookService;
    private List<Book_view> books;
    private String noResult;
    private int pageNow;
    private Map<String, Object> session;
    private PageInfoDto pageInfoDto;

    public String execute() throws Exception {
	newBooks();
	if (books == null || books.size() == 0)
	    noResult = InfoUtil.NO_NEW_BOOK;
	return "result";
    }

    private void newBooks() {
	PageInfoDto pageInfoDto = (PageInfoDto) session.get("NEW_BOOKS_DTO");
	if (pageInfoDto == null) {
	    pageInfoDto = new PageInfoDto();
	    pageInfoDto.setPageNow(1);
	    pageInfoDto.setPageSize(10);
	} else {
	    pageInfoDto.setPageNow(pageNow);
	}
	Date afterThisDate = DateUtil.getDateAfterDate(DateUtil.getNowDate(),
		-15);
	books = bookService.getBooksByAfterThisDate(afterThisDate, pageInfoDto);
	this.pageInfoDto = pageInfoDto;
	System.out.println(pageInfoDto.getRowsCount());
	session.put("NEW_BOOKS_DTO", pageInfoDto);
    }

    @Resource(name = "bookServiceImpl")
    public void setBookService(BookService bookService) {
	this.bookService = bookService;
    }

    public BookService getBookService() {
	return bookService;
    }

    public void setBooks(List<Book_view> books) {
	this.books = books;
    }

    public List<Book_view> getBooks() {
	return books;
    }

    public void setSession(Map<String, Object> arg0) {
	this.session = arg0;
    }

    public void setNoResult(String noResult) {
	this.noResult = noResult;
    }

    public String getNoResult() {
	return noResult;
    }

    public void setPageNow(int pageNow) {
	this.pageNow = pageNow;
    }

    public int getPageNow() {
	return pageNow;
    }

    public void setPageInfoDto(PageInfoDto pageInfoDto) {
	this.pageInfoDto = pageInfoDto;
    }

    public PageInfoDto getPageInfoDto() {
	return pageInfoDto;
    }
}

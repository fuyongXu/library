package beyond.library.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book_view;
import beyond.library.service.BookService;
import beyond.library.util.InfoUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 书目索引
 * 
 * @author Administrator
 * 
 */
@Component("indexAction")
@Scope("prototype")
public class IndexAction implements Action, SessionAware,
	ModelDriven<PageInfoDto> {

    private BookService bookService;
    private List<Book_view> books;
    private PageInfoDto pageInfoDto;
    private String noResult;
    private Map<String, Object> session;

    public String execute() throws Exception {
	this.index_book();
	if (books == null || books.size() == 0)
	    noResult = InfoUtil.NO_BOOK_YOU_REQUEST;
	return "result";
    }

    private void index_book() {
	PageInfoDto pageInfoDto = ((PageInfoDto) session.get("PAGE_INFO"));
	if (pageInfoDto != null && this.pageInfoDto.getPageNow() == 0) {
	    this.pageInfoDto = pageInfoDto;
	}
	this.pageInfoDto.setQuery_kinds(InfoUtil.index_query(this.pageInfoDto
		.getQuery_kinds()));
	books = bookService.index_book(this.pageInfoDto);
	session.put("PAGE_INFO", this.pageInfoDto);
    }

    @Resource(name = "bookServiceImpl")
    public void setBookService(BookService bookService) {
	this.bookService = bookService;
    }

    public BookService getBookService() {
	return bookService;
    }

    public List<Book_view> getBooks() {
	return books;
    }

    public void setBooks(List<Book_view> books) {
	this.books = books;
    }

    public void setSession(Map<String, Object> arg0) {
	session = arg0;
    }

    public PageInfoDto getModel() {
	return pageInfoDto;
    }

    public void setPageInfoDto(PageInfoDto pageInfoDto) {
	this.pageInfoDto = pageInfoDto;
    }

    public PageInfoDto getPageInfoDto() {
	return pageInfoDto;
    }

    public void setNoResult(String noResult) {
	this.noResult = noResult;
    }

    public String getNoResult() {
	return noResult;
    }

}

package beyond.library.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import beyond.library.dao.Book_idDAO;
import beyond.library.medol.Book_id;
import beyond.library.service.Book_idService;

@Component
public class Book_idServiceImpl implements Book_idService {

    private Book_idDAO bookIdDAO;

    public int getBook_id_by_kind(String kind) {
	Book_id book_id = bookIdDAO.query_by_kind(kind);
	return book_id.getBook_id();
    }

    public int updateBook_id(String kind) {
	Book_id book_id = bookIdDAO.query_by_kind(kind);
	int bookId = book_id.getBook_id();
	book_id.setBook_id(++bookId);
	bookIdDAO.update(book_id);
	return getBook_id_by_kind(kind);
    }

    @Resource(name = "book_idDAOImpl")
    public void setBookIdDAO(Book_idDAO bookIdDAO) {
	this.bookIdDAO = bookIdDAO;
    }

    public Book_idDAO getBookIdDAO() {
	return bookIdDAO;
    }

}

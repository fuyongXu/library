package beyond.library.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import beyond.library.dao.BookDAO;
import beyond.library.medol.Book;
import beyond.library.medol.Book_view;

@Component
@Scope("prototype")
public class BookDAOImpl implements BookDAO {

    private HibernateTemplate hibernateTemplate;

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
    }

    public void delete_book(Book book) {

	hibernateTemplate.delete(book);
    }

    public Book query_book_by_id(String id) {
	return (Book) hibernateTemplate.get(Book.class, id);
    }

    public List<Book_view> query_books_by_student_id(String studentId) {
	return hibernateTemplate.find("from Book_view book where book.studentId=?",
		studentId);
    }

    public void update_book(Book book) {
	hibernateTemplate.update(book);
    }
    
    public void save_book(Book book) {
	hibernateTemplate.save(book);
    }
}
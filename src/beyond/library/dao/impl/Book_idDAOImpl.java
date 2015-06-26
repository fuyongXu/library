package beyond.library.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import beyond.library.dao.Book_idDAO;
import beyond.library.medol.Book_id;

@Component
public class Book_idDAOImpl implements Book_idDAO {

    private HibernateTemplate hibernateTemplate;

    public Book_id query_by_kind(String kind) {
	return (Book_id) hibernateTemplate.get(Book_id.class, kind);
    }

    public void update(Book_id book_id) {
	hibernateTemplate.update(book_id);
    }

    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
    }

}

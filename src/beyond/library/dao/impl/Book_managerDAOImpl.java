package beyond.library.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import beyond.library.dao.Book_managerDAO;
import beyond.library.medol.Book_manager;

@Component("book_mangerDAOImpl")
public class Book_managerDAOImpl implements Book_managerDAO {

	private HibernateTemplate hibernateTemplate;

	public Book_manager getBookManagerbyId(String manger_id) {
		Book_manager bookManager = (Book_manager) hibernateTemplate.get(
				Book_manager.class, manger_id);
		if (bookManager != null)
			return bookManager;
		return null;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
}

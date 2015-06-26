package beyond.library.dao.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import beyond.library.dao.Book_viewDAO;
import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book_view;
import beyond.library.util.DateUtil;

@Component
public class Book_viewDAOImpl implements Book_viewDAO {
	private HibernateTemplate hibernateTemplate;

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public List<Book_view> query_by_dimName(PageInfoDto pageInfoDto) {
		String query_kinds = pageInfoDto.getQuery_kinds();
		String dimName = pageInfoDto.getDimName();
		int pageSize = pageInfoDto.getPageSize();
		int pageNow = pageInfoDto.getPageNow();
		String hql = null;
		hql = "from Book_view book where book." + query_kinds + " like:name";
		List list = paging(dimName, pageSize, pageNow, hql);
		hql = "select count(*) from Book_view book where book." + query_kinds
				+ " like:name";
		Object rowsCount = pageRows(dimName, hql);
		pageInfoDto.setRowsCount(Integer.parseInt(rowsCount.toString()));
		return list;
	}

	public List<Book_view> query_by_addedDate(Date afterThisDate,
			PageInfoDto pageInfoDto) {
		final int pageNow = pageInfoDto.getPageNow();
		final int pageSize = pageInfoDto.getPageSize();
		String hql = "from Book_view book where book.addedDate > '"
				+ DateUtil.formatDateToString(afterThisDate) + "'";
		List<Book_view> books = paging(null, pageSize, pageNow, hql);
		hql = "select count(*) from Book_view book where book.addedDate > '"
				+ DateUtil.formatDateToString(afterThisDate) + "'";
		Object rowsCount = pageRows(null, hql);
		pageInfoDto.setRowsCount(Integer.parseInt(rowsCount.toString()));
		return books;
	}

	public List<Book_view> query_book_by_name(String bookName) {
		return hibernateTemplate.find(
				"from Book_view book where book.book_name=?", bookName);
	}

	public List<Book_view> query_books_by_student_id(String studentId) {

		return hibernateTemplate
				.find("from Book_view book where book.student_id='" + studentId
						+ "'");
	}

	private Object pageRows(final String dim, final String hql) {
		Object rowsCount = hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (dim != null)
					query.setString("name", "%" + dim + "%");
				Object rowsCount = query.list().get(0);
				return rowsCount;
			}
		});
		return rowsCount;
	}

	private List<Book_view> paging(final String dim, final int pageSize,
			final int pageNow, final String hql) {
		return hibernateTemplate.executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (dim != null)
					query.setString("name", "%" + dim + "%");
				query.setFirstResult((pageNow - 1) * pageSize);
				query.setMaxResults(pageSize);
				List list = query.list();
				return list;
			}
		});
	}

	public List<Book_view> query_by_reservation_student_id(String studentId) {
		List<Book_view> bookViews = hibernateTemplate.find(
				"from Book_view book where book.reservation_student_id = ?",
				studentId);
		return bookViews;
	}

}

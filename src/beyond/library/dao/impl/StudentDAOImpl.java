package beyond.library.dao.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import beyond.library.dao.StudentDAO;
import beyond.library.medol.Student;

@Component
@Scope("prototype")
public class StudentDAOImpl implements StudentDAO {

	private HibernateTemplate hibernateTemplate;

	public Student query_student_by_id(String studentId) {
		if (studentId != null || studentId != "")
			return (Student) hibernateTemplate.get(Student.class, studentId);
		return null;
	}

	public void save_or_update_Student(Student student) {
		hibernateTemplate.saveOrUpdate(student);
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

}

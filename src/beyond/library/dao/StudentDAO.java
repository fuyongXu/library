package beyond.library.dao;

import beyond.library.medol.Student;

public interface StudentDAO {
    	
	public Student query_student_by_id(String student_id);
	public void save_or_update_Student(Student student);
}

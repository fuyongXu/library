package beyond.library.dao.impl;

import beyond.library.medol.Book_manager;

public interface Book_managerService {

	public abstract Book_manager login(String book_manager_id, String password);

}
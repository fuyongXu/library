package beyond.library.dao;

import beyond.library.medol.Book_id;

public interface Book_idDAO {

    public Book_id query_by_kind(String kind);
    public void update(Book_id bookId);
}

package beyond.library.dao;

import beyond.library.medol.Book;

public interface BookDAO {
    /**
     * 书本更新
     * 
     * @param book
     */
    public void update_book(Book book);

    /**
     * 书本数据保存
     * 
     * @param book
     */
    public void save_book(Book book);

    /**
     * 书本删除
     * 
     * @param book
     */
    public void delete_book(Book book);

    /**
     * 由id号得到了书本信息
     * @param id
     * @return
     */
    public Book query_book_by_id(String id);

}
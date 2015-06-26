package beyond.library.service;

import java.util.Date;
import java.util.List;

import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book;
import beyond.library.medol.Book_view;

public interface BookService {

    /**
     * 添加书本
     * 
     * @param book
     *            书本
     */
    public abstract void addBook(Book book);

    /**
     * @param book
     *            书本 删除书本
     */
    public abstract boolean deleteBook(Book book);

    /**
     * 跟据书本得到对应书本
     * 
     * @param bookId
     *            书号
     * @return 一个书本实例
     */
    public abstract Book getBookByBook_Id(String bookId);

    /**
     * 得到对应书本的已被借的天数
     * 
     * @param bookId
     *            书号
     * @return 如果该书被借，返回对应的已被借的天数，如果没有被借返回0
     */
    public abstract int get_book_borrowed_days(String bookId);

    /**
     * 还书业务办理
     * 
     * @param bookId
     *            书号
     */
    public abstract String cancel_borrowed(String bookId);

    /**
     * 对应此书本名的书是否存在
     * 
     * @param bookName
     *            书号
     * @return 存在为true，不存在为false
     */
    public abstract boolean isExistByBook_name(String bookName);

    /**
     * 书本借阅业务办理
     * 
     * @param studentId
     *            学生号
     * @param bookId
     *            书本号
     * @return 返回借阅结果信息
     */
    public abstract String borrow_book(String studentId, String bookId);

    /**
     * 进行模糊查询
     * 
     * @param dimName
     * @return
     */
    public abstract List<Book_view> index_book(PageInfoDto pageInfo);

    /**
     * 书本续借
     * 
     * @param book_id
     * @return 借续结果信息
     */
    public abstract String renewBook(String book_id);

    /**
     * 得到所有书本添加日期在afterThisDate之后的所有书本
     * 
     * @param afterThisDate
     * @return
     */
    public abstract List<Book_view> getBooksByAfterThisDate(Date afterThisDate,
	    PageInfoDto pageInfoDto);

    /**
     * 书本预约
     * @param book_id
     * @param student_id
     * @return 返回预约结果
     */
    public String book_reservation(String book_id, String student_id);

}
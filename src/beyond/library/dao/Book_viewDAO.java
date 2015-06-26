package beyond.library.dao;

import java.util.Date;
import java.util.List;

import beyond.library.dto.PageInfoDto;
import beyond.library.medol.Book_view;
/**
 * 些类仅仅为了查询而不去修改数据，是从视图book_view中得到数据
 * @author Administrator
 *
 */
public interface Book_viewDAO {
    /**
     * 由书本名字从视图book_view中索引出书本集合
     * @param book_name
     * @return
     */
    public List<Book_view> query_book_by_name(String book_name);
    /**
     * 由被借学生号从视图book_view中索引出书本集合
     * @param student_id
     * @return
     */
    public List<Book_view> query_books_by_student_id(String student_id);
    /**
     * 进行模糊查询，并分页
     * @param pageInfoDto
     * @return
     */
    public List<Book_view> query_by_dimName(PageInfoDto pageInfoDto);
    /**
     * 得到最新上架的书本，并分页
     * @param afterThisDate
     * @param pageInfoDto
     * @return
     */
    public List<Book_view> query_by_addedDate(Date afterThisDate, PageInfoDto pageInfoDto);
    
    /**
     * 由预约学生号，索引出对应书本
     * @param student_id
     * @return
     */
    public List<Book_view> query_by_reservation_student_id(String student_id);
}

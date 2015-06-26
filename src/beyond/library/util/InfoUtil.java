package beyond.library.util;

/**
 * 这是一个辅助类，操作数据库时，不同的结果会向结果页面传递不同的信息，再显示到页面上
 * 
 * @author Administrator
 * 
 */
public class InfoUtil {

    public static final String ONLY_ONCE_CAN_RENEW = "您已续借了一次，不能再次借续！";
    public static final String BEYOND_RETURNED_DATE = "您已超期，不得续借！";
    public static final String NO_TIME = "不到续借时间，请到了续借时间再来续借！";
    public static final String BOOK_RESERVATION_CANT_RENEW = "该书已经被预约，您不能续借！";
    public static final String RENEW_SUCCESS = "续借成功！";
    public static final String BORROWED_BOOKS_FULL = "您已达到最大借阅量，借书失败！";
    public static final String ARREARAGE = "您已欠款，不得借书！";
    public static final String BORROW_SUCCESS = "借书办理成功！";
    public static final String IS_BORROWED = "该书已经被借，无法借阅！";
    public static final String ID_IS_NOTEXIST = "书号不存在！";
    public static final String BOOK_NOT_BORROWED = "书本没有被借！";
    public static final String RETURN_SUCCESS = "还书业务办理完成！";
    public static final String USER_LOCKED = "您的帐户已经被冻结！";
    public static final String USER_ID_NOT_EXIST = "你输入的帐户不存在！";
    public static final String PASSWORD_WRONG = "你输入的密码错误！";
    public static final String PASSWOED_UPDATE_SUCCESS = "密码修改成功！";
    public static final String PASSWORD_UPDATE_FAILED = "密码修改失败！";
    public static final String PASSWORD_AND_REPASSWORD_NOT_SAME = "两次新密码输入不一致！";
    public static final String NEWPASSWORD_AND_OLDPASSWORD_SAME = "新旧密码不能相同！";
    public static final String NO_NEW_BOOK = "对不起，最近没有新上架的书籍！";
    public static final String NO_BOOK_YOU_REQUEST = "对不起，没有符合条件的书本！";
    public static final String PASSWORD_IS_NULL = "密码不能为空！";
    public static final String STUDENT_NO_EXIST = "学生号不存在！";
    public static final String STUDENT_ID_NULL = "学生号不能为空，请输入学生号！";
    public static final String BOOK_IS_BORROWED = "书本被借，无法删除！";
    public static final String BOOK_IS_NOT_BORROWED_AND_RESERVATION = "书本被没有被借，也没有被预约，不需要预约！";
    public static final String BOOK_IS_RESERVATION = "书本已经被预约！";
    public static final String BOOK_RETURNED_DAY_FIVE = "对不起，该书本离还书日期小于5天时才能预约！";
    public static final String RESERVATION_SUCCESS = "预约成功！";
    public static final String YOU_HAVE_BORROW_BOOK = "你已经借阅该书，不得进行预约！";

    public static final String UPLOAD_URL = "E:/bookImage/";

    /**
     * 把对应的中文条件查询转为sql中的英文字符串
     * 
     * @param query_kinds
     * @return
     */
    public static String index_query(String query_kinds) {

	if ("按书名查询".equals(query_kinds))
	    query_kinds = "book_name";
	if ("按作者查询".equals(query_kinds))
	    query_kinds = "author";
	if ("按出版社查询".equals(query_kinds))
	    query_kinds = "publishing_company";
	return query_kinds;
    }
}

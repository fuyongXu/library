package beyond.library.util;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import beyond.library.service.Book_idService;

/**
 * 学生注册时，id号的自动生成；书本添加时，书本id的生成
 * 
 * @author Administrator
 * 
 */
public class Id_factory {

    private static Random random = new Random();
    private static Book_idService bookIdService;

    static {
	ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext(
		"bean.xml");
	bookIdService = (Book_idService) cxt.getBean("book_idServiceImpl");
    }

    /**
     * 由书类号从表book_id得出该类书最近更新的书号， 书本的id号的组成是：书类号 + 该类书本的累积book_id + ‘.’ +
     * 这一书名的排号 其中“该类书本的累积book_id”是一个由表book_id中得出一个int值再转为一个长度为5的字符串， 这个
     * int值实际上就是不同书名的数量，所以每次添加书，只要是书名不同，就会+1一次。
     * 比如：从book_id中取出的值是4，那转化后的字符串是"00004"，A类书，某本书的id号就是A00004.2
     * 只有书名，书类相同的书本，"."前面的字符串才相同。这里book_id表的作用就是记录上一次某类书本添加
     * 后生成的"该类书本的累积book_id"，当书本添加成功后，book_id表才会更新
     * 
     * @param book_kind
     * @return
     */
    public static String book_id_factory(String book_kind) {
	// 得出该书类号最近更新的书的id号，这里是一个int值，是book_id的一部分
	int book_id = bookIdService.getBook_id_by_kind(book_kind);
	// 书号生成是累加的，下一个书号是由+1后组成的
	book_id++;
	// 转为字符串
	String book_idToString = "" + book_id;
	// 得到字符串的长度
	int book_idLength = book_idToString.length();

	int length = 0;
	// 如果，该字符串长不足5，就算出length值
	if (book_idLength < 5)
	    length = 5 - book_idLength;
	// 由length值来为字符串前缀0，直到字符串长度为5
	for (int i = 0; i < length; i++) {
	    StringBuffer stringBuffer = new StringBuffer("0");
	    stringBuffer.append(book_idToString);
	    book_idToString = stringBuffer.toString();
	}
	return book_kind + book_idToString + ".";
    }

    // 用book_id表来记录添加书本
    public static void updateBookId(String kind) {
	bookIdService.updateBook_id(kind);
    }

    //学生注册时，生成student_id
    public static String student_id_factory() {

	String randomString = "" + random.nextInt(1000);
	for (int i = 0; i < 4 - randomString.length(); i++) {
	    randomString = "0" + randomString;
	}
	return randomString;
    }
}

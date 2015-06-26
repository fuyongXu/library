package beyond.library.medol;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book_id {
    private int book_id;
    private String kind;

    public void setBook_id(int book_id) {
	this.book_id = book_id;
    }

    public int getBook_id() {
	return book_id;
    }

    public void setKind(String kind) {
	this.kind = kind;
    }
    @Id
    public String getKind() {
	return kind;
    }
}

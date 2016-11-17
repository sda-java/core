package entities;

import java.util.List;

import javax.ejb.Local;

@Local
public interface LibraryPersistentBeanLocal {
	void addBook(Book bookName);

	List<Book> getBooks();
}

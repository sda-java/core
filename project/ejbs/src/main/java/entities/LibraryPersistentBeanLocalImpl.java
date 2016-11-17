package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LibraryPersistentBeanLocalImpl implements LibraryPersistentBeanLocal {
	public LibraryPersistentBeanLocalImpl() {
	}

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getBooks() {
		return entityManager.createQuery("From Book").getResultList();
	}
}

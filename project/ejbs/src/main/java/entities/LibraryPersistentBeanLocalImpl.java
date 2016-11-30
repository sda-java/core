package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class LibraryPersistentBeanLocalImpl implements LibraryPersistentBeanLocal {
	public LibraryPersistentBeanLocalImpl() {
	}

	@PersistenceContext(unitName = "myPersistenceUnit")
	private EntityManager entityManager;

	public void addBook(Book book) {
		// book.setId(0);
		entityManager.persist(book);
		entityManager.flush();
	}

	public List<Book> getBooks() {
		return entityManager.createQuery("From Book").getResultList();
	}
}

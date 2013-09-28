package biebActions.member;

import java.util.ArrayList;
import java.util.List;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.BookStatus;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AllBooks extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books;
	private List<Book> booksAvailable = new ArrayList<Book>();
	private List<Book> booksreserved = new ArrayList<Book>();
	private User user;
	
	public String execute() {
		books = ibs.getBooks();
		
		for(Book b : books) {
			if(b.getStatus().equals(BookStatus.AVAILABLE)) {
				booksAvailable.add(b);
			}
		}
		
		books = ibs.getBooks(user.getUsername());
		for(Book b : books) {
			if(b.getStatus().equals(BookStatus.RESERVED)) {
				booksreserved.add(b);
			}
		}
		
		books = ibs.getBooks();
		return ActionSupport.SUCCESS;
	}

	public IBiebService getIbs() {
		return ibs;
	}

	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}

	public List<Book> getBooksAvailable() {
		return booksAvailable;
	}

	public void setBooksavailable(List<Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	public List<Book> getBooksreserved() {
		return booksreserved;
	}

	public void setBooksreserved(List<Book> booksreserved) {
		this.booksreserved = booksreserved;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
}

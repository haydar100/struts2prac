package biebActions.manager;

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
public class DeleteBook extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books;
	private int bookid;
	private String id;
	private Book book;
	private User user;
	
	public IBiebService getIbs() {
		return ibs;
	}



	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}


	public String execute() {
		ibs.deleteBook(bookid);
		addActionMessage("Boek succesvol verwijderd");
		books = ibs.getBooks();
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {
		try {
			bookid = Integer.parseInt(id);
			books = ibs.getBooks();
			for(Book b : books) {
				
				if(ibs.bookExists(bookid)) {
					if(b.getStatus().equals(BookStatus.AVAILABLE)) {
						
					}
					else {
						addActionError("Boek is uitgeleend of gereserveerd");
						books = ibs.getBooks();
						break;
						
					}
				}
				else {
					addActionError("Bookid komt niet voor");
					books = ibs.getBooks();
					break;
				}
			}
			
		}
		catch(NumberFormatException nfe) {
			addActionError("Ingevuld bookid is geen nummer");
			books = ibs.getBooks();
		}
	}
		

	
//
//	public List<Book> getBooks() {
//		return books;
//	}
//
//
//
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}


	



	public int getBookid() {
		return bookid;
	}



	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	

	
	
	
	
}

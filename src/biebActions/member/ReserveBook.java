package biebActions.member;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionMessage;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.BookStatus;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReserveBook extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books = new ArrayList<Book>();
	private String id;
	private List<Book> booksAvailable = new ArrayList<Book>();
	public List<Book> getBooksAvailable() {
		return booksAvailable;
	}



	public void setBooksAvailable(List<Book> booksAvailable) {
		this.booksAvailable = booksAvailable;
	}

	private int bookid;
	private Book book;
	private User user;
	
	public IBiebService getIbs() {
		return ibs;
	}



	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}


	public String execute() {
			ibs.reserveBook(user.getUsername(), bookid);
			addActionMessage("Book succesvol gereserveerd");
			
			for(Book b : books) {
				if(b.getStatus().equals(BookStatus.AVAILABLE)) {
					booksAvailable.add(b);
				}
			}	
			
			return ActionSupport.SUCCESS;		
	}
	
	public void validate() {
		try {
			bookid = Integer.parseInt(id);
			if(!ibs.bookExists(bookid)) {
				addFieldError("id", "Bookid bestaat niet. Vul een geldig nummer in");
				books = ibs.getBooks();
				for(Book b : books) {
					if(b.getStatus().equals(BookStatus.AVAILABLE)) {
						booksAvailable.add(b);
					}
				}
			}
			books = ibs.getBooks();
			System.out.println(ibs.getBooks());
			for (Book b : books) {
				if (b.getId() == bookid) {
					System.out.println(bookid + "na de ==");
					System.out.println(b.getId());
					if (b.getStatus().equals(BookStatus.AVAILABLE)) {
					}
					else {
						addActionError("Boek is al gereserveerd");
						books = ibs.getBooks();
						for(Book bb : books) {
							if(bb.getStatus().equals(BookStatus.AVAILABLE)) {
								booksAvailable.add(bb);
							}
						}
					}
				}	
			}
		}
		catch(NumberFormatException nfe) {
			addFieldError("id", "Ingevuld bookid is geen nummer");
		}
	}
	

	public List<Book> getBooks() {
		return books;
	}



	public void setBooks(List<Book> books) {
		this.books = books;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public int getBookid() {
		return bookid;
	}



	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

	
	
	
	
}

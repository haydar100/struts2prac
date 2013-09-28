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
public class CancelReservation extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books = new ArrayList<Book>();
	private List<Book> booksreserved = new ArrayList<Book>();
	private String id;
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
			ibs.cancelReservationBook(user.getUsername(), bookid);
			
			booksreserved = ibs.getBooks(user.getUsername());
//			for(Book b : books) {
//				if (user.getUsername().equals(b.getUser().getUsername()))  {
//					booksreserved.add(b);
//				}
//			}
			
			addActionMessage("Annulering succesvol doorgevoerd");
			return ActionSupport.SUCCESS;		
	}
	
	public void validate() {
		try {
			bookid = Integer.parseInt(id);
			if(!ibs.bookExists(bookid)) {
				addActionError("Bookid bestaat niet. Vul een geldig nummer in");
				books = ibs.getBooks();
			}
			books = ibs.getBooks();
			for (Book b : books) {
				if (b.getId() == bookid) {
					System.out.println(bookid + "na de ==");
					System.out.println(b.getId());
					if (b.getStatus().equals(BookStatus.RESERVED)) {
					}
					else {
						addActionError("Boek is nog niet gereserveerd");
					}
				}	
			}
		}
		catch(NumberFormatException nfe) {
			addFieldError("id", "Ingevuld bookid is geen nummer");
			books = ibs.getBooks();
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

package biebActions.member;

import java.util.ArrayList;
import java.util.List;

import biebAware.UserAware;
import biebDomain.Book;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookInfoForm extends ActionSupport{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books = new ArrayList<Book>();
	private String id;
	private int bookid;
	private Book book;
	
	public IBiebService getIbs() {
		return ibs;
	}



	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}


	public String execute() {
			book = ibs.getBookById(bookid);
			return ActionSupport.SUCCESS;		
	}
	
	public void validate() {
		try {
			bookid = Integer.parseInt(id);
			if(!ibs.bookExists(bookid)) {
				addFieldError("id", "Bookid bestaat niet. Vul een geldig nummer in");
				books = ibs.getBooks();
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

	

	
	
	
	
}

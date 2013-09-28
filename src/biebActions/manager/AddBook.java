package biebActions.manager;

import java.util.List;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddBook extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books;
	private int bookid;
	private String id;
	private String titel;
	private String auteur;
	private String isbn;
	private String pages;
	private int paginas;
	private Book book;
	private User user;
	



	public String execute() {
		paginas = Integer.parseInt(pages);
		ibs.addBook(bookid, titel, auteur, isbn, paginas);
		addActionMessage("Boek succesvol toegevoegd");
		books = ibs.getBooks();
		return ActionSupport.SUCCESS;
		
	}
	
	public void validate() {
		if (id.trim().length() != 0) { // addActionError ipv fielderror
			try {
				bookid = Integer.parseInt(id);
				if (!ibs.bookExists(bookid)) {
					if (titel.trim().length() > 0) {
						if (auteur.trim().length() > 0) {
							if (isbn.trim().length() > 0) {
								try {
									Integer.parseInt(pages);

								} catch (NumberFormatException nfe) {
									addActionError("Vul een integer in voor pagina's");
									books = ibs.getBooks();
								}
							} else {
								addActionError("Geen geldige ISBN nummer");
								books = ibs.getBooks();
							}
						} else {
							addActionError("Vul een geldige naam van een auteur in");
							books = ibs.getBooks();
						}
					} else {
						addActionError("Vul een geldige titel in ");
						books = ibs.getBooks();
					}
				} else {
					addActionError("Vul een geldige titel");
					books = ibs.getBooks();
				}
			} catch (NumberFormatException nfe) {
				addFieldError("id", "Ingevuld bookid is geen nummer");
				books = ibs.getBooks();
			}
		} else {
			addActionError("Kan ID niet parsen (geen integer getal)");
			books = ibs.getBooks();
		}

	}


	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public IBiebService getIbs() {
		return ibs;
	}

	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

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

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	
	

	
	
	
	
}

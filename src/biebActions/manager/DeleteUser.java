package biebActions.manager;


import java.util.List;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DeleteUser extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> allUsers;
	private String username;
	private Book book;
	private User user;
	
	public IBiebService getIbs() {
		return ibs;
	}



	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}


	public String execute() {
		ibs.deleteUser(username);
		addActionMessage("Gebruiker succesvol verwijderd");
		allUsers = ibs.getUsers();
		return ActionSupport.SUCCESS;
	}
	
	public void validate() {

			if(ibs.userExists(username)) {
				if(user.getBooks().size() == 0) {
				}
				else {
					addActionError("Gebruiker heeft nog gereserveerde boeken");
					allUsers = ibs.getUsers();
				}
			}
			else {
				
				addActionError("Gebruikersnaam bestaat niet. Vul een geldige gebruikersnaam in");
				allUsers = ibs.getUsers();
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



	public List<User> getAllUsers() {
		return allUsers;
	}



	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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
	
	
	

	
	
	
	
}

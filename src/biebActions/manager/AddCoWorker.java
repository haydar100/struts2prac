package biebActions.manager;

import java.util.List;

import biebAware.UserAware;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class AddCoWorker extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> allUsers;
	private User user;
	private String username;
	private String password;


	

	public String execute() {
		ibs.addCoworker(username, password);
		allUsers = ibs.getUsers();
		addActionMessage("Medewerker succesvol toegevoegd !");
		return ActionSupport.SUCCESS;

	}

	public void validate() {
		if ((username.length() > 1) && (username != null)) { // password checken met methode nog toevoegen
		} else {
			addActionError("Ongeldige gebruikersnaam of wachtwoord ingevuld");
			allUsers = ibs.getUsers();
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

}

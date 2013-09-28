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
public class AllUsers extends ActionSupport implements UserAware {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> allUsers;
	private User user;
	
	public String execute() {
		allUsers = ibs.getUsers();
		
		return ActionSupport.SUCCESS;
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}

	public User getUser() {
		return user;
	}

	public IBiebService getIbs() {
		return ibs;
	}

	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}


	@Override
	public void setUser(User user) {
		this.user = user;
		
	}
}

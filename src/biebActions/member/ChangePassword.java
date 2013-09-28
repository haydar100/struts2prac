package biebActions.member;

import biebAware.UserAware;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChangePassword extends ActionSupport implements UserAware {

	private User user;
	private String newPassword;
	private String newPassword1;
	private IBiebService ibs = ServiceProvider.getBiebService();

	public String execute() {
		ibs.changePassword(user.getUsername(), newPassword1);
		return ActionSupport.SUCCESS;
	}

	public void validate() {
		if (newPassword.equals("") && newPassword1.equals("")) {
			addFieldError(newPassword, "Lege wachtwoord niet toegestaan");
		}
		if (!newPassword.equals(newPassword1)) {
			addFieldError("newPassword", "Wachtwoord is niet gelijk");
		}
		if (newPassword1.length() < 8 && newPassword.length() < 8) {
			addFieldError("newPassword",
					"Wachtwoord moet minimaal 8 tekens zijn");
		}
		if (newPassword1.indexOf(" ") > -1 && newPassword.indexOf(" ") > -1) {
			addFieldError("newPassword", "Er mogen geen spaties in zitten");
		}

		boolean upperFound = false;
		boolean upperFound1 = false;
		for (char c : newPassword.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upperFound = true;
				break;
			}
		}

		for (char c : newPassword1.toCharArray()) {
			if (Character.isUpperCase(c)) {
				upperFound1 = true;
				break;
			}
		}
		if (!upperFound && !upperFound1) {
			addFieldError("newPassword", "wachtwoord bevat geen hoofdletters");
		}

		boolean lowerFound = false;
		boolean lowerFound1 = false;

		for (char c : newPassword.toCharArray()) {
			if (Character.isLowerCase(c)) {
				lowerFound = true;
				break;
			}
		}

		for (char c : newPassword1.toCharArray()) {
			if (Character.isLowerCase(c)) {
				lowerFound1 = true;
				break;
			}
		}
		if (!upperFound && !upperFound1) {
			addFieldError("newPassword", "wachtwoord bevat geen hoofdletters");
		}
		if (!lowerFound && !lowerFound1) {
			addFieldError("newPassword", "wachtwoord bevat geen lowercase");
		}

		boolean isDigit = false;
		boolean isDigit1 = false;

		for (char c : newPassword.toCharArray()) {
			if (Character.isDigit(c)) {
				isDigit = true;
				break;
			}
		}

		for (char c : newPassword1.toCharArray()) {
			if (Character.isDigit(c)) {
				isDigit = true;
				break;
			}
		}
		if (!isDigit && !isDigit1) {
			addFieldError("newPassword", "wachtwoord bevat geen cijfer");
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword1() {
		return newPassword1;
	}

	public void setNewPassword1(String newPassword1) {
		this.newPassword1 = newPassword1;
	}
}

package biebInterceptors;

import java.util.Map;

import biebAware.UserAware;
import biebDomain.User;
import biebDomain.UserRole;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ManagerInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = actionInvocation.getInvocationContext().getSession();

		User user = (User) session.get("user");

		if (user == null) {
			return Action.LOGIN;
		} else {
			if (user.getUr().equals(UserRole.Manager)) {
				//System.out.println("UserRole manager detected");
				Action action = (Action) actionInvocation.getAction();

				if (action instanceof UserAware) {
					((UserAware) action).setUser(user);
				}

			} else {
				return Action.LOGIN;
			}

			return actionInvocation.invoke();
		}
	}
}

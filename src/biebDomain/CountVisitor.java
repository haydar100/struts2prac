package biebDomain;

import java.util.Map;

import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CountVisitor extends ActionSupport implements ApplicationAware, SessionAware {
	private Map application;
	private int teller = 0;
	private Map session;
		
	public String execute() {
		if(application.containsKey("aantal")) {
			Integer aantal = (Integer)application.get("aantal");
			aantal++;
			application.put("aantal", aantal);
		}
		else {
			teller += 1;
			application.put("aantal", teller);
		}
		
		return ActionSupport.SUCCESS;
		
	}

	public Map getApplication() {
		return application;
	}

	public void setApplication(Map application) {
		this.application = (ApplicationMap) application;
	}

	@Override
	public void setSession(Map session) {
		this.session = session;
	}

	public Map getSession() {
		return session;
	}
	
	
	
	
}

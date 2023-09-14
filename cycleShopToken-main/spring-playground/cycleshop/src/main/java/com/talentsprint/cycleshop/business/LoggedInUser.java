package com.talentsprint.cycleshop.business;
import com.talentsprint.cycleshop.entity.User;
import lombok.Data;
@Data
public class LoggedInUser {
    public User getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(User loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

	private User loggedInUser;

	
}

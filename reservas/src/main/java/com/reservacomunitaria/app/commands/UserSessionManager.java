package com.reservacomunitaria.app.commands;

import com.reservacomunitaria.app.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserSessionManager {

    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
    }

    public void clearSession() {
        this.loggedInUser = null;
    }
}


package com.dictionaryapp.util;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoginUser {
    private String username;
    private boolean isLogin;

    public LoginUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        this.isLogin = true;
    }
    public void logout(){
        this.username = null;
        this.isLogin = false;
    }

    public boolean isLogin() {
        return isLogin;
    }
}

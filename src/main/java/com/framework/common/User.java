package com.framework.common;

import com.framework.app.common.PropertyHelper;

public class User extends Main {
    private String login;
    private String password;
    private String role;
    private String realm;
    private PropertyHelper propsHelper = new PropertyHelper();

    public User() throws Exception {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        this.login = propsHelper.getPasswordProperties("LOGIN." + getRole());
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() {
        this.password = propsHelper.getPasswordProperties("PASSWD." + getRole());
    }

    public void setNewPassword(String password) {
        this.password = password;
    }

    public void setNewLogin(String login) {
        this.login = login;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm() {
        this.realm = propsHelper.getPasswordProperties("REALM." + getRole());
    }

}

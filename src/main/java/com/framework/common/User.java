package com.framework.common;

import com.framework.app.common.PropertyHelper;

/**
 *
 * @author Ian Phillips
 */
public class User extends Main {
    private String login;
    private String password;
    private String role;
    private String realm;
    private PropertyHelper propsHelper = new PropertyHelper();

    /**
     * This class should be extended to create for each user.
     * @throws Exception
     */
    public User() throws Exception {
    }

    /**
     * Returns the login of the user to the test.
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Reads the login from the ini file.
     * Use: LOGIN.AdminUser
     */
    public void setLogin() {
        this.login = propsHelper.getPasswordProperties("LOGIN." + getRole());
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Reads the Password from the properties file.
     */
    public void setPassword() {
        this.password = propsHelper.getPasswordProperties("PASSWD." + getRole());
    }

    /**
     * For resetting the password in the INI file.  Its possible to automate 
     * the changing of a password and updating the ini file.
     * @param password
     */
    public void setNewPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param login
     */
    public void setNewLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public String getRealm() {
        return realm;
    }

    /**
     *
     */
    public void setRealm() {
        this.realm = propsHelper.getPasswordProperties("REALM." + getRole());
    }

}

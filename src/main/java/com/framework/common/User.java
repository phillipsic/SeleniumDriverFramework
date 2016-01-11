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
    private String firstName;
    private String lastName;
    private String userID;

    public PropertyHelper propsHelper = new PropertyHelper();

    /**
     * This class should be extended to create for each user.
     *
     * @throws Exception
     */
    public User() throws Exception {
    }

    /**
     * Returns the login of the user to the test.
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Reads the login from the ini file. Use: LOGIN.AdminUser
     */
    public void setLogin() {
        this.login = propsHelper.getPasswordProperties("LOGIN." + getRole());
    }

    /**
     * Returns the password of the User
     *
     * @return returns the password as a string
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
     * For resetting the password in the INI file. Its possible to automate the
     * changing of a password and updating the ini file.
     *
     * @param password
     */
    public void setNewPassword(String password) {
        this.password = password;
    }

    /**
     * Updates the login of the user.
     *
     * @param login
     */
    public void setNewLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return returns the role of the user as a string
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role uupdates the role of the user.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @param firstname first name of user to be updated
     */
    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    /**
     *
     * @return returns the first name of the user as a string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return returns the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastname sets the lastname of the user
     */
    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}

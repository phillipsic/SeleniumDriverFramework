package com.comverse.cls;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.PropertyHelper;

public class CLSLoginPage extends CLSMenu {

    public CLSLoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Central logging Service";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setUserName(String login) throws Exception {

        tool.enterStringUsingId("j_username", login);
    }

    public void setPassword(String password) throws Exception {

        tool.enterStringUsingId("j_password", password);
    }

    public void clickLogin() throws Exception {
        tool.clickUsingXPath("//input[@value='Login']");
    }

    public Logging successfulCLSAdminLogin() throws Exception {

        PropertyHelper propsHelper = new PropertyHelper();
        String login = propsHelper.getPasswordProperties("LOGIN.CLSAdmin");
        String password = propsHelper.getPasswordProperties("PASSWD.CLSAdmin");

        this.setUserName(login);
        this.setPassword(password);
        this.clickLogin();
        return new Logging(tool, test, user);
    }

}

package com.company.css.OCM;

import java.util.MissingResourceException;

import com.framework.common.AutomationTool;
import com.framework.common.Test;
import com.framework.common.User;
import com.framework.app.common.Common;
import com.company.css.commonpages.CommonMenu;

public class LoginPage extends CommonMenu {

    // public final User user;
    public LoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();
        String expectedScreen = "OCM Application";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }

    }

    public OCMApplication loginToOCM(User user) throws Exception {  test.writeInLogFile(Common.getMethodName());
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId("login:fields:user", user.getLogin());

        tool.enterStringUsingId("login:fields:password", user.getPassword());
        tool.clickUsingName("login:buttons:submit");

        Common.assertTextOnPage(tool, "Login completed successfully.");

        return new OCMApplication(tool, test);
    }

    public void loginToOCMAndFail(User user) throws Exception {  test.writeInLogFile(Common.getMethodName());
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId("login:fields:user", user.getLogin());

        tool.enterStringUsingId("login:fields:password", user.getPassword());
        tool.clickUsingName("login:buttons:submit");

        Common.assertTextNotOnPage(tool, "Login completed successfully.");

    }

    public OCMApplication loginToOCMAndChangePassword(User user) throws Exception {  test.writeInLogFile(Common.getMethodName());
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId("login:fields:user", user.getLogin());

        tool.enterStringUsingId("login:fields:password", user.getPassword());
        tool.clickUsingName("login:buttons:submit");
        Common.assertTextOnPage(tool, "Temporary password must be changed.");

        tool.enterStringUsingId("mainPanel:changePasswordForm:fields:oldPassword", user.getPassword());
        tool.enterStringUsingId("mainPanel:changePasswordForm:fields:newPassword", "P@ssw0rd");
        tool.enterStringUsingId("mainPanel:changePasswordForm:fields:repeatPassword", "P@ssw0rd");

        tool.clickUsingName("mainPanel:changePasswordForm:buttons:change");

        Common.assertTextOnPage(tool, "Your password has been changed");

        return new OCMApplication(tool, test);
    }

}

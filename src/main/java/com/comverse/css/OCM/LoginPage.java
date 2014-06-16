package com.comverse.css.OCM;

import java.util.MissingResourceException;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class LoginPage extends CommonMenu {

    // public final User user;
    public LoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "OCM Application";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.getTitle(tool))) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public OCMApplication loginToOCM(User user) throws Exception {
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId(tool, "login:fields:user", user.getLogin());

        tool.enterStringUsingId(tool, "login:fields:password", user.getPassword());
        tool.clickUsingName(tool, "login:buttons:submit");

        Common.assertTextOnPage(tool, "Login completed successfully.");

        return new OCMApplication(tool, test);
    }

    public void loginToOCMAndFail(User user) throws Exception {
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId(tool, "login:fields:user", user.getLogin());

        tool.enterStringUsingId(tool, "login:fields:password", user.getPassword());
        tool.clickUsingName(tool, "login:buttons:submit");

        Common.assertTextNotOnPage(tool, "Login completed successfully.");

    }

    public OCMApplication loginToOCMAndChangePassword(User user) throws Exception {
        if (user.getLogin() == null || user.getLogin().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getLogin(), "PASSWORD_PROPERTY_FILE", user.getLogin());
        }
        if (user.getPassword() == null || user.getPassword().length() == 0) {
            throw new MissingResourceException("Missing property " + user.getPassword(), "PASSWORD_PROPERTY_FILE", user.getPassword());
        }

        tool.enterStringUsingId(tool, "login:fields:user", user.getLogin());

        tool.enterStringUsingId(tool, "login:fields:password", user.getPassword());
        tool.clickUsingName(tool, "login:buttons:submit");
        Common.assertTextOnPage(tool, "Temporary password must be changed.");

        tool.enterStringUsingId(tool, "mainPanel:changePasswordForm:fields:oldPassword", user.getPassword());
        tool.enterStringUsingId(tool, "mainPanel:changePasswordForm:fields:newPassword", "P@ssw0rd");
        tool.enterStringUsingId(tool, "mainPanel:changePasswordForm:fields:repeatPassword", "P@ssw0rd");

        tool.clickUsingName(tool, "mainPanel:changePasswordForm:buttons:change");

        Common.assertTextOnPage(tool, "Your password has been changed");

        return new OCMApplication(tool, test);
    }

}

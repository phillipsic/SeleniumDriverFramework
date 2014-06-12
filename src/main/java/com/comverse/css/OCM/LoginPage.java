package com.comverse.css.OCM;

import java.util.MissingResourceException;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class LoginPage extends CommonMenu {

    // public final User user;

    public LoginPage(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "OCM Application";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
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

        tool.driver.findElement(By.id("login:fields:user")).clear();
        tool.driver.findElement(By.id("login:fields:user")).sendKeys(user.getLogin());
        tool.driver.findElement(By.id("login:fields:password")).clear();
        tool.driver.findElement(By.id("login:fields:password")).sendKeys(user.getPassword());
        tool.driver.findElement(By.name("login:buttons:submit")).click();

        Common.assertTextOnPage(tool, "Login completed successfully.");

        return new OCMApplication(tool, test);
    }

}

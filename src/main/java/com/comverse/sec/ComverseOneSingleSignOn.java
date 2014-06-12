package com.comverse.sec;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Main;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.RestorePreviousBasket;
import com.comverse.css.csr.WorkSpace;

public class ComverseOneSingleSignOn extends Main {

    public ComverseOneSingleSignOn(AutomationTool tool, Test test, User user) {
        this.test = test;
        this.user = user;
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Comverse – Single Signon";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setUserName(AutomationTool tool, User user) throws Exception {
        tool.driver.findElement(By.id("username")).clear();
        tool.driver.findElement(By.id("username")).sendKeys(user.getLogin());
    }

    public void setPassword(AutomationTool tool, User user) throws Exception {
        tool.driver.findElement(By.id("password")).clear();
        tool.driver.findElement(By.id("password")).sendKeys(user.getPassword());
    }

    public void setRealm(AutomationTool tool, User user) throws Exception {
        new Select(tool.driver.findElement(By.id("realmselect"))).selectByVisibleText(user.getRealm());
    }

    public void clickLogin(AutomationTool tool) throws Exception {
        tool.driver.findElement(By.name("submit")).click();
    }

    public WorkSpace loginToCSRAsCSRAdmin() throws Exception {
        loginSSOUser();
        Common.checkForExistingBasketAndDiscard(tool);
        return new WorkSpace(tool, test, user);
    }

    public RestorePreviousBasket loginToCSRAsCSRAdminWithPreviousBasket() throws Exception {
        loginSSOUser();
        return new RestorePreviousBasket(tool, test, user);
    }

}

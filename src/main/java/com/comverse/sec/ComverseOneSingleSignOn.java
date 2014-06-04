package com.comverse.sec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.Main;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.csr.RestorePreviousBasket;
import com.comverse.css.csr.WorkSpace;

public class ComverseOneSingleSignOn extends Main {

    public ComverseOneSingleSignOn(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Comverse – Single Signon";

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setUserName(User user) throws Exception {
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys(user.getLogin());
    }

    public void setPassword(User user) throws Exception {
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
    }

    public void setRealm(User user) throws Exception {
        new Select(driver.findElement(By.id("realmselect"))).selectByVisibleText(user.getRealm());
    }

    public void clickLogin() throws Exception {
        driver.findElement(By.name("submit")).click();
    }

    public WorkSpace loginToCSRAsCSRAdmin() throws Exception {
        loginSSOUser();
        Common.checkForExistingBasketAndDiscard(driver);
        return new WorkSpace(driver);
    }

    public RestorePreviousBasket loginToCSRAsCSRAdminWithPreviousBasket() throws Exception {
        loginSSOUser();
        return new RestorePreviousBasket(driver);
    }

}

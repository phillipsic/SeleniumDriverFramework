package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class BalanceDetailsCommon extends CommonMenu {

    static String expectedScreen = "Balance Details";

    public BalanceDetailsCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    // From Account shared balance details page
    public BalanceDetailsCommon viewSubscriberBalanceDetails(String balanceName) throws Exception {

        driver.findElement(By.linkText(balanceName)).click();
        return new BalanceDetailsCommon(driver);
    }

    // From Subscriber balance details page
    public ViewBalanceCommon viewAccountBalances() throws Exception {

        driver.findElement(By.linkText("View account balances")).click();
        return new ViewBalanceCommon(driver);
    }

    public ViewBalanceCommon clickGoToListOfBalances() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewBalanceCommon(driver);
    }

}

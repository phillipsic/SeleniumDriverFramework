package com.comverse.css.b2c;

import com.comverse.css.common.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author iphilli
 */
public class BalanceDetails extends B2CMenu {

    public BalanceDetails(WebDriver driver) {
        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Balance Details";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }
    
    public ViewBalances clickGoToListOfSubscribers() throws Exception {

        driver.findElement(By.id("youcan_ON_BACK")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewBalances(driver);
    }

}

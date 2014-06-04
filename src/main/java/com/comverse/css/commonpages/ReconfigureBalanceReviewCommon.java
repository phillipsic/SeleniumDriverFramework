package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReconfigureBalanceReviewCommon extends CommonMenu {

    static String expectedScreen = "Configure balance - Review";

    public ReconfigureBalanceReviewCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }
    }

    public ReconfigureBalanceConfirmCommon clickConfirm() throws Exception {

        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ReconfigureBalanceConfirmCommon(driver);
    }

}

package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReconfigureBalanceCommon extends CommonMenu {

    static String expectedScreen = "Configure Balance";

    public ReconfigureBalanceCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();

        if (!currentScreen.equals(expectedScreen)) {
            throw new IllegalStateException("Expected: " + expectedScreen + " but got: " + currentScreen);
        }

    }

    public ReconfigureBalanceCommon setMoreUnitsForThisPeriod(String unitsToAdd) throws Exception {

        driver.findElement(By.id("balanceValue")).sendKeys(unitsToAdd);
        return new ReconfigureBalanceCommon(driver);
    }

    public ReconfigureBalanceReviewCommon clickAddUnits() throws Exception {

        driver.findElement(By.name("submit_add_units")).click();
        return new ReconfigureBalanceReviewCommon(driver);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimit(String limitValue) throws Exception {

        driver.findElement(By.id("configuredLimit")).sendKeys(limitValue);
        return new ReconfigureBalanceCommon(driver);
    }

    public ReconfigureBalanceCommon setCreditSpendingLimitUnlimited() throws Exception {

        driver.findElement(By.name("isUnlimitedCheckBox")).click();
        return new ReconfigureBalanceCommon(driver);
    }

    public void selectUseAccountUnitsFrom(String selectOption) throws Exception {
        new Select(driver.findElement(By.id("targetBalance"))).selectByVisibleText(selectOption);
    }

    public ReconfigureBalanceReviewCommon clickReconfigureBalance() throws Exception {

        driver.findElement(By.name("submit_reconfigure_limit")).click();
        return new ReconfigureBalanceReviewCommon(driver);
    }

}

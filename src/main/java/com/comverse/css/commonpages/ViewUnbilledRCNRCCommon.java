package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewUnbilledRCNRCCommon extends CommonMenu {

    public ViewUnbilledRCNRCCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Unbilled RC/NRC";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewUnbilledRCTermDetailsCommon clickFirstRCTerm() throws Exception {

        driver.findElement(By.xpath("//fieldset/div[4]/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewUnbilledRCTermDetailsCommon(driver);
    }

    public ViewUnbilledNRCTermDetailsCommon clickFirstNRCTerm() throws Exception {

        driver.findElement(By.xpath("//div[2]/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewUnbilledNRCTermDetailsCommon(driver);
    }

    public UnbilledTransactionCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new UnbilledTransactionCommon(driver);
    }
}

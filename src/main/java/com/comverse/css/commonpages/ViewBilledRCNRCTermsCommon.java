package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewBilledRCNRCTermsCommon extends CommonMenu {

    public ViewBilledRCNRCTermsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View billed RC/NRC terms";
        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);

        }
    }

    public ViewBilledRCNRCTermDetailsCommon clickFirstRCTerm() throws Exception {

        driver.findElement(By.xpath("//fieldset/div[4]/div/table/tbody[2]/tr/td/div/a")).click();
        return new ViewBilledRCNRCTermDetailsCommon(driver);
    }

    public ViewInvoiceDetailsCommon clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
        return new ViewInvoiceDetailsCommon(driver);
    }
}

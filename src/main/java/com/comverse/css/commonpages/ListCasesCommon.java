package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comverse.css.common.Common;

public class ListCasesCommon extends CommonMenu {

    static String expectedScreen = "List Cases";

    public ListCasesCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting:" + expectedScreen + ", but got: " + currentScreen);
        }
    }

    public ListCasesCommon clickSearch() throws Exception {

        driver.findElement(By.xpath("(//input[@value='Search'])[3]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ListCasesCommon(driver);
    }

    public ViewCaseCommon clickFirstCase() throws Exception {

        driver.findElement(By.xpath("//fieldset/div/table/tbody[2]/tr/td/div/a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCaseCommon(driver);
    }
}

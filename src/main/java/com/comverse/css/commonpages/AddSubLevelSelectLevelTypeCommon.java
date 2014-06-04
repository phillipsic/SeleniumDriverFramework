package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddSubLevelSelectLevelTypeCommon extends CommonMenu {
    static String expectedScreen = "Add Sub Level - Select Level Type";

    public AddSubLevelSelectLevelTypeCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddSubLevelLegalAddressCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new AddSubLevelLegalAddressCommon(driver);
    }
}

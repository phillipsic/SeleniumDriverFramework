package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnableLoginCommon extends CommonMenu {

    public EnableLoginCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();


        if (!"Enable Login".equals(currentScreen)) {

            throw new IllegalStateException("Expecting: Enable Login, but got: " + currentScreen);
        }
    }

    public LoginInformationCommon clickOk() throws Exception {
        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new LoginInformationCommon(driver);
    }
}

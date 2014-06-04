package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMemberConfirmationCommon extends CommonMenu {
    static String expectedScreen = "Add Member - Confirmation";

    public AddMemberConfirmationCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public AddMemberCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new AddMemberCommon(driver);
    }
}

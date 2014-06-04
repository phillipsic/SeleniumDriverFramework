package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLevelCommon extends CommonMenu {

    static String expectedScreen = "Add Level";

    public AddLevelCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ViewHierarchyCommon(driver);
    }
}

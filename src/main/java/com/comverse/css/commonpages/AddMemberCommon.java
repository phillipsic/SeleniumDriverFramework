package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMemberCommon extends CommonMenu {
    static String expectedScreen = "Add Member";

    public AddMemberCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getTempPasswordFromPage() throws Exception {

        String password = driver.findElement(By.xpath("//*[@id=\"mainContents\"]/div/div[2]/div/div/span")).getText();

        String temp[] = password.split(":");
        password = temp[1];
        System.out.println("Temporary password: " + password.trim());
        return password.trim();

    }

    public ViewHierarchyCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();

        return new ViewHierarchyCommon(driver);
    }
}

package com.comverse.css.commonpages;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewHierarchyCommon extends CommonMenu {

    public ViewHierarchyCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "View Hierarchy";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void clickWeeklyLevel() throws Exception {

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_YEAR);

        String weeklyLevelName = "level" + week + "a";

        driver.findElement(By.linkText(weeklyLevelName)).click();

    }

    public void clickLevelLink(String linkName) throws Exception {

        driver.findElement(By.linkText(linkName)).click();
    }

    public String getRootLevel() throws Exception {
        System.out.println("Root Level " + driver.findElement(By.xpath("//div[@id='mainContents']/div/table/tbody/tr/td/a")).getText());
        return driver.findElement(By.xpath("//div[@id='mainContents']/div/table/tbody/tr/td/a")).getText();

    }

    public ContactInformationCommon clickEmployeeNameLink(String firstName, String lastName) throws Exception {

        driver.findElement(By.linkText(firstName + " " + lastName)).click();
        return new ContactInformationCommon(driver);
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Koushic
 */
public class MoveLevelCommon extends CommonMenu {

    private List<WebElement> WebElementfound;

    public MoveLevelCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();
        String expectedScreen = "Move Level";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public MoveLevelCommon clickSelectByLevelName(String weeklyLevelName) throws Exception {

        driver.findElement(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]")).click();

        return new MoveLevelCommon(driver);
    }

    @Override
    public ViewHierarchyCommon clickHierarchy() throws Exception {

        /*
         * driver.findElement(By.linkText("Select")).click();
         */
        driver.findElement(By.id("mnu_HIERARCHY")).click();

        return new ViewHierarchyCommon(driver);

    }

    public MoveLevelCommon levelNameWithOutSelectLink(String weeklyLevelName) throws Exception {

        //driver.findElement(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]"));

        WebElementfound = driver.findElements(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(driver);

        }

    }

    public MoveLevelStatusCommon clickSelectForLevelName(String weeklyLevelName) throws Exception {

        driver.findElement(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]")).click();

        return new MoveLevelStatusCommon(driver);
    }

    public MoveLevelCommon findSelectByLevelname(String weeklyLevelName) throws Exception {

        //driver.findElement(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]"));

        WebElementfound = driver.findElements(By.xpath("//tr[td[contains(text(),'" + weeklyLevelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is KK");
            return new MoveLevelCommon(driver);

        }

    }
}

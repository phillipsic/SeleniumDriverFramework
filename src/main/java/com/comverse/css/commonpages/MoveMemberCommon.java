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
 * @author mkumar
 */
public class MoveMemberCommon extends CommonMenu {
    private List<WebElement> WebElementfound;

    public MoveMemberCommon(WebDriver driver) throws Exception {

        super(driver);
        String currentScreen = this.driver.getTitle();
        String expectedScreen = "Move Member";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public MoveMemberCommon clickSelectByLevelName(String levelName) throws Exception {

        driver.findElement(By.xpath("//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]")).click();

        //driver.findElement(By.xpath("//tr[td/a[contains(text(),'Select')]]/td[contains(text(),'" + levelname + "')]"));
        return new MoveMemberCommon(driver);
    }

    public MoveMemberCommon findSelectByLevelName(String levelName) throws Exception {

        WebElementfound = driver.findElements(By.xpath("//tr[td[contains(text(),'" + levelName + "')]]/td//a[contains(text(), 'Select')]"));

        if (WebElementfound.size() > 0) {

            throw new IllegalStateException("Expecting:No Select Link but got: Select Link");

        } else {
            System.out.println("Value of Unique code is MK");
            return new MoveMemberCommon(driver);

        }

        //driver.findElement(By.xpath("//tr[td/a[contains(text(),'Select')]]/td[contains(text(),'" + levelname + "')]"));

    }

    public ContactInformationCommon clickOk() throws Exception {

        driver.findElement(By.xpath("//input[@value='OK']")).click();
        return new ContactInformationCommon(driver);
    }
}

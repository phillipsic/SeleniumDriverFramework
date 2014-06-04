/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.css.commonpages.CommonMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author iphilli
 */
public class AddEmployeeContactInformation extends CommonMenu {

    public AddEmployeeContactInformation(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Add Employee - Contact Information";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void setFirstName(String firstName) throws Exception {

        driver.findElement(By.id("first_name")).clear();
        driver.findElement(By.id("first_name")).sendKeys(firstName);
    }

    public void setLastName(String lastName) throws Exception {

        driver.findElement(By.id("last_name")).clear();
        driver.findElement(By.id("last_name")).sendKeys(lastName);
    }

    /*
     * public AddEmployeeRegisterLogin clickSubmit() throws Exception {
     *
     * driver.findElement(By.cssSelector("input.submit")).click(); return new
     * AddEmployeeRegisterLogin(driver); }
     */
    public void selectState(String homeState) throws Exception {

        new Select(driver.findElement(By.id("home_state"))).selectByVisibleText(homeState);
    }

    public AddEmployeeRegisterLogin clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        return new AddEmployeeRegisterLogin(driver);
    }
}

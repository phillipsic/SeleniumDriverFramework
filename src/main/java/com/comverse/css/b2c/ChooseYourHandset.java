/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comverse.css.common.Common;

/**
 * 
 * @author iphilli
 */
public class ChooseYourHandset extends B2CMenu {

    public ChooseYourHandset(WebDriver driver) {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Choose Your Handset";

        // Check that we're on the right page.
        if (!expectedScreen.equals(driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourPrimaryOffer selectHandset(String Handset) throws Exception {

        driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(driver);
    }

    public MyBasket selectHandsetExpectingMyBasket(String Handset) throws Exception {

        driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public void selectManufacturer1() throws Exception {
        WebElement manufacturer1 = driver.findElement(By.cssSelector("input[value='Manufacturer 1']"));
        if (!(manufacturer1.isSelected()))
            manufacturer1.click();
    }

    public void unSelectManufacturer1() throws Exception {
        WebElement manufacturer1 = driver.findElement(By.cssSelector("input[value='Manufacturer 1']"));
        if (manufacturer1.isSelected())
            manufacturer1.click();
    }

    public void selectManufacturer2() throws Exception {
        WebElement manufacturer2 = driver.findElement(By.cssSelector("input[value='Manufacturer 2']"));
        if (!(manufacturer2.isSelected()))
            manufacturer2.click();
    }

    public void unSelectManufacturer2() throws Exception {
        WebElement manufacturer2 = driver.findElement(By.cssSelector("input[value='Manufacturer 2']"));
        if (manufacturer2.isSelected())
            manufacturer2.click();
    }

    public void setSearchAttribute(String searchString) throws Exception {
        driver.findElement(By.cssSelector("input[type='text'][name='searchString']")).clear();
        driver.findElement(By.cssSelector("input[type='text'][name='searchString']")).sendKeys(searchString);
    }

    public void clickFilter() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Filter']")).click();
    }

    public MyBasket clickContinue() throws Exception {

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new MyBasket(driver);
    }

    public void clickAdvanceFilterLink() throws Exception {
        driver.findElement(By.linkText("Advanced Filter")).click();
    }

    public HandsetDetails viewDetailsOfHandset(String Handset) throws Exception {

        driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='View Details']")).click();
        return new HandsetDetails(driver);
    }

    public ChooseYourHandset clickAddToCompare(String Handset) throws Exception {

        driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Add to Compare']")).click();
        return new ChooseYourHandset(driver);
    }

    public String comparableDevice1() throws Exception {
        String temp = driver.findElement(By.xpath(".//div[@class='comparisonItem' and starts-with(.,'1.')]")).getText();
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

    public CompareDevices clickCompare() throws Exception {
        driver.findElement(By.cssSelector("input[type='submit'][value='Compare']")).click();
        return new CompareDevices(driver);
    }

    public String comparableDevice2() throws Exception {
        String temp = driver.findElement(By.xpath(".//div[@class='comparisonItem' and starts-with(.,'2.')]")).getText();
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

}

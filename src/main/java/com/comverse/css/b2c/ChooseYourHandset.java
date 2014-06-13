/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2c;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class ChooseYourHandset extends B2CMenu {

    public ChooseYourHandset(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Choose Your Handset";

        // Check that we're on the right page.
        if (!expectedScreen.equals(tool.driver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps
            // logging out first
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourPrimaryOffer selectHandset(String Handset) throws Exception {

        tool.driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public MyBasket selectHandsetExpectingMyBasket(String Handset) throws Exception {

        tool.driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Select']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void selectManufacturer1() throws Exception {
        WebElement manufacturer1 = tool.driver.findElement(By.cssSelector("input[value='Manufacturer 1']"));
        if (!(manufacturer1.isSelected()))
            manufacturer1.click();
    }

    public void unSelectManufacturer1() throws Exception {
        WebElement manufacturer1 = tool.driver.findElement(By.cssSelector("input[value='Manufacturer 1']"));
        if (manufacturer1.isSelected())
            manufacturer1.click();
    }

    public void selectManufacturer2() throws Exception {
        WebElement manufacturer2 = tool.driver.findElement(By.cssSelector("input[value='Manufacturer 2']"));
        if (!(manufacturer2.isSelected()))
            manufacturer2.click();
    }

    public void unSelectManufacturer2() throws Exception {
        WebElement manufacturer2 = tool.driver.findElement(By.cssSelector("input[value='Manufacturer 2']"));
        if (manufacturer2.isSelected())
            manufacturer2.click();
    }

    public void setSearchAttribute(String searchString) throws Exception {
        tool.enterStringUsingCssSelector(tool, "input[type='text'][name='searchString']", searchString);
    }

    public void clickFilter() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Filter']")).click();
    }

    public MyBasket clickContinue() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Continue']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new MyBasket(tool, test, user);
    }

    public void clickAdvanceFilterLink() throws Exception {
        tool.clickUsingLinkText(tool, "Advanced Filter");
    }

    public HandsetDetails viewDetailsOfHandset(String Handset) throws Exception {

        tool.driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='View Details']")).click();
        return new HandsetDetails(tool, test, user);
    }

    public ChooseYourHandset clickAddToCompare(String Handset) throws Exception {

        tool.driver.findElement(By.xpath(".//p[contains(text(),'" + Handset + "')]//../following-sibling::div[2]//input[@type='submit' and @value='Add to Compare']")).click();
        return new ChooseYourHandset(tool, test, user);
    }

    public String comparableDevice1() throws Exception {
        String temp = tool.driver.findElement(By.xpath(".//div[@class='comparisonItem' and starts-with(.,'1.')]")).getText();
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

    public CompareDevices clickCompare() throws Exception {
        tool.driver.findElement(By.cssSelector("input[type='submit'][value='Compare']")).click();
        return new CompareDevices(tool, test, user);
    }

    public String comparableDevice2() throws Exception {
        String temp = tool.driver.findElement(By.xpath(".//div[@class='comparisonItem' and starts-with(.,'2.')]")).getText();
        String[] compareDevice = temp.split(":");
        return compareDevice[1].trim();

    }

}

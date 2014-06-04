/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeliveryAddressesCommon extends CommonMenu {

    public DeliveryAddressesCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();
        String expectedScreen = "Delivery Addresses";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public String getSelectDeliveryAddressMessage() throws Exception {

        return driver.findElement(By.xpath("//div[3]/div[2]/div/div/span")).getText();

    }

    public String getNoDeliveryAddressMessage() throws Exception {

        return driver.findElement(By.xpath("//div[5]/div[2]/div/div/span")).getText();

    }

    public String getDeliveryAddressMessageAfterSearch() throws Exception {

        return driver.findElement(By.xpath("//div[5]/div[2]/div/div/span")).getText();

    }

    public DeliveryAddressesCommon searchWithWildCard(String wildcard) throws Exception {
        enterSearchString(wildcard);
        driver.findElement(By.name("submit")).click();
        return new DeliveryAddressesCommon(driver);
    }

    public void enterSearchString(String searchString) {
        driver.findElement(By.name("searchText")).clear();
        driver.findElement(By.name("searchText")).sendKeys(searchString);
    }

    public AddDeliveryAddressCommon clickAdd() throws Exception {

        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
        return new AddDeliveryAddressCommon(driver);
    }

    public String getSuccessfulAddDelvieryAddressMessage() throws Exception {

        return driver.findElement(By.xpath("//div[3]/div[2]/div/div/span")).getText();

    }

    public ModifyDeliveryAddressCommon clickModify() throws Exception {

        driver.findElement(By.linkText("update")).click();
        return new ModifyDeliveryAddressCommon(driver);
    }

    public RemoveDeliveryAddressCommon clickRemove() throws Exception {

        driver.findElement(By.id("lnk_REMOVE_0")).click();
        return new RemoveDeliveryAddressCommon(driver);
    }

    public void clickMakeDefault() throws Exception {

        driver.findElement(By.linkText("make default")).click();

    }
}

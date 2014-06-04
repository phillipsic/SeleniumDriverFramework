package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryAdministration {
    public WebDriver driver;
    
    public InventoryAdministration(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Inventory Administration";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InsertInventory clickInsertInventory() throws Exception {

        driver.findElement(By.linkText("Insert Inventory")).click();

        return new InsertInventory(driver);
    }

    public AddressAdministration clickAddressAdministration() throws Exception {

        driver.findElement(By.id("smnu_ADDRESS_ADMINISTRATION")).click();

        return new AddressAdministration(driver);

    }

    public InventoryAdministration clickInventoryAdministration() throws Exception {

        driver.findElement(By.id("smnu_INVENTORY_ADMINISTRATION")).click();

        return new InventoryAdministration(driver);

    }

    public TokenAdministration clickTokenAdministration() throws Exception {

        driver.findElement(By.id("smnu_TOKEN_ADMINISTRATION")).click();

        return new TokenAdministration(driver);

    }

    public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {

        driver.findElement(By.id("smnu_TEMPLATE_ADMINISTRATION")).click();

        return new OutboundCommunicationTemplate(driver);

    }
    
}


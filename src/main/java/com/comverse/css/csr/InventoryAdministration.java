package com.comverse.css.csr;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class InventoryAdministration extends CommonMenu {

    public InventoryAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Inventory Administration";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InsertInventory clickInsertInventory() throws Exception {

        tool.driver.findElement(By.linkText("Insert Inventory")).click();

        return new InsertInventory(tool, test, user);
    }

    public AddressAdministration clickAddressAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_ADDRESS_ADMINISTRATION")).click();

        return new AddressAdministration(tool, test, user);

    }

    public InventoryAdministration clickInventoryAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_INVENTORY_ADMINISTRATION")).click();

        return new InventoryAdministration(tool, test, user);

    }

    public TokenAdministration clickTokenAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TOKEN_ADMINISTRATION")).click();

        return new TokenAdministration(tool, test, user);

    }

    public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {

        tool.driver.findElement(By.id("smnu_TEMPLATE_ADMINISTRATION")).click();

        return new OutboundCommunicationTemplate(tool, test, user);

    }

}

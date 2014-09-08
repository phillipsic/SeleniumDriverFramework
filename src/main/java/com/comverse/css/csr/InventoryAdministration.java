package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class InventoryAdministration extends CommonMenu {

    public InventoryAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Inventory Administration";

        if (!expectedScreen.equals(tool.getTitle())) {
            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public InsertInventory clickInsertInventory() throws Exception {
        tool.clickUsingLinkText("Insert Inventory");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new InsertInventory(tool, test, user);
    }

    public AddressAdministration clickAddressAdministration() throws Exception {
        tool.clickUsingID("smnu_ADDRESS_ADMINISTRATION");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddressAdministration(tool, test, user);
    }

    public InventoryAdministration clickInventoryAdministration() throws Exception {
        tool.clickUsingID("smnu_INVENTORY_ADMINISTRATION");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new InventoryAdministration(tool, test, user);
    }

    public TokenAdministration clickTokenAdministration() throws Exception {
        tool.clickUsingID("smnu_TOKEN_ADMINISTRATION");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new TokenAdministration(tool, test, user);
    }

    public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {
        tool.clickUsingID("smnu_TEMPLATE_ADMINISTRATION");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new OutboundCommunicationTemplate(tool, test, user);
    }

}

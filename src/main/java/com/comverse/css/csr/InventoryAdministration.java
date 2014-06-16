package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class InventoryAdministration extends CommonMenu {

    public InventoryAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Inventory Administration";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public InsertInventory clickInsertInventory() throws Exception {

        tool.clickUsingLinkText(tool, "Insert Inventory");

        return new InsertInventory(tool, test, user);
    }

    public AddressAdministration clickAddressAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_ADDRESS_ADMINISTRATION");

        return new AddressAdministration(tool, test, user);

    }

    public InventoryAdministration clickInventoryAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_INVENTORY_ADMINISTRATION");

        return new InventoryAdministration(tool, test, user);

    }

    public TokenAdministration clickTokenAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TOKEN_ADMINISTRATION");

        return new TokenAdministration(tool, test, user);

    }

    public OutboundCommunicationTemplate clickTemplateAdministration() throws Exception {

        tool.clickUsingID(tool, "smnu_TEMPLATE_ADMINISTRATION");

        return new OutboundCommunicationTemplate(tool, test, user);

    }

}

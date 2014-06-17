package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class InsertInventory extends CommonMenu {

    public InsertInventory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Insert Inventory";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectInventoryType(String inventoryType) throws Exception {

        tool.selectVisibleTextByID(tool, "inventoryType", inventoryType);
        Common.sleepForNumberOfSeconds(10);
    }

    public void setSerialNumber(String serialNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "serialNumber", serialNumber);

    }

    public void setPrimaryNumber(String primaryNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "primaryNumber", primaryNumber);

    }

    public void setSecondaryNumber(String secondaryNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "secondaryNumber", secondaryNumber);

    }

    public void setTertiaryNumber(String tertiaryNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "tertiaryNumber", tertiaryNumber);

    }

    public void setServiceNumber(String serviceNumber) throws Exception {

        
        tool.enterStringUsingId(tool, "serviceNumber", serviceNumber);

    }

    public ActionDone clickInsert() throws Exception {

        tool.clickUsingID(tool, "insertbtn");

        return new ActionDone(tool, test, user);
    }
}

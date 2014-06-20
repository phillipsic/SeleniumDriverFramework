package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.CommonMenu;

public class InsertInventory extends CommonMenu {

    public InsertInventory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Insert Inventory";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void selectInventoryType(String inventoryType) throws Exception {

        tool.selectVisibleTextByID("inventoryType", inventoryType);
        Common.sleepForNumberOfSeconds(10);
    }

    public void setSerialNumber(String serialNumber) throws Exception {

        
        tool.enterStringUsingId("serialNumber", serialNumber);

    }

    public void setPrimaryNumber(String primaryNumber) throws Exception {

        
        tool.enterStringUsingId("primaryNumber", primaryNumber);

    }

    public void setSecondaryNumber(String secondaryNumber) throws Exception {

        
        tool.enterStringUsingId("secondaryNumber", secondaryNumber);

    }

    public void setTertiaryNumber(String tertiaryNumber) throws Exception {

        
        tool.enterStringUsingId("tertiaryNumber", tertiaryNumber);

    }

    public void setServiceNumber(String serviceNumber) throws Exception {

        
        tool.enterStringUsingId("serviceNumber", serviceNumber);

    }

    public ActionDone clickInsert() throws Exception {

        tool.clickUsingID("insertbtn");

        return new ActionDone(tool, test, user);
    }
}

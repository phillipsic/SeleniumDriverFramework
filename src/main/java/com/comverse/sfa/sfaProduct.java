package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaProduct extends SFAMenu {

    public sfaProduct(AutomationTool tool, Test test, User user) {
        super(tool, test, user);
    }

    sfaB2BLead selectProductForB2BLead(String productName) throws Exception {

        String curentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId("I7olilf", productName);
        tool.clickUsingID("$n1almt_filterbutton");
        Common.sleepForNumberOfSeconds(2);
        if (!tool.searchUsingID("$n1almt_rowChkBox_0").isSelected()) {
            tool.clickUsingID("$n1almt_rowChkBox_0");
        }
        tool.clickUsingID("Af7fj1i");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity selectProductForOpportunity(String productName) throws Exception {
        String curentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId("Imintjv", productName);
        tool.clickUsingID("$ncrm6b_filterbutton");
        Common.sleepForNumberOfSeconds(2);
        if (!tool.searchUsingID("$ncrm6b_rowChkBox_0").isSelected()) {
            tool.clickUsingID("$ncrm6b_rowChkBox_0");
        }
        tool.clickUsingID("Ar4pj4u");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaOpportunity(tool, test, user);
    }
}

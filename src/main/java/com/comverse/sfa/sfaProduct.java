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

        tool.enterStringUsingId(tool, "I7olilf", productName);
        tool.clickUsingID(tool, "$n1almt_filterbutton");
        Common.sleepForNumberOfSeconds(2);
        if (!tool.searchUsingID(tool, "$n1almt_rowChkBox_0").isSelected()) {
            tool.clickUsingID(tool, "$n1almt_rowChkBox_0");
        }
        tool.clickUsingID(tool, "Af7fj1i");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaB2BLead(tool, test, user);
    }

    sfaOpportunity selectProductForOpportunity(String productName) throws Exception {
        String curentWindow = Common.getCurrentWindowHandle(tool);

        tool.enterStringUsingId(tool, "Imintjv", productName);
        tool.clickUsingID(tool, "$ncrm6b_filterbutton");
        Common.sleepForNumberOfSeconds(2);
        if (!tool.searchUsingID(tool, "$ncrm6b_rowChkBox_0").isSelected()) {
            tool.clickUsingID(tool, "$ncrm6b_rowChkBox_0");
        }
        tool.clickUsingID(tool, "Ar4pj4u");
        Common.sleepForNumberOfSeconds(3);

        Common.switchToNewWindow(tool, curentWindow);

        return new sfaOpportunity(tool, test, user);
    }
}

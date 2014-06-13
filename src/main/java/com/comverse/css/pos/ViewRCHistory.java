/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewRCHistoryCommon;

public class ViewRCHistory extends ViewRCHistoryCommon {

    public ViewRCHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Search']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewNRCHistoryCommon;

public class ViewNRCHistory extends ViewNRCHistoryCommon {

    public ViewNRCHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void clickSearch() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Search']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

}

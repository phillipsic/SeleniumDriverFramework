/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.ViewUsageHistoryCommon;

public class ViewUsageHistory extends ViewUsageHistoryCommon {

    public ViewUsageHistory(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public void clickSearch() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Search']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }
}
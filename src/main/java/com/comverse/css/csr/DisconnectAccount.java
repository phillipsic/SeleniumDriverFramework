package com.comverse.css.csr;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.DisconnectAccountCommon;

public class DisconnectAccount extends DisconnectAccountCommon {

    public DisconnectAccount(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public void clickCheckBoxUnlockNow() throws Exception {
        tool.driver.findElement(By.id("disconnectNow")).click();
    }

    @Override
    public void setAnnotation(String annotation) throws Exception {

        tool.driver.findElement(By.id("annotation")).clear();
        tool.driver.findElement(By.id("annotation")).sendKeys(annotation);
    }

    @Override
    public DisconnectAccount clickContinue() throws Exception {
        super.clickContinue();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public DisconnectAccount clickContinueOnImpacts() throws Exception {
        super.clickContinueOnImpacts();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public AccountDetails clickOk() throws Exception {
        super.clickOk();
        return new AccountDetails(tool, test, user);
    }
}
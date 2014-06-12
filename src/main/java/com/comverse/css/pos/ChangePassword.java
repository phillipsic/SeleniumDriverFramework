package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ChangePasswordCommon;

public class ChangePassword extends ChangePasswordCommon {

    public ChangePassword(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ModifyLoginPassword clickChange() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Change']")).click();
        return new ModifyLoginPassword(tool, test, user);
    }
}

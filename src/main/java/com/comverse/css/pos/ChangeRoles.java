/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ChangeRolesCommon;

public class ChangeRoles extends ChangeRolesCommon {

    public ChangeRoles(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    public ModifyLoginRoles clickConfirm() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Confirm']")).click();
        return new ModifyLoginRoles(tool, test, user);

    }
}
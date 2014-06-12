/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewHierarchyCommon;

public class ViewHierarchy extends ViewHierarchyCommon {

    public ViewHierarchy(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public AddEmployeeContactInformation addNewEmployee() throws Exception {

        tool.driver.findElement(By.id("smnu_REGISTER_EMPLOYEE")).click();
        return new AddEmployeeContactInformation(tool, test, user);
    }

    @Override
    public MyshapeBusiness clickLogout() throws Exception {

        super.clickLogout();
        return new MyshapeBusiness(tool, test, user);
    }

    public SearchEmployeePage clickSearchEmployee() throws Exception {

        tool.driver.findElement(By.id("smnu_MEMBER")).click();
        return new SearchEmployeePage(tool, test, user);
        // clicks search employee link on the view hierarchy page, new page
        // expected is search employee page.
    }

}
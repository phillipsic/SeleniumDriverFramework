package com.comverse.sec;

import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class SecCsrAdmin extends CommonMenu {

    public SecCsrAdmin(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Security | Add User";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public void setFirstName(String firstName) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:firstNameField:j_id97", firstName);
    }

    public void setLastName(String lastName) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:lastNameField:j_id119", lastName);
    }

    public void setUserName(String userName) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:userNameField:j_id59", userName);
    }

    public void setPassword(String password) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:passwordField:j_id75", password);
    }

    public void setRePassword(String repassword) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:re-passwordField:j_id86", repassword);
    }

    public void setEmail(String email) throws Exception {

        
        tool.enterStringUsingId(tool, "j_id44:j_id45:0:emailField:j_id163", email);
    }

    public void setGroups(String Group) throws Exception {

        new Select(tool.searchUsingID(tool, "j_id44:j_id45:0:tempGroupsUpdate:j_id245")).selectByVisibleText(Group);
        tool.clickUsingID(tool, "j_id44:j_id45:0:tempGroupsUpdate:j_id247");

    }

    public void clickSave() throws Exception {

        tool.clickUsingID(tool, "j_id44:j_id45:0:save");

    }

}

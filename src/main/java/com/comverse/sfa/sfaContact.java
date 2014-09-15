package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaContact extends SFAMenu {

    public sfaContact(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Comverse ONE Billing and Active Customer Management";

        if (!expectedScreen.equals(currentScreen)) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void setFirstNameLastnameForContact(String contactFN, String contactLN, String mainWindow, String contactWindow) throws Exception {
        tool.clickUsingID("Iyz46co_img"); // open name
                                                // detail dialog
        Common.sleepForNumberOfSeconds(3);
        Common.switchToNewWindow(tool, mainWindow, contactWindow);

        tool.enterStringUsingId("Ie5fc8b", contactFN); // set
                                                             // first
                                                             // name

        tool.enterStringUsingId("Ik35shv", contactLN); // set
                                                             // last
                                                             // name
        tool.clickUsingID("Ab0lxf"); // click save
        Common.sleepForNumberOfSeconds(3);
    }

    public void clickSaveContact() throws Exception {
        tool.clickUsingID("Aowwzkq");
        Common.sleepForNumberOfSeconds(3);
    }

}

package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddressAdministrationCommon;

public class AddressAdministration extends AddressAdministrationCommon {

    public AddressAdministration(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle(tool);
        String expectedScreen = "Address Administration";

        if (!expectedScreen.equals(tool.getTitle(tool))) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public AddressAdd clickAdd() throws Exception {

        tool.clickUsingXPath(tool, "//input[@value='Add']");

        return new AddressAdd(tool, test, user);
    }
}

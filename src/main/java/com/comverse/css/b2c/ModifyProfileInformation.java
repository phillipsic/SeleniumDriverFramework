package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ModifyProfileInformation extends B2CMenu {

    public ModifyProfileInformation(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Modify Profile Information";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }
    }

    public void selectApprovalSequencing(String choice) throws Exception {

        tool.selectVisibleTextByID("approval_sequencing_field", choice);

    }

    public ConfirmModifyProfileInformation clickOK() throws Exception {

        tool.clickUsingID("okButton");
        return new ConfirmModifyProfileInformation(tool, test, user);

    }
}

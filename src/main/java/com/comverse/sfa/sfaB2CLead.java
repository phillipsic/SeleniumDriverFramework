/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.sfa;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class sfaB2CLead extends SFAMenu {

    sfaB2CLead(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        if (!tool.checkDisplayedUsingXpath(tool, "//div[contains(text(), 'B2C Lead')]")) {
            throw new IllegalStateException("Expected B2C Lead screen doesn't show");

        }
    }

    void findAndOpenB2CLeadByNameAndCreatedDate(String b2cLeadName, String createdDate) throws Exception {
        // Set B2C Lead Name

        tool.enterStringUsingId(tool, "Iny33ei", b2cLeadName);

        // Set Created Date
        tool.clickUsingXPath(tool, "//nobr[contains(text(), 'More Fields')]");
        if (createdDate.equals("Today")) {

            tool.enterStringUsingId(tool, "Imcusxj", Common.getSysdateDDMMYYYY());
        } else {

            tool.enterStringUsingId(tool, "Imcusxj", createdDate);
        }

        // Click Search
        tool.clickUsingID(tool, "$ff0jf0_filterbutton");

        // Open B2C Lead
        tool.clickUsingID(tool, "$ff0jf0_cell_0_0_Img");
    }

    String getB2CLeadName() throws Exception {
        return tool.getAttributeUsingId(tool, "Ix18yor", "value");

    }

    String getB2CLeadType() throws Exception {
        return tool.getSelectedTextByID(tool, "Ircc1q4");
    }

    String getNewProspectFlag() throws Exception {
        return tool.getAttributeUsingId(tool, "Ib356er", "oldvalue");
    }

    String getPriority() throws Exception {
        return tool.getSelectedTextByID(tool, "Ifn7a0g");
    }

    String getStatus() throws Exception {
        return tool.getSelectedTextByID(tool, "I5nq7j6");
    }

    void openOfferList() throws Exception {
        tool.clickUsingID(tool, "tab_2FF5365DFE2744C08BB6F37626432885:0~0~3~0~0_split_13");
    }

    String getFirstOfferId() throws Exception {
        return tool.getTextUsingId(tool, "$l9ifba_cell_0_1_span");
    }

    String getFirstOfferName() throws Exception {
        return tool.getTextUsingId(tool, "$l9ifba_cell_0_3_span");
    }
}

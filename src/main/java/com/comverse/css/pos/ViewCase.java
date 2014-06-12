/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ViewCaseCommon;

public class ViewCase extends ViewCaseCommon {

    public ViewCase(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    @Override
    public EditCase clickEditCase() throws Exception {
        super.clickEditCase();
        return new EditCase(tool, test, user);
    }

    @Override
    public CreateAttachment clickAddAttachment() throws Exception {
        super.clickAddAttachment();
        return new CreateAttachment(tool, test, user);
    }

}
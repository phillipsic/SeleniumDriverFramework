/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ModifyOfferParametersCommon;

public class ModifyOfferParameters extends ModifyOfferParametersCommon {

    public ModifyOfferParameters(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public ModifyItemOfSubscriber clickModify() throws Exception {
        super.clickModify();
        return new ModifyItemOfSubscriber(tool, test, user);
    }

}

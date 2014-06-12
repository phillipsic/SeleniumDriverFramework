/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.ResumeBasketConfirmCommon;

public class ResumeBasketConfirm extends ResumeBasketConfirmCommon {

    public ResumeBasketConfirm(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public MyBasket clickOk() throws Exception {

        super.clickOk();
        return new MyBasket(tool, test, user);
    }
}

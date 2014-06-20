/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.RemoveBasketCommon;

public class RemoveBasket extends RemoveBasketCommon {

    public RemoveBasket(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public WorkSpace clickYes() throws Exception {

        tool.clickUsingXPath("//form[@id='form_YES']/div/input");
        return new WorkSpace(tool, test, user);
    }
}

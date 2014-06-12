/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.EnterIdentificationDataCommon;
import com.comverse.css.commonpages.SearchAddressCommon;

public class SearchAddress extends SearchAddressCommon {

    public SearchAddress(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

    }

    public SearchAddress clickOK() throws Exception {

        super.clickOk();
        return new SearchAddress(tool, test, user);
    }

    public EnterIdentificationDataCommon clickSelectAddress() throws Exception {

        super.clickSelectAddress();
        return new EnterIdentificationData(tool, test, user);
    }

}
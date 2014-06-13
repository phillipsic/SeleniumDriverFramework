package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.WorkSpaceCommon;

public class WorkSpace extends WorkSpaceCommon {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {

        super(tool, test, user);

    }

    @Override
    public ContactInformation clickUserInformation() throws Exception {

        tool.clickUsingID(tool, "mnu_INFO");
        return new ContactInformation(tool, test, user);
    }

    @Override
    public MyShapeChannel clickLogout() throws Exception {

        super.clickLogout();
        return new MyShapeChannel(tool, test, user);
    }

    @Override
    public IdentifyCustomer gotoManageAccount() throws Exception {
        super.gotoManageAccount();
        return new IdentifyCustomer(tool, test, user);
    }

    @Override
    public EnterIdentificationData startNewConvergentResidentialCustomer() throws Exception {

        super.startNewConvergentResidentialCustomer();
        return new EnterIdentificationData(tool, test, user);
    }

    @Override
    public EnterIdentificationData startNewConvergentBusinessCustomer() throws Exception {

        super.startNewConvergentBusinessCustomer();
        return new EnterIdentificationData(tool, test, user);
    }

    @Override
    public SearchRequests clickRequests() throws Exception {
        super.clickRequests();
        return new SearchRequests(tool, test, user);
    }

    @Override
    public ViewHierarchy clickHierarchy() throws Exception {

        super.clickHierarchy();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public Shopping clickSubmit() throws Exception {

        super.clickSubmit();
        return new Shopping(tool, test, user);
    }
}

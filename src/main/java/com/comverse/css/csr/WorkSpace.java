package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.WorkSpaceCommon;

public class WorkSpace extends WorkSpaceCommon {

    public WorkSpace(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {
        super.clickLogout();
        return new MyshapeCSRPortal(tool, test, user);
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
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    @Override
    public SearchRequests clickRequests() throws Exception {
        super.clickRequests();
        return new SearchRequests(tool, test, user);
    }

    @Override
    public LevelLegalContact clickHierarchyCSR() throws Exception {
        super.clickHierarchyCSR();
        return new LevelLegalContact(tool, test, user);
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

    @Override
    public LoginInformation clickMyInformation() throws Exception {
        super.clickMyInformation();
        return new LoginInformation(tool, test, user);
    }

    @Override
    public ViewHierarchy clickManageTelco() throws Exception {
        super.clickManageTelco();
        return new ViewHierarchy(tool, test, user);
    }
}

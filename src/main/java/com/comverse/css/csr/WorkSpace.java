package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.WorkSpaceCommon;

public class WorkSpace extends WorkSpaceCommon {

    public WorkSpace(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public MyshapeCSRPortal clickLogout() throws Exception {
        super.clickLogout();
        return new MyshapeCSRPortal(driver);
    }

    @Override
    public IdentifyCustomer gotoManageAccount() throws Exception {
        super.gotoManageAccount();
        return new IdentifyCustomer(driver);
    }

    @Override
    public EnterIdentificationData startNewConvergentResidentialCustomer() throws Exception {
        super.startNewConvergentResidentialCustomer();
        return new EnterIdentificationData(driver);
    }

    @Override
    public EnterIdentificationData startNewConvergentBusinessCustomer() throws Exception {
        super.startNewConvergentBusinessCustomer();
        return new EnterIdentificationData(driver);
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(driver);
    }

    @Override
    public SearchRequests clickRequests() throws Exception {
        super.clickRequests();
        return new SearchRequests(driver);
    }

    @Override
    public LevelLegalContact clickHierarchyCSR() throws Exception {
        super.clickHierarchyCSR();
        return new LevelLegalContact(driver);
    }

    @Override
    public ViewHierarchy clickHierarchy() throws Exception {
        super.clickHierarchy();
        return new ViewHierarchy(driver);
    }

    @Override
    public Shopping clickSubmit() throws Exception {
        super.clickSubmit();
        return new Shopping(driver);
    }

    @Override
    public LoginInformation clickMyInformation() throws Exception {
        super.clickMyInformation();
        return new LoginInformation(driver);
    }

    @Override
    public ViewHierarchy clickManageTelco() throws Exception {
        super.clickManageTelco();
        return new ViewHierarchy(driver);
    }
}

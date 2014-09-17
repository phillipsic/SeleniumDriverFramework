package com.comverse.css.b2b;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;
import com.comverse.css.commonpages.AccountDetailsCommon;

public class AccountDetails extends AccountDetailsCommon {

    public AccountDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public AddNewCase addNewCase() throws Exception {
        super.addNewCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public DeliveryAddresses clickDeliveryAddresses() throws Exception {
        super.clickDeliveryAddresses();
        return new DeliveryAddresses(tool, test, user);
    }

    @Override
    public ViewInvoices clickBillsAndPayments() throws Exception {
        super.clickBillsAndPayments();
        return new ViewInvoices(tool, test, user);
    }

    @Override
    public AddNewCase clickLinkOfFirstCase() throws Exception {
        super.clickLinkOfFirstCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {
        super.clickLinkOfCaseID(caseID);
        return new ViewCase(tool, test, user);
    }

    @Override
    public SubscriberDetails selectFirstSubscriberFromNavigationPanel() throws Exception {
        super.selectFirstSubscriberFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnExistingAccount() throws Exception {
        super.clickNewConvergentSubscriberOnExistingAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public Shopping clickShopForDevicesAndAccessories() throws Exception {
        super.clickShopForDevicesAndAccessories();
        return new Shopping(tool, test, user);
    }

    @Override
    public RequestsForCustomer clickViewRequestsForThisCustomer() throws Exception {
        super.clickViewRequestsForThisCustomer();
        return new RequestsForCustomer(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyBillingContact() throws Exception {
        super.clickModifyBillingContact();
        return new ModifyContactInformation(tool, test, user);
    }

    @Override
    public ModifyPaymentInformation clickModifyPaymentMethod() throws Exception {
        super.clickModifyPaymentMethod();
        return new ModifyPaymentInformation(tool, test, user);
    }

    @Override
    public ModifyAccountAttributes clickModifyAccountContact() throws Exception {
        super.clickModifyAccountContact();
        return new ModifyAccountAttributes(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickAddNewAccountOffer() throws Exception {
        test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("(//a[@title='Subscribe new Account Offers'])");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveFirstAccountOffer() throws Exception {
        super.clickRemoveFirstAccountOffer();
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveAccountOffer(String newOfferName) throws Exception {
        super.clickRemoveAccountOffer(newOfferName);
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickReconfigureAccountOffer() throws Exception {
        super.clickReconfigureAccountOffer();
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    @Override
    public MyBasket clickViewBasket() throws Exception {
        super.clickViewBasket();
        return new MyBasket(tool, test, user);
    }
}

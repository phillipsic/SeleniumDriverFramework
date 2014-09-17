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
    public AddNewCase addNewCase() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.addNewCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public DeliveryAddresses clickDeliveryAddresses() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickDeliveryAddresses();
        return new DeliveryAddresses(tool, test, user);
    }

    @Override
    public ViewInvoices clickBillsAndPayments() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickBillsAndPayments();
        return new ViewInvoices(tool, test, user);
    }

    @Override
    public AddNewCase clickLinkOfFirstCase() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickLinkOfFirstCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickLinkOfCaseID(caseID);
        return new ViewCase(tool, test, user);
    }

    @Override
    public SubscriberDetails selectFirstSubscriberFromNavigationPanel() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.selectFirstSubscriberFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnExistingAccount() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickNewConvergentSubscriberOnExistingAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public Shopping clickShopForDevicesAndAccessories() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickShopForDevicesAndAccessories();
        return new Shopping(tool, test, user);
    }

    @Override
    public RequestsForCustomer clickViewRequestsForThisCustomer() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickViewRequestsForThisCustomer();
        return new RequestsForCustomer(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyBillingContact() throws Exception {  test.writeInLogFile(Common.getMethodName());

        super.clickModifyBillingContact();
        return new ModifyContactInformation(tool, test, user);
    }

    @Override
    public ModifyPaymentInformation clickModifyPaymentMethod() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickModifyPaymentMethod();
        return new ModifyPaymentInformation(tool, test, user);
    }

    @Override
    public ModifyAccountAttributes clickModifyAccountContact() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickModifyAccountContact();
        return new ModifyAccountAttributes(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickAddNewAccountOffer() throws Exception {  test.writeInLogFile(Common.getMethodName());
        tool.clickUsingXPath("(//a[@title='Subscribe new Account Offers'])");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveFirstAccountOffer() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickRemoveFirstAccountOffer();
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveAccountOffer(String newOfferName) throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickRemoveAccountOffer(newOfferName);
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickReconfigureAccountOffer() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickReconfigureAccountOffer();
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public ResumeAParkedBasket clickBasket() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickBasket();
        return new ResumeAParkedBasket(tool, test, user);
    }

    @Override
    public MyBasket clickViewBasket() throws Exception {  test.writeInLogFile(Common.getMethodName());
        super.clickViewBasket();
        return new MyBasket(tool, test, user);
    }
}

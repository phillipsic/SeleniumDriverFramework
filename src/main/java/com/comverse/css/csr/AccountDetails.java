package com.comverse.css.csr;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AccountDetailsCommon;

public class AccountDetails extends AccountDetailsCommon {

    public AccountDetails(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
    }

    @Override
    public PersonManagement clickPersonManagement() throws Exception {
        super.clickPersonManagement();
        return new PersonManagement(tool, test, user);
    }

    @Override
    public SubscriberDetails selectFirstSubscriberFromNavigationPanel() throws Exception {

        super.selectFirstSubscriberFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails clickSubscriberIDFromNavigationPanel() throws Exception {

        super.clickSubscriberIDFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails selectSubscriberByMSISDN(String MSISDN) throws Exception {

        super.selectSubscriberByMSISDN(MSISDN);
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public AddNewCase addNewCase() throws Exception {

        super.addNewCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public SendCommunication clickSendOutBoundCommunication() throws Exception {

        super.clickSendOutBoundCommunication();
        return new SendCommunication(tool, test, user);
    }

    @Override
    public ViewBalance clickViewBalancesAndRecharge() throws Exception {

        super.clickViewBalancesAndRecharge();
        return new ViewBalance(tool, test, user);
    }

    @Override
    public ViewInvoices clickBillsAndPayments() throws Exception {

        super.clickBillsAndPayments();
        return new ViewInvoices(tool, test, user);
    }

    @Override
    public ViewTransactionHistory clickHistories() throws Exception {
        super.clickHistories();
        return new ViewTransactionHistory(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickAddNewAccountOffer() throws Exception {

        super.clickAddNewAccountOffer();
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public RequestsForCustomer clickViewRequestsForThisCustomer() throws Exception {

        super.clickViewRequestsForThisCustomer();
        return new RequestsForCustomer(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveFirstAccountOffer() throws Exception {

        super.clickRemoveFirstAccountOffer();
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public ModifyAccountAttributes clickModifyAccountContact() throws Exception {

        super.clickModifyAccountContact();
        return new ModifyAccountAttributes(tool, test, user);
    }

    @Override
    public ModifyPaymentInformation clickModifyPaymentMethod() throws Exception {

        super.clickModifyPaymentMethod();
        return new ModifyPaymentInformation(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyBillingContact() throws Exception {

        super.clickModifyBillingContact();
        return new ModifyContactInformation(tool, test, user);
    }

    @Override
    public WorkSpace clickHome() throws Exception {
        super.clickHome();
        return new WorkSpace(tool, test, user);
    }

    @Override
    public DeliveryAddresses clickDeliveryAddresses() throws Exception {

        super.clickDeliveryAddresses();
        return new DeliveryAddresses(tool, test, user);
    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {

        super.clickLinkOfCaseID(caseID);
        return new ViewCase(tool, test, user);
    }

    @Override
    public RegisterPrepayment clickRegisterPrepayment() throws Exception {

        super.clickRegisterPrepayment();
        return new RegisterPrepayment(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnExistingAccount() throws Exception {

        super.clickNewConvergentSubscriberOnExistingAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnNewAccount() throws Exception {

        super.clickNewConvergentSubscriberOnNewAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public SwapBundle clickUpgrade() throws Exception {

        super.clickUpgrade();
        return new SwapBundle(tool, test, user);
    }

    @Override
    public DisconnectAccount clickDisconnectAccount() throws Exception {

        super.clickDisconnectAccount();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public AddDeposit clickAddDeposit() throws Exception {

        super.clickAddDeposit();
        return new AddDeposit(tool, test, user);
    }

    @Override
    public AccountDeposits clickViewDeposits() throws Exception {

        super.clickViewDeposits();
        return new AccountDeposits(tool, test, user);
    }

    @Override
    public AddStandaloneCharge clickAddStandaloneCharge() throws Exception {

        super.clickAddStandaloneCharge();
        return new AddStandaloneCharge(tool, test, user);
    }

    @Override
    public ViewHierarchy clickCustomerHierarchy() throws Exception {
        super.clickCustomerHierarchy();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public PersonDetails clickUpdatePerson() throws Exception {
        super.clickUpdatePerson();
        return new PersonDetails(tool, test, user);
    }
}

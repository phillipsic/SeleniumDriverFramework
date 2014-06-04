package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.AccountDetailsCommon;

public class AccountDetails extends AccountDetailsCommon {

    public AccountDetails(WebDriver driver) throws Exception {
        super(driver);
    }

    @Override
    public PersonManagement clickPersonManagement() throws Exception {
        super.clickPersonManagement();
        return new PersonManagement(driver);
    }

    @Override
    public SubscriberDetails selectFirstSubscriberFromNavigationPanel() throws Exception {

        super.selectFirstSubscriberFromNavigationPanel();
        return new SubscriberDetails(driver);
    }

    @Override
    public SubscriberDetails clickSubscriberIDFromNavigationPanel() throws Exception {

        super.clickSubscriberIDFromNavigationPanel();
        return new SubscriberDetails(driver);
    }

    @Override
    public SubscriberDetails selectSubscriberByMSISDN(String MSISDN) throws Exception {

        super.selectSubscriberByMSISDN(MSISDN);
        return new SubscriberDetails(driver);
    }

    @Override
    public AddNewCase addNewCase() throws Exception {

        super.addNewCase();
        return new AddNewCase(driver);
    }

    @Override
    public SendCommunication clickSendOutBoundCommunication() throws Exception {

        super.clickSendOutBoundCommunication();
        return new SendCommunication(driver);
    }

    @Override
    public ViewBalance clickViewBalancesAndRecharge() throws Exception {

        super.clickViewBalancesAndRecharge();
        return new ViewBalance(driver);
    }

    @Override
    public ViewInvoices clickBillsAndPayments() throws Exception {

        super.clickBillsAndPayments();
        return new ViewInvoices(driver);
    }

    @Override
    public ViewTransactionHistory clickHistories() throws Exception {
        super.clickHistories();
        return new ViewTransactionHistory(driver);
    }

    @Override
    public SelectOffersForYourAccount clickAddNewAccountOffer() throws Exception {

        super.clickAddNewAccountOffer();
        return new SelectOffersForYourAccount(driver);
    }

    @Override
    public RequestsForCustomer clickViewRequestsForThisCustomer() throws Exception {

        super.clickViewRequestsForThisCustomer();
        return new RequestsForCustomer(driver);
    }

    @Override
    public RemoveOffer clickRemoveFirstAccountOffer() throws Exception {

        super.clickRemoveFirstAccountOffer();
        return new RemoveOffer(driver);
    }

    @Override
    public ModifyAccountAttributes clickModifyAccountContact() throws Exception {

        super.clickModifyAccountContact();
        return new ModifyAccountAttributes(driver);
    }

    @Override
    public ModifyPaymentInformation clickModifyPaymentMethod() throws Exception {

        super.clickModifyPaymentMethod();
        return new ModifyPaymentInformation(driver);
    }

    @Override
    public ModifyContactInformation clickModifyBillingContact() throws Exception {

        super.clickModifyBillingContact();
        return new ModifyContactInformation(driver);
    }

    @Override
    public WorkSpace clickHome() throws Exception {
        super.clickHome();
        return new WorkSpace(driver);
    }

    @Override
    public DeliveryAddresses clickDeliveryAddresses() throws Exception {

        super.clickDeliveryAddresses();
        return new DeliveryAddresses(driver);
    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {

        super.clickLinkOfCaseID(caseID);
        return new ViewCase(driver);
    }

    @Override
    public RegisterPrepayment clickRegisterPrepayment() throws Exception {

        super.clickRegisterPrepayment();
        return new RegisterPrepayment(driver);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnExistingAccount() throws Exception {

        super.clickNewConvergentSubscriberOnExistingAccount();
        return new CustomerAcquisitionCustomerDataReview(driver);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnNewAccount() throws Exception {

        super.clickNewConvergentSubscriberOnNewAccount();
        return new CustomerAcquisitionCustomerDataReview(driver);
    }

    @Override
    public SwapBundle clickUpgrade() throws Exception {

        super.clickUpgrade();
        return new SwapBundle(driver);
    }

    @Override
    public DisconnectAccount clickDisconnectAccount() throws Exception {

        super.clickDisconnectAccount();
        return new DisconnectAccount(driver);
    }

    @Override
    public AddDeposit clickAddDeposit() throws Exception {

        super.clickAddDeposit();
        return new AddDeposit(driver);
    }

    @Override
    public AccountDeposits clickViewDeposits() throws Exception {

        super.clickViewDeposits();
        return new AccountDeposits(driver);
    }

    @Override
    public AddStandaloneCharge clickAddStandaloneCharge() throws Exception {

        super.clickAddStandaloneCharge();
        return new AddStandaloneCharge(driver);
    }

    @Override
    public ViewHierarchy clickCustomerHierarchy() throws Exception {
        super.clickCustomerHierarchy();
        return new ViewHierarchy(driver);
    }

    @Override
    public PersonDetails clickUpdatePerson() throws Exception {
        super.clickUpdatePerson();
        return new PersonDetails(driver);
    }
}

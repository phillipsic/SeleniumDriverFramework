package com.comverse.css.csr;

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
    public PersonManagement clickPersonManagement() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickPersonManagement();
        return new PersonManagement(tool, test, user);
    }

    @Override
    public SubscriberDetails selectFirstSubscriberFromNavigationPanel() throws Exception {  test.writeInLog(Common.getMethodName());

        super.selectFirstSubscriberFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails clickSubscriberIDFromNavigationPanel() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickSubscriberIDFromNavigationPanel();
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public SubscriberDetails selectSubscriberByMSISDN(String MSISDN) throws Exception {  test.writeInLog(Common.getMethodName());

        super.selectSubscriberByMSISDN(MSISDN);
        return new SubscriberDetails(tool, test, user);
    }

    @Override
    public AddNewCase addNewCase() throws Exception {  test.writeInLog(Common.getMethodName());

        super.addNewCase();
        return new AddNewCase(tool, test, user);
    }

    @Override
    public SendCommunication clickSendOutBoundCommunication() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickSendOutBoundCommunication();
        return new SendCommunication(tool, test, user);
    }

    @Override
    public ViewBalance clickViewBalancesAndRecharge() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickViewBalancesAndRecharge();
        return new ViewBalance(tool, test, user);
    }

    @Override
    public ViewInvoices clickBillsAndPayments() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickBillsAndPayments();
        return new ViewInvoices(tool, test, user);
    }

    @Override
    public ViewTransactionHistory clickHistories() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickHistories();
        return new ViewTransactionHistory(tool, test, user);
    }

    @Override
    public SelectOffersForYourAccount clickAddNewAccountOffer() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickAddNewAccountOffer();
        return new SelectOffersForYourAccount(tool, test, user);
    }

    @Override
    public RequestsForCustomer clickViewRequestsForThisCustomer() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickViewRequestsForThisCustomer();
        return new RequestsForCustomer(tool, test, user);
    }

    @Override
    public RemoveOffer clickRemoveFirstAccountOffer() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickRemoveFirstAccountOffer();
        return new RemoveOffer(tool, test, user);
    }

    @Override
    public ModifyAccountAttributes clickModifyAccountContact() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickModifyAccountContact();
        return new ModifyAccountAttributes(tool, test, user);
    }

    @Override
    public ModifyPaymentInformation clickModifyPaymentMethod() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickModifyPaymentMethod();
        return new ModifyPaymentInformation(tool, test, user);
    }

    @Override
    public ModifyContactInformation clickModifyBillingContact() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickModifyBillingContact();
        return new ModifyContactInformation(tool, test, user);
    }

    @Override
    public WorkSpace clickHome() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickHome();
        return new WorkSpace(tool, test, user);
    }

    @Override
    public DeliveryAddresses clickDeliveryAddresses() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickDeliveryAddresses();
        return new DeliveryAddresses(tool, test, user);
    }

    @Override
    public ViewCase clickLinkOfCaseID(String caseID) throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickLinkOfCaseID(caseID);
        return new ViewCase(tool, test, user);
    }

    @Override
    public RegisterPrepayment clickRegisterPrepayment() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickRegisterPrepayment();
        return new RegisterPrepayment(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnExistingAccount() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickNewConvergentSubscriberOnExistingAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public CustomerAcquisitionCustomerDataReview clickNewConvergentSubscriberOnNewAccount() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickNewConvergentSubscriberOnNewAccount();
        return new CustomerAcquisitionCustomerDataReview(tool, test, user);
    }

    @Override
    public SwapBundle clickUpgrade() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickUpgrade();
        return new SwapBundle(tool, test, user);
    }

    @Override
    public DisconnectAccount clickDisconnectAccount() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickDisconnectAccount();
        return new DisconnectAccount(tool, test, user);
    }

    @Override
    public AddDeposit clickAddDeposit() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickAddDeposit();
        return new AddDeposit(tool, test, user);
    }

    @Override
    public AccountDeposits clickViewDeposits() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickViewDeposits();
        return new AccountDeposits(tool, test, user);
    }

    @Override
    public AddStandaloneCharge clickAddStandaloneCharge() throws Exception {  test.writeInLog(Common.getMethodName());

        super.clickAddStandaloneCharge();
        return new AddStandaloneCharge(tool, test, user);
    }

    @Override
    public ViewHierarchy clickCustomerHierarchy() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickCustomerHierarchy();
        return new ViewHierarchy(tool, test, user);
    }

    @Override
    public PersonDetails clickUpdatePerson() throws Exception {  test.writeInLog(Common.getMethodName());
        super.clickUpdatePerson();
        return new PersonDetails(tool, test, user);
    }

    public void waitUntilSubscriberStatusChanged(String status) throws Exception {  test.writeInLog(Common.getMethodName());

        int maxIterations = 10;
        int iterationCounter = 0;
        String accountStatus;

        while (iterationCounter < maxIterations) {

            this.clickRefreshThisAccount();
            accountStatus = this.getSubscriberStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " :" + accountStatus);

            if (accountStatus.contains(status)) {

                System.out.println("Subscriber status changed to " + status);
                break;
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getAccountStatus());
        }
    }

    public String getSubscriberStatus() throws Exception {  test.writeInLog(Common.getMethodName());

        String orderStatus = tool.getTextUsingXPath("(//div[contains(text(),'Activated on:')])[2]/../div[2]");
        return orderStatus;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import static org.junit.Assert.assertTrue;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.b2b.AccountDetails;
import com.comverse.css.b2b.OfferCancellation;
import com.comverse.css.b2b.RemoveOffer;
import com.comverse.css.b2b.RequestsForCustomer;
import com.comverse.css.common.Common;

public class AccountDetailsCommon extends CommonMenu {

    static String expectedScreen = "Account Details";

    public AccountDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);

        String currentScreen = tool.getTitle();

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddNewCaseCommon addNewCase() throws Exception {
        tool.clickUsingLinkText("Add");

        return new AddNewCaseCommon(tool, test, user);
    }

    public AddNewCaseCommon clickLinkOfFirstCase() throws Exception {
        tool.clickUsingID("value_case_0_0");

        return new AddNewCaseCommon(tool, test, user);
    }

    public void clickHomeMenu() throws Exception {
        tool.clickUsingLinkText("Home");
    }

    public SelectOffersForYourAccountCommon clickAddNewAccountOffer() throws Exception {
        tool.clickUsingXPath("//p[contains(text(),'Bundle/Offers')]/../../div/a[contains(text(),'Add')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickReconfigure() throws Exception {
        tool.clickUsingLinkText("Reconfigure");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public ViewCaseCommon clickLinkOfCaseID(String caseID) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//span[text()=" + caseID + "]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }

    public ListCasesCommon clickMoreCases() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//a[@title='List all cases']");

        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ListCasesCommon(tool, test, user);
    }

    public SubscriberDetailsCommon selectFirstSubscriberFromNavigationPanel() throws Exception {
        System.out.println("selectFirstSubscriberFromNavigationPanel");
        tool.clickUsingID("NavigationLink");
        Common.sleepForNumberOfSeconds(1);
        // tool.clickUsingXPath("(//a[contains(text(),'open')])[2]");
        tool.clickUsingXPath("(//td[4]//a[contains(text(), 'open')])[1]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickSubscriberIDFromNavigationPanel() throws Exception {
        tool.clickUsingID("SubscriberSearchLink");
        Common.sleepForNumberOfSeconds(1);
        Common.assertTextOnPage(tool, "Please enter your criteria and press search");
        tool.clickUsingID("subscriberSearchButton");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//td[3]/div/a");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon selectSubscriberByMSISDN(String MSISDN) throws Exception {
        tool.clickUsingID("SubscriberSearchLink");
        tool.clickUsingID("subscriberSearchButton");
        Common.sleepForNumberOfSeconds(2);
        tool.clickUsingLinkText(MSISDN);
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public SendCommunicationCommon clickSendOutBoundCommunication() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, SendCommunicationCommon.expectedScreen, "firstYouCansendOutboundCommunicationMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SendCommunicationCommon(tool, test, user);
    }

    public ViewBalanceCommon clickViewBalancesAndRecharge() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, ViewBalanceCommon.expectedScreen, "firstYouCanviewBalancesMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewBalanceCommon(tool, test, user);
    }

    public RegisterPrepaymentCommon clickRegisterPrepayment() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, RegisterPrepaymentCommon.expectedScreen, "firstYouCanregisterPrepaymentMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RegisterPrepaymentCommon(tool, test, user);
    }

    public SearchOrdersCommon clickSearchOrders() throws Exception {
        tool.navigateRefresh();
        Common.sleepForNumberOfSeconds(1);
        tool.clickUsingCssSelector("#firstYouCan > input.submit");
        Common.sleepForNumberOfSeconds(1);
        tool.clickUsingLinkText("Search Orders");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchOrdersCommon(tool, test, user);
    }

    @Override
    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        tool.clickUsingID("mnu_BILLS_PAYMENTS");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(tool, test, user);
    }

    @Override
    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        tool.clickUsingID("mnu_HISTORIES");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public ModifyContactInformationCommon clickModifyBillingContact() throws Exception {
        tool.clickUsingXPath("//div[@id='tab1']/table/tbody/tr/td[2]/div[5]/a/u");
        return new ModifyContactInformationCommon(tool, test, user);
    }

    public ModifyPaymentInformationCommon clickModifyPaymentMethod() throws Exception {
        tool.clickUsingXPath("//div[8]/a/u");
        return new ModifyPaymentInformationCommon(tool, test, user);
    }

    public RequestsForCustomerCommon clickViewRequestsForThisCustomer() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, RequestsForCustomerCommon.expectedScreen, "firstYouCanviewCustomerRequestsMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new RequestsForCustomerCommon(tool, test, user);
    }

    public void clickRefreshThisAccount() throws Exception {

        Common.clickAction1ItemIsAccessible(tool, AccountDetailsCommon.expectedScreen, "firstYouCanrefreshAccountLink");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);

    }

    public void clickLinkOfOfferName(String offerName) throws Exception {
        tool.clickUsingLinkText(offerName);
    }

    public void clickCloseOfferDetailsBox() throws Exception {
        tool.clickUsingXPath("//input[@value='Close']");
    }

    public void clickAccountAttributesTab() throws Exception {
        tool.clickUsingXPath("//a[@href='#tab2']");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public SwapBundleCommon clickUpgrade() throws Exception {
        tool.clickUsingLinkText("Upgrade");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SwapBundleCommon(tool, test, user);
    }

    public ModifyAccountAttributesCommon clickModifyAccountContact() throws Exception {
        tool.clickUsingXPath("//div[2]/a/u");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyAccountAttributesCommon(tool, test, user);
    }

    public RemoveOfferCommon clickRemoveFirstAccountOffer() throws Exception {
        tool.clickUsingLinkText("Remove");
        return new RemoveOfferCommon(tool, test, user);
    }

    public RemoveOfferCommon clickRemoveAccountOffer(String newOfferName) throws Exception {
        tool.clickUsingXPath("//tr[td/a[contains(text(),'" + newOfferName + "')]]/td/a[contains(text(), 'Remove')]");
        return new RemoveOfferCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickReconfigureAccountOffer() throws Exception {
        tool.clickUsingLinkText("Reconfigure");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public DeliveryAddressesCommon clickDeliveryAddresses() throws Exception {
        tool.clickUsingID("mnu_DELIVERY_ADDRESSES");
        return new DeliveryAddressesCommon(tool, test, user);
    }

    public String getAccountNumber() throws Exception {
        String temp1[];
        String temp = tool.getTextUsingCssSelector("div.navContextMain");
        temp1 = temp.split("-");
        return Common.cleanStringOfIllegalChars(temp1[0]);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickNewConvergentSubscriberOnExistingAccount() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, CustomerAcquisitionCustomerDataReviewCommon.expectedScreen, "firstYouCanconvergentSubscriberMenu",
                "firstYouCanconvergentExistingAccountMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickNewConvergentSubscriberOnNewAccount() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, CustomerAcquisitionCustomerDataReviewCommon.expectedScreen, "firstYouCanconvergentSubscriberMenu",
                "firstYouCanconvergentNewAccountMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(tool, test, user);
    }

    public ShoppingCommon clickShopForDevicesAndAccessories() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, ShoppingCommon.expectedScreen, "firstYouCanShopDevicesMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ShoppingCommon(tool, test, user);

    }

    public void clickListAllCases() throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.clickUsingXPath("//p[contains(text(),'Cases (last 4 by date)')]/../../div/a[contains(text(),'More...')]");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public String doAddCase() throws Exception {
        AddNewCaseCommon addNewCase = this.addNewCase();
        addNewCase.selectCaseType("General Request");
        addNewCase.selectCaseProblemArea("Need Credit Limit Increased");
        addNewCase.enterCaseDescription("This was created by automated test.");
        addNewCase.selectNoteType("Task Note");
        addNewCase.enterNoteDescription("Note - Task to do");
        AddCaseReviewCommon addCaseReview = addNewCase.clickContinue();
        AddCaseConfirmationCommon addCaseConfirmation = addCaseReview.clickCreateCase();
        assertTrue(addCaseConfirmation.getConfirmationMessage().matches("^[\\s\\S]*Your case has been successfully created with the reference[\\s\\S]*$"));
        String caseId = addCaseConfirmation.getCaseID();
        addCaseConfirmation.clickOk();

        return (caseId);
    }

    public String doAddCaseAndClose() throws Exception {
        AddNewCaseCommon addNewCase = this.addNewCase();
        addNewCase.selectCaseType("General Request");
        addNewCase.selectCaseProblemArea("Need Credit Limit Increased");
        addNewCase.enterCaseDescription("This was created by automated test.");
        addNewCase.selectNoteType("Task Note");
        addNewCase.enterNoteDescription("Note - Task to do");
        AddCaseReviewCommon addCaseReview = addNewCase.clickContinue();
        AddCaseConfirmationCommon addCaseConfirmation = addCaseReview.clickCreateCaseAndClose();
        assertTrue(addCaseConfirmation.getConfirmationMessage().matches("^[\\s\\S]*Your case has been successfully created with the reference[\\s\\S]*$"));
        String caseId = addCaseConfirmation.getCaseID();
        addCaseConfirmation.clickOk();

        return (caseId);
    }

    public DisconnectAccountCommon clickDisconnectAccount() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, DisconnectAccountCommon.expectedScreen, "firstYouCandisconnectAccountMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new DisconnectAccountCommon(tool, test, user);
    }

    public void waitUntilAccountStatusChanged(String status) throws Exception {

        int maxIterations = 10;
        int iterationCounter = 0;
        String accountStatus;

        while (iterationCounter < maxIterations) {

            this.clickRefreshThisAccount();
            accountStatus = this.getAccountStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " :" + accountStatus);

            if (accountStatus.contains(status)) {

                System.out.println("Account status changed to " + status);
                break;
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getAccountStatus());
        }
    }

    public void waitUntilSubscriberStatusChanged(String status) throws Exception {

        int maxIterations = 10;
        int iterationCounter = 0;
        String accountStatus;

        while (iterationCounter < maxIterations) {

            this.clickRefreshThisAccount();
            accountStatus = this.getSubscriberStatus();

            System.out.println(this.getClass().getSimpleName() + ": Iteration  " + iterationCounter + " of " + maxIterations + " :" + accountStatus);

            if (accountStatus.contains(status)) {

                System.out.println("Account status changed to " + status);
                break;
            }

            iterationCounter++;
        }

        if (iterationCounter >= maxIterations) {
            throw new IllegalStateException("Order failed with status " + this.getAccountStatus());
        }
    }

    public String getAccountStatus() throws Exception {

        String orderStatus = tool.getTextUsingXPath("//div[@id='navigationContext']/div/div/div[2]");
        return orderStatus;
    }

    public String getSubscriberStatus() throws Exception {

        String orderStatus = tool.getTextUsingXPath("//div[@id='navigationContext']/div/div/div[3]");
        return orderStatus;
    }

    public AddDepositCommon clickAddDeposit() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, AddDepositCommon.expectedScreen, "firstYouCanaddDepositMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AddDepositCommon(tool, test, user);
    }

    public AccountDepositsCommon clickViewDeposits() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, AccountDepositsCommon.expectedScreen, "firstYouCanviewDepositsMenu");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new AccountDepositsCommon(tool, test, user);
    }

    public PersonDetailsCommon clickUpdatePerson() throws Exception {
        tool.clickUsingID("add_update_person");
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PersonDetailsCommon(tool, test, user);
    }

    public void clickSelectOtherPerson() throws Exception {
        tool.clickUsingXPath("//div[@id='personaSelectContainer']/img");
    }

    public AddStandaloneChargeCommon clickAddStandaloneCharge() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, AddStandaloneChargeCommon.expectedScreen, "firstYouCanaddStandaloneChargeMenu");

        return new AddStandaloneChargeCommon(tool, test, user);
    }

    public void clickNavigate() throws Exception {
        tool.clickUsingLinkText("Navigate");
    }

    public AccountDetails removeAccountOfferIfPresent(String accountOfferName) throws Exception {
        if (!tool.searchListUsingLinkTextIsEmpty(accountOfferName)) {
            System.out.println("Account offer found so need to remove it...");

            AccountDetails accountDetails = new AccountDetails(tool, test, user);

            RemoveOffer removeOffer = accountDetails.clickRemoveAccountOffer(accountOfferName);
            OfferCancellation offerCancellation = removeOffer.clickYes();
            offerCancellation.clickOk();

            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();
            requestsForCustomer.clickAccounts();

        } else {

            System.out.println("Account offer not present so good to go");
        }
        return new AccountDetails(tool, test, user);
    }

}

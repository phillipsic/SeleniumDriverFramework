/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

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

        String currentScreen = tool.driver.getTitle();

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddNewCaseCommon addNewCase() throws Exception {
        tool.driver.findElement(By.linkText("Add")).click();

        return new AddNewCaseCommon(tool, test, user);
    }

    public AddNewCaseCommon clickLinkOfFirstCase() throws Exception {
        tool.driver.findElement(By.id("value_case_0_0")).click();

        return new AddNewCaseCommon(tool, test, user);
    }

    public void clickHomeMenu() throws Exception {
        tool.driver.findElement(By.linkText("Home")).click();
    }

    public SelectOffersForYourAccountCommon clickAddNewAccountOffer() throws Exception {
        tool.driver.findElement(By.xpath("//p[contains(text(),'Bundle/Offers')]/../../div/a[contains(text(),'Add')]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickReconfigure() throws Exception {
        tool.driver.findElement(By.linkText("Reconfigure")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public ViewCaseCommon clickLinkOfCaseID(String caseID) throws Exception {
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.xpath("//span[text()=" + caseID + "]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewCaseCommon(tool, test, user);
    }

    public SubscriberDetailsCommon selectFirstSubscriberFromNavigationPanel() throws Exception {
        System.out.println("selectFirstSubscriberFromNavigationPanel");
        tool.driver.findElement(By.id("NavigationLink")).click();
        Common.sleepForNumberOfSeconds(1);
        // tool.driver.findElement(By.xpath("(//a[contains(text(),'open')])[2]")).click();
        tool.driver.findElement(By.xpath("(//td[4]//a[contains(text(), 'open')])[1]")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon clickSubscriberIDFromNavigationPanel() throws Exception {
        tool.driver.findElement(By.id("SubscriberSearchLink")).click();
        Common.sleepForNumberOfSeconds(1);
        Common.assertTextOnPage(tool, "Please enter your criteria and press search");
        tool.driver.findElement(By.id("subscriberSearchButton")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        tool.driver.findElement(By.xpath("//td[3]/div/a")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(tool, test, user);
    }

    public SubscriberDetailsCommon selectSubscriberByMSISDN(String MSISDN) throws Exception {
        tool.driver.findElement(By.id("SubscriberSearchLink")).click();
        tool.driver.findElement(By.id("subscriberSearchButton")).click();
        Common.sleepForNumberOfSeconds(2);
        tool.driver.findElement(By.linkText(MSISDN)).click();
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
        tool.driver.navigate().refresh();
        Common.sleepForNumberOfSeconds(1);
        tool.driver.findElement(By.cssSelector("#firstYouCan > input.submit")).click();
        Common.sleepForNumberOfSeconds(1);
        tool.driver.findElement(By.linkText("Search Orders")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SearchOrdersCommon(tool, test, user);
    }

    @Override
    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        tool.driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(tool, test, user);
    }

    @Override
    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        tool.driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(tool, test, user);
    }

    public ModifyContactInformationCommon clickModifyBillingContact() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='tab1']/table/tbody/tr/td[2]/div[5]/a/u")).click();
        return new ModifyContactInformationCommon(tool, test, user);
    }

    public ModifyPaymentInformationCommon clickModifyPaymentMethod() throws Exception {
        tool.driver.findElement(By.xpath("//div[8]/a/u")).click();
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
        tool.driver.findElement(By.linkText(offerName)).click();
    }

    public void clickCloseOfferDetailsBox() throws Exception {
        tool.driver.findElement(By.xpath("//input[@value='Close']")).click();
    }

    public void clickAccountAttributesTab() throws Exception {
        tool.driver.findElement(By.xpath("//a[@href='#tab2']")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
    }

    public SwapBundleCommon clickUpgrade() throws Exception {
        tool.driver.findElement(By.linkText("Upgrade")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SwapBundleCommon(tool, test, user);
    }

    public ModifyAccountAttributesCommon clickModifyAccountContact() throws Exception {
        tool.driver.findElement(By.xpath("//div[2]/a/u")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new ModifyAccountAttributesCommon(tool, test, user);
    }

    public RemoveOfferCommon clickRemoveFirstAccountOffer() throws Exception {
        tool.driver.findElement(By.linkText("Remove")).click();
        return new RemoveOfferCommon(tool, test, user);
    }

    public RemoveOfferCommon clickRemoveAccountOffer(String newOfferName) throws Exception {
        tool.driver.findElement(By.xpath("//tr[td/a[contains(text(),'" + newOfferName + "')]]/td/a[contains(text(), 'Remove')]")).click();
        return new RemoveOfferCommon(tool, test, user);
    }

    public SelectOffersForYourAccountCommon clickReconfigureAccountOffer() throws Exception {
        tool.driver.findElement(By.linkText("Reconfigure")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new SelectOffersForYourAccountCommon(tool, test, user);
    }

    public DeliveryAddressesCommon clickDeliveryAddresses() throws Exception {
        tool.driver.findElement(By.id("mnu_DELIVERY_ADDRESSES")).click();
        return new DeliveryAddressesCommon(tool, test, user);
    }

    public String getAccountNumber() throws Exception {
        String temp1[];
        String temp = tool.driver.findElement(By.cssSelector("div.navContextMain")).getText();
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
        tool.driver.findElement(By.xpath("//p[contains(text(),'Cases (last 4 by date)')]/../../div/a[contains(text(),'More...')]")).click();
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

    public void waitUntilStatusChanged(String status) throws Exception {

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

    public String getAccountStatus() throws Exception {

        String orderStatus = tool.driver.findElement(By.xpath("//div[@id='navigationContext']/div/div/div[2]")).getText();
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
        tool.driver.findElement(By.id("add_update_person")).click();
        Common.waitForEndOfWaitingPage(tool, this.getClass().getSimpleName());
        return new PersonDetailsCommon(tool, test, user);
    }

    public void clickSelectOtherPerson() throws Exception {
        tool.driver.findElement(By.xpath("//div[@id='personaSelectContainer']/img")).click();
    }

    public AddStandaloneChargeCommon clickAddStandaloneCharge() throws Exception {
        Common.clickAction1ItemIsAccessible(tool, AddStandaloneChargeCommon.expectedScreen, "firstYouCanaddStandaloneChargeMenu");

        return new AddStandaloneChargeCommon(tool, test, user);
    }

    public void clickNavigate() throws Exception {
        tool.driver.findElement(By.linkText("Navigate")).click();
    }

    public AccountDetails removeAccountOfferIfPresent(String accountOfferName) throws Exception {

        if (!driver.findElements(By.linkText(accountOfferName)).isEmpty()) {
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

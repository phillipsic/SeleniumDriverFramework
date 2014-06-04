/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.comverse.css.common.Common;

public class AccountDetailsCommon extends CommonMenu {

    static String expectedScreen = "Account Details";

    public AccountDetailsCommon(WebDriver driver) throws Exception {
        super(driver);

        String currentScreen = driver.getTitle();

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddNewCaseCommon addNewCase() throws Exception {
        driver.findElement(By.linkText("Add")).click();

        return new AddNewCaseCommon(driver);
    }

    public AddNewCaseCommon clickLinkOfFirstCase() throws Exception {
        driver.findElement(By.id("value_case_0_0")).click();

        return new AddNewCaseCommon(driver);
    }

    public void clickHomeMenu() throws Exception {
        driver.findElement(By.linkText("Home")).click();
    }

    public SelectOffersForYourAccountCommon clickAddNewAccountOffer() throws Exception {
        driver.findElement(By.xpath("//p[contains(text(),'Bundle/Offers')]/../../div/a[contains(text(),'Add')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(driver);
    }

    public SelectOffersForYourAccountCommon clickReconfigure() throws Exception {
        driver.findElement(By.linkText("Reconfigure")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());

        return new SelectOffersForYourAccountCommon(driver);
    }

    public ViewCaseCommon clickLinkOfCaseID(String caseID) throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//span[text()=" + caseID + "]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewCaseCommon(driver);
    }

    public SubscriberDetailsCommon selectFirstSubscriberFromNavigationPanel() throws Exception {
        System.out.println("selectFirstSubscriberFromNavigationPanel");
        driver.findElement(By.id("NavigationLink")).click();
        Common.sleepForNumberOfSeconds(1);
        // driver.findElement(By.xpath("(//a[contains(text(),'open')])[2]")).click();
        driver.findElement(By.xpath("(//td[4]//a[contains(text(), 'open')])[1]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }

    public SubscriberDetailsCommon clickSubscriberIDFromNavigationPanel() throws Exception {
        driver.findElement(By.id("SubscriberSearchLink")).click();
        Common.sleepForNumberOfSeconds(1);
        Common.assertTextOnPage(driver, "Please enter your criteria and press search");
        driver.findElement(By.id("subscriberSearchButton")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//td[3]/div/a")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SubscriberDetailsCommon(driver);
    }

    public SubscriberDetailsCommon selectSubscriberByMSISDN(String MSISDN) throws Exception {
        driver.findElement(By.id("SubscriberSearchLink")).click();
        driver.findElement(By.id("subscriberSearchButton")).click();
        Common.sleepForNumberOfSeconds(2);
        driver.findElement(By.linkText(MSISDN)).click();
        return new SubscriberDetailsCommon(driver);
    }

    public SendCommunicationCommon clickSendOutBoundCommunication() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, SendCommunicationCommon.expectedScreen, "firstYouCansendOutboundCommunicationMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SendCommunicationCommon(driver);
    }

    public ViewBalanceCommon clickViewBalancesAndRecharge() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, ViewBalanceCommon.expectedScreen, "firstYouCanviewBalancesMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewBalanceCommon(driver);
    }

    public RegisterPrepaymentCommon clickRegisterPrepayment() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, RegisterPrepaymentCommon.expectedScreen, "firstYouCanregisterPrepaymentMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RegisterPrepaymentCommon(driver);
    }

    public SearchOrdersCommon clickSearchOrders() throws Exception {
        driver.navigate().refresh();
        Common.sleepForNumberOfSeconds(1);
        driver.findElement(By.cssSelector("#firstYouCan > input.submit")).click();
        Common.sleepForNumberOfSeconds(1);
        driver.findElement(By.linkText("Search Orders")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SearchOrdersCommon(driver);
    }

    @Override
    public ViewInvoicesCommon clickBillsAndPayments() throws Exception {
        driver.findElement(By.id("mnu_BILLS_PAYMENTS")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewInvoicesCommon(driver);
    }

    @Override
    public ViewTransactionHistoryCommon clickHistories() throws Exception {
        driver.findElement(By.id("mnu_HISTORIES")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ViewTransactionHistoryCommon(driver);
    }

    public ModifyContactInformationCommon clickModifyBillingContact() throws Exception {
        driver.findElement(By.xpath("//div[@id='tab1']/table/tbody/tr/td[2]/div[5]/a/u")).click();
        return new ModifyContactInformationCommon(driver);
    }

    public ModifyPaymentInformationCommon clickModifyPaymentMethod() throws Exception {
        driver.findElement(By.xpath("//div[8]/a/u")).click();
        return new ModifyPaymentInformationCommon(driver);
    }

    public RequestsForCustomerCommon clickViewRequestsForThisCustomer() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, RequestsForCustomerCommon.expectedScreen, "firstYouCanviewCustomerRequestsMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new RequestsForCustomerCommon(driver);
    }

    public void clickRefreshThisAccount() throws Exception {

        Common.clickAction1ItemIsAccessible(driver, AccountDetailsCommon.expectedScreen, "firstYouCanrefreshAccountLink");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.sleepForNumberOfSeconds(5);

    }

    public void clickLinkOfOfferName(String offerName) throws Exception {
        driver.findElement(By.linkText(offerName)).click();
    }

    public void clickCloseOfferDetailsBox() throws Exception {
        driver.findElement(By.xpath("//input[@value='Close']")).click();
    }

    public void clickAccountAttributesTab() throws Exception {
        driver.findElement(By.xpath("//a[@href='#tab2']")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
    }

    public SwapBundleCommon clickUpgrade() throws Exception {
        driver.findElement(By.linkText("Upgrade")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SwapBundleCommon(driver);
    }

    public ModifyAccountAttributesCommon clickModifyAccountContact() throws Exception {
        driver.findElement(By.xpath("//div[2]/a/u")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ModifyAccountAttributesCommon(driver);
    }

    public RemoveOfferCommon clickRemoveFirstAccountOffer() throws Exception {
        driver.findElement(By.linkText("Remove")).click();
        return new RemoveOfferCommon(driver);
    }

    public RemoveOfferCommon clickRemoveAccountOffer(String newOfferName) throws Exception {
        driver.findElement(By.xpath("//tr[td/a[contains(text(),'" + newOfferName + "')]]/td/a[contains(text(), 'Remove')]")).click();
        return new RemoveOfferCommon(driver);
    }

    public SelectOffersForYourAccountCommon clickReconfigureAccountOffer() throws Exception {
        driver.findElement(By.linkText("Reconfigure")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new SelectOffersForYourAccountCommon(driver);
    }

    public DeliveryAddressesCommon clickDeliveryAddresses() throws Exception {
        driver.findElement(By.id("mnu_DELIVERY_ADDRESSES")).click();
        return new DeliveryAddressesCommon(driver);
    }

    public String getAccountNumber() throws Exception {
        String temp1[];
        String temp = driver.findElement(By.cssSelector("div.navContextMain")).getText();
        temp1 = temp.split("-");
        return Common.cleanStringOfIllegalChars(temp1[0]);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickNewConvergentSubscriberOnExistingAccount() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, CustomerAcquisitionCustomerDataReviewCommon.expectedScreen, "firstYouCanconvergentSubscriberMenu",
                "firstYouCanconvergentExistingAccountMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(driver);
    }

    public CustomerAcquisitionCustomerDataReviewCommon clickNewConvergentSubscriberOnNewAccount() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, CustomerAcquisitionCustomerDataReviewCommon.expectedScreen, "firstYouCanconvergentSubscriberMenu",
                "firstYouCanconvergentNewAccountMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new CustomerAcquisitionCustomerDataReviewCommon(driver);
    }

    public ShoppingCommon clickShopForDevicesAndAccessories() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, ShoppingCommon.expectedScreen, "firstYouCanShopDevicesMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new ShoppingCommon(driver);

    }

    public void clickListAllCases() throws Exception {
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        driver.findElement(By.xpath("//p[contains(text(),'Cases (last 4 by date)')]/../../div/a[contains(text(),'More...')]")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
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
        Common.clickAction1ItemIsAccessible(driver, DisconnectAccountCommon.expectedScreen, "firstYouCandisconnectAccountMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new DisconnectAccountCommon(driver);
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

        String orderStatus = driver.findElement(By.xpath("//div[@id='navigationContext']/div/div/div[2]")).getText();
        return orderStatus;
    }

    public AddDepositCommon clickAddDeposit() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, AddDepositCommon.expectedScreen, "firstYouCanaddDepositMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AddDepositCommon(driver);
    }

    public AccountDepositsCommon clickViewDeposits() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, AccountDepositsCommon.expectedScreen, "firstYouCanviewDepositsMenu");
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new AccountDepositsCommon(driver);
    }

    public PersonDetailsCommon clickUpdatePerson() throws Exception {
        driver.findElement(By.id("add_update_person")).click();
        Common.waitForEndOfWaitingPage(driver, this.getClass().getSimpleName());
        return new PersonDetailsCommon(driver);
    }

    public void clickSelectOtherPerson() throws Exception {
        driver.findElement(By.xpath("//div[@id='personaSelectContainer']/img")).click();
    }

    public AddStandaloneChargeCommon clickAddStandaloneCharge() throws Exception {
        Common.clickAction1ItemIsAccessible(driver, AddStandaloneChargeCommon.expectedScreen, "firstYouCanaddStandaloneChargeMenu");

        return new AddStandaloneChargeCommon(driver);
    }

    public void clickNavigate() throws Exception {
        driver.findElement(By.linkText("Navigate")).click();
    }

    public AccountDetailsCommon removeAccountOfferIfPresent(String accountOfferName) throws Exception {

        if (!driver.findElements(By.linkText(accountOfferName)).isEmpty()) {
            System.out.println("Account offer found so need to remove it...");

            AccountDetailsCommon accountDetails = new AccountDetailsCommon(driver);

            RemoveOfferCommon removeOffer = accountDetails.clickRemoveAccountOffer(accountOfferName);
            OfferCancellationCommon offerCancellation = removeOffer.clickYes();
            offerCancellation.clickOk();

            RequestsForCustomerCommon requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            requestsForCustomer.clickAccounts();

        } else {

            System.out.println("Account offer not present so good to go");
        }
        return new AccountDetailsCommon(driver);
    }

}

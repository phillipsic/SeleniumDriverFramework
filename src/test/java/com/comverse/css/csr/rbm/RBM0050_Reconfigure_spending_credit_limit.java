package com.comverse.css.csr.rbm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class RBM0050_Reconfigure_spending_credit_limit extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testRBM0050_Reconfigure_spending_credit_limit() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            String balanceInternRoamingName = po_ResidentialUltraPostpaid.getBAL_InternationalRoaming().getBalanceName();
            String balanceCoreBalanceName = po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();

            tool.driver.findElement(By.xpath("//input[@type='checkbox' and contains(@onclick, 'CORE BALANCE_limit')]")).click();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_CORE_BALANCE()
                    .getBalanceValue());
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());

            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();

            myBasket.assign3InventoriesFirstOffer(subscriber);
            String subscriberMSISDN = subscriber.getSubscriberMSISDNProperty();
            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getNCAOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();

            SearchRequests searchRequests = workSpace.clickRequests();

            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());

            workSpace = searchOrders.clickHomeMenu();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            SubscriberDetails subscriberDetails = manageAccount.searchBySubscriberMSISDN(subscriberMSISDN);

            ViewBalance viewBalance = subscriberDetails.viewBalanceAndRecharge();

            // Reconfigure CORE BALANCE limit
            ReconfigureBalance reconfigureBalance = viewBalance.clickConfigureLimit(balanceCoreBalanceName);

            Common.assertTextOnPage(tool, balanceCoreBalanceName);
            Common.assertTextOnPage(tool, "Reconfigure balance");
            reconfigureBalance.setCreditSpendingLimitUnlimited();
            ReconfigureBalanceReview reconfigureBalanceReview = reconfigureBalance.clickReconfigureBalance();

            Common.assertTextOnPage(tool, "Set Unlimited");
            Common.assertTextOnPage(tool, "Yes");
            ReconfigureBalanceConfirm reconfigureBalanceConfirm = reconfigureBalanceReview.clickConfirm();

            Common.assertTextOnPage(tool, "Your request to configure balance has been processed successfully");
            viewBalance = reconfigureBalanceConfirm.clickBack();

            BalanceDetails balanceDetails = viewBalance.viewBalanceDetails(balanceCoreBalanceName);
            Common.assertTextOnPage(tool, balanceCoreBalanceName);
            Common.assertTextOnPage(tool, "Unlimited");
            viewBalance = balanceDetails.clickGoToListOfBalances();

            // Authorize more units for this period for International Roaming
            reconfigureBalance = viewBalance.clickConfigureLimit(balanceInternRoamingName);

            Common.assertTextOnPage(tool, "Authorize more units for this period");
            String unitsToAdd = "15";
            reconfigureBalance.setMoreUnitsForThisPeriod(unitsToAdd);
            reconfigureBalanceReview = reconfigureBalance.clickAddUnits();

            Common.assertTextOnPage(tool, "Units to add for this period");
            Common.assertTextOnPage(tool, "$ " + unitsToAdd + ".00");
            reconfigureBalanceConfirm = reconfigureBalanceReview.clickConfirm();

            Common.assertTextOnPage(tool, "Your request to configure balance has been processed successfully");
            viewBalance = reconfigureBalanceConfirm.clickBack();

            balanceDetails = viewBalance.viewBalanceDetails(balanceInternRoamingName);
            Common.assertTextOnPage(tool, balanceInternRoamingName);
            Common.assertTextOnPage(tool, "Remaining units");
            Common.assertTextOnPage(tool, "$ " + unitsToAdd + ".00");

            Common.storeLastNameAndAccountNumberPostpaidAccount(enterIdentificationData.getAccount().getBillingLastNameProperty(), enterIdentificationData.getAccount()
                    .getBillingAccountIDProperty(), "Created by " + this.getClass().getSimpleName());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}

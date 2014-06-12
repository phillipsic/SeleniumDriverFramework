package com.comverse.css.csr.adb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.AO.AO_ResidentialFamilyAccountOfferCommit1Year;
import com.comverse.css.data.BAL.BAL_NightAndWeekendMinutes;
import com.comverse.css.data.SB.SB_ResidentialBasicPrepaidBundle;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class ADB0010_Adjust_balance extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testADB0010_Adjust_balance() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            SB_ResidentialBasicPrepaidBundle sb_ResidentialBasicPrepaidBundle = new SB_ResidentialBasicPrepaidBundle();
            AO_ResidentialFamilyAccountOfferCommit1Year ao_ResidentialFamilyAccountOfferCommit1Year = new AO_ResidentialFamilyAccountOfferCommit1Year();
            BAL_NightAndWeekendMinutes bal_NightAndWeekendMinutes = new BAL_NightAndWeekendMinutes();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.filterSubscriberBundlePrimaryOfferByName(sb_ResidentialBasicPrepaidBundle.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(sb_ResidentialBasicPrepaidBundle.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();

            Common.assertTextOnPage(tool, sb_ResidentialBasicPrepaidBundle.getOfferName());

            myBasket.assign3InventoriesFirstOffer(subscriber);
            SelectOffersForYourAccount selectOffersForYourAccount = myBasket.clickAddAO();

            selectOffersForYourAccount.selectAccountOfferByName(ao_ResidentialFamilyAccountOfferCommit1Year.getOfferName());
            myBasket = selectOffersForYourAccount.clickContinueNoConfiguration();
            Common.assertTextOnPage(tool, ao_ResidentialFamilyAccountOfferCommit1Year.getOfferName());

            CheckoutReview checkoutReview = myBasket.clickCheckOut();

            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailedWithGetAccountID(orderNumber, enterIdentificationData.getAccount());

            workSpace = searchOrders.clickHomeMenu();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.searchByAccountLastNameSinglePerson(enterIdentificationData.getAccount().getBillingLastNameProperty());

            Common.assertTextOnPage(tool, ao_ResidentialFamilyAccountOfferCommit1Year.getOfferName());

            ViewBalance viewBalance = accountDetails.clickViewBalancesAndRecharge();
            Common.assertTextOnPage(tool, bal_NightAndWeekendMinutes.getBalanceName());

            AdjustBalanceDetails adjustBalancedetails = viewBalance.clickAdjustBalance(bal_NightAndWeekendMinutes.getBalanceName());

            Common.assertTextOnPage(tool, "Balance Details");
            Common.assertTextOnPage(tool, "Adjustment description");
            Common.assertTextOnPage(tool, bal_NightAndWeekendMinutes.getBalanceName());

            adjustBalancedetails.enterAdjustmentAmount(bal_NightAndWeekendMinutes.getBalanceValue());
            AdjustBalanceReview adjustBalanceReview = adjustBalancedetails.clickContinue();

            Common.assertTextOnPage(tool, "Balance Details");
            Common.assertTextOnPage(tool, "00:00:" + bal_NightAndWeekendMinutes.getBalanceValue());
            Common.assertTextOnPage(tool, bal_NightAndWeekendMinutes.getBalanceName());

            AdjustBalanceRequestResult adjustBalanceRequestResult = adjustBalanceReview.clickConfirm();

            Common.assertTextOnPage(tool, "Balance Details");
            Common.assertTextOnPage(tool, "00:00:" + bal_NightAndWeekendMinutes.getBalanceValue());
            Common.assertTextOnPage(tool, bal_NightAndWeekendMinutes.getBalanceName());
            Common.assertTextOnPage(tool, "Your request to add the above adjustment has been processed successfully");

            viewBalance = adjustBalanceRequestResult.clickBack();

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

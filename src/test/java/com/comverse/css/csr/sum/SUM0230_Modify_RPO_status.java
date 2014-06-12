package com.comverse.css.csr.sum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.SO.RPO_DIYRechargePromotionalOffer3;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0230_Modify_RPO_status extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testSUM0230_Modify_RPO_status() throws Exception {
        try {
            // RPO_DIYRechargePromotionalOffer2 rpo_DIYRechargePromotionalOffer2
            // = new RPO_DIYRechargePromotionalOffer2();
            RPO_DIYRechargePromotionalOffer3 rpo_DIYRechargePromotionalOffer3 = new RPO_DIYRechargePromotionalOffer3();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCADIYRechargesPromotionsCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            // subscriberDashboard.doAddRPO(rpo_DIYRechargePromotionalOffer2.getOfferName());
            // Common.assertTextOnPage(tool,
            // rpo_DIYRechargePromotionalOffer2.getOfferName());
            subscriberDashboard.doAddRPO(rpo_DIYRechargePromotionalOffer3.getOfferName());
            Common.assertTextOnPage(tool, rpo_DIYRechargePromotionalOffer3.getOfferName());
            Common.assertTextOnPage(tool, "Pre-active");

            ViewBalance viewBalance = subscriberDashboard.viewBalanceAndRecharge();

            Double coreBalanceBeforeRecharge = viewBalance.getCoreBalance();

            NonVoucherRecharge nonVoucherRecharge = viewBalance.clickNonVoucherRechargeFreeAmount();
            String rechargeAmount = "1";
            nonVoucherRecharge.enterRechargeAmount(rechargeAmount);
            nonVoucherRecharge.selectPaymentMethodCreditCard();
            nonVoucherRecharge.clickContinue();
            Common.assertTextOnPage(tool, "Please enter your credit card details to process the payment and confirm this recharge.");

            nonVoucherRecharge.enterCardNumber("4111111111111111");
            nonVoucherRecharge.enterCardExpDate("12/2014");
            nonVoucherRecharge.enterCardHolderLastName("LN");
            nonVoucherRecharge.enterCardHolderFirstName("FN");
            nonVoucherRecharge.enterCardSecretCode("123");
            nonVoucherRecharge.enterEmail("abc@comverse.com");
            NonVoucherRechargeReview nonVoucherRechargeReview = nonVoucherRecharge.clickSelect();

            Common.assertTextOnPage(tool, "Please review your credit card details to process the payment and confirm this recharge.");
            Common.assertTextOnPage(tool, "4111111111111111");
            RechargeSubscriber rechargeSubscriber = nonVoucherRechargeReview.confirmNonVoucherRechargeByCreditCard();

            Common.assertTextOnPage(tool, "Credit Card");

            viewBalance = rechargeSubscriber.clickViewBalances();

            Double expectedCoreBalanceAfterRecharge = coreBalanceBeforeRecharge + Double.parseDouble(rechargeAmount);

            Double coreBalanceAfterRecharge = viewBalance.getCoreBalance();
            assertEquals(expectedCoreBalanceAfterRecharge, coreBalanceAfterRecharge);
            subscriberDashboard = viewBalance.clickBackToSubscriberDashboard();
            subscriberDashboard.clickRefreshUntilRPOActive(rpo_DIYRechargePromotionalOffer3.getOfferName());
            Common.assertTextOnPage(tool, "Active");
            subscriberDashboard.clickRPOStatus();
            subscriberDashboard.clickConfirmStatusExpire();
            assertFalse(subscriberDashboard.returnRPOStatus().equals(rpo_DIYRechargePromotionalOffer3.getOfferName()));
            // Common.assertTextNotOnPage(tool,
            // rpo_DIYRechargePromotionalOffer3.getOfferName());
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

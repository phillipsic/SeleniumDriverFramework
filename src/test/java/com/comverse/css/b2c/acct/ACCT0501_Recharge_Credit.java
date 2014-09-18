package com.comverse.css.b2c.acct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ACCT0501_Recharge_Credit extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testACCT0501_Recharge_Credit() throws Exception {
        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();
            String amountToRecharge = "1";

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(tool, "Welcome");

            ViewBalances viewBalances = subscriberDetail.clickBalances();

            double coreBalanceValue = viewBalances.getBalanceValue("CORE BALANCE");

            SelectModeOfRecharge selectModeOfRecharge = subscriberDetail.clickRecharge();

            selectModeOfRecharge.selectFreeAmount();
            RechargeWithFreeAmount rechargeWithFreeAmount = selectModeOfRecharge.clickSubmit();

            rechargeWithFreeAmount.enterRechargeAmount(amountToRecharge);

            SelectRechargePaymentMethod selectRechargePaymentMethod = rechargeWithFreeAmount.clickContinue();

            selectRechargePaymentMethod.enterCardNumber("4111111111111111");
            selectRechargePaymentMethod.enterCardExpDate("09/2014");
            selectRechargePaymentMethod.enterCardHolderFirstName("FN");
            selectRechargePaymentMethod.enterCardHolderLastName("LN");
            selectRechargePaymentMethod.enterCardSecretCode("123");

            RechargeDone rechargeDone = selectRechargePaymentMethod.clickSelect();
            Common.assertTextOnPage(tool, "Available balances known at the date of:");

            subscriberDetail = rechargeDone.clickDashbaord();
            viewBalances = subscriberDetail.clickBalances();
            viewBalances.clickRefreshButton();

            double coreBalanceValueAfterRecharge = viewBalances.getBalanceValue("CORE BALANCE");

            Common.assertTextEquals(Double.toString(coreBalanceValueAfterRecharge), Double.toString(coreBalanceValue + Double.parseDouble(amountToRecharge)));

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

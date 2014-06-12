package com.comverse.css.b2c.orma;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.HomePage;
import com.comverse.css.b2c.SearchOrders;
import com.comverse.css.b2c.SubscriberDetail;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class ORMA0031_View_order_details extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORMA0031_View_order_details() throws Exception {

        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();

            SearchOrders searchOrders = subscriberDetail.clickMyOrders();

            String firstOrderStatus = searchOrders.getOrderStatus();
            String firstOrderNumber = searchOrders.getOrderNumber();
            searchOrders.getOrderDate();

            searchOrders.clickOrderNumber(firstOrderNumber);

            Common.assertTextOnPage(tool, "Order Status:" + firstOrderStatus);
            Common.assertTextOnPage(tool, "Order Number:" + firstOrderNumber);

            Common.assertTextOnPage(tool, "Residential - Basic Prepaid");
            Common.assertTextOnPage(tool, "Voice Prepaid MSISDN");
            Common.assertTextOnPage(tool, "3G IMSI");
            Common.assertTextOnPage(tool, "3G SIM");

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

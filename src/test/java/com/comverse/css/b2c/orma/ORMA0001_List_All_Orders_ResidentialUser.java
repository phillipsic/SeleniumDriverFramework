package com.comverse.css.b2c.orma;

import static org.junit.Assert.assertEquals;

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

public class ORMA0001_List_All_Orders_ResidentialUser extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testORMA0001_List_All_Orders_ResidentialUser() throws Exception {

        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(driver);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();

            SearchOrders searchOrders = subscriberDetail.clickMyOrders();

            String firstOrderStatus = searchOrders.getOrderStatus();
            String firstOrderNumber = searchOrders.getOrderNumber();
            String firstOrderDate = searchOrders.getOrderDate();

            searchOrders.setOrderNumber("none");
            searchOrders.clickSearch();
            Common.assertTextOnPage(driver, "No matching order found");

            searchOrders.setOrderNumber(firstOrderNumber);
            searchOrders.clickSearch();
            assertEquals(firstOrderNumber, searchOrders.getOrderNumber());

            searchOrders.setOrderStatus("Dispatched");
            searchOrders.clickSearch();
            Common.assertTextOnPage(driver, "No matching order found");

            searchOrders.setOrderStatus(firstOrderStatus);
            searchOrders.clickSearch();
            assertEquals(firstOrderStatus, searchOrders.getOrderStatus());

            searchOrders.setToDate("01/01/2014");
            searchOrders.setFromDate("01/01/2013");
            searchOrders.clickSearch();
            Common.assertTextOnPage(driver, "No matching order found");

            searchOrders.setToDate(firstOrderDate);
            searchOrders.clickSearch();
            assertEquals(firstOrderDate, searchOrders.getOrderDate());

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

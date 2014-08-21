package com.comverse.css.b2b.cim;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class CIM0030_Search_List_delivery_addresses extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testCIM0030_Search_List_delivery_addresses() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);
            AccountDetails accountDetails = workSpace.clickAccount();

            DeliveryAddresses deliveryAddresses = accountDetails.clickDeliveryAddresses();

            AddDeliveryAddress addDeliveryAddress = deliveryAddresses.clickAdd();
            addDeliveryAddress.enterDefaultDeliveryAddress(uniqueTimeStamp);
            deliveryAddresses = addDeliveryAddress.clickOk();

            deliveryAddresses = deliveryAddresses.searchWithWildCard(uniqueTimeStamp);

            Common.assertTextOnPage(tool, "Delivery Address for search " + uniqueTimeStamp + " from 1 to 1 (of 1)");

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

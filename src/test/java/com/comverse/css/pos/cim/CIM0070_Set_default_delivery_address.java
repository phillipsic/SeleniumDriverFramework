package com.comverse.css.pos.cim;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class CIM0070_Set_default_delivery_address extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testCIM0070_Set_default_delivery_address() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            String accountLastname = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            DeliveryAddresses deliveryAddresses = accountDetails.clickDeliveryAddresses();
            AddDeliveryAddress addDeliveryAddress = deliveryAddresses.clickAdd();
            addDeliveryAddress.enterDefaultDeliveryAddress(uniqueTimeStamp);
            deliveryAddresses = addDeliveryAddress.clickOk();
            Common.assertTextOnPage(tool, "The Add Delivery Address has been submitted successfully");
            deliveryAddresses = deliveryAddresses.searchWithWildCard(uniqueTimeStamp);

            Common.assertTextOnPage(tool, "Delivery Address for search " + uniqueTimeStamp + " from 1 to 1 (of 1)");

            deliveryAddresses.clickMakeDefault();
            deliveryAddresses.searchWithWildCard(uniqueTimeStamp);

            Common.assertTextNotOnPage(tool, "make default");

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
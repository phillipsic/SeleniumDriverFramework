package com.comverse.css.csr.cim;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class CIM0060_remove_delivery_address extends CSSTest {
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
    public void testCIM0060_remove_delivery_address() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            String uniqueTimeStamp = Common.generateTimeStamp();
            String accountLastname = Common.getLastNameOfPostPaidAccount();
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);

            DeliveryAddresses deliveryAddresses = accountDetails.clickDeliveryAddresses();
            AddDeliveryAddress addDeliveryAddress = deliveryAddresses.clickAdd();
            addDeliveryAddress.enterDefaultDeliveryAddress(uniqueTimeStamp);
            deliveryAddresses = addDeliveryAddress.clickOk();
            Common.assertTextOnPage(tool, "The Add Delivery Address has been submitted successfully");
            Common.assertTextOnPage(tool, "Delivery Addresses");

            deliveryAddresses = deliveryAddresses.searchWithWildCard(uniqueTimeStamp);

            RemoveDeliveryAddress removeDeliveryAddress = deliveryAddresses.clickRemove();
            Common.assertTextOnPage(tool, "Are you sure you want to remove this delivery address?");

            deliveryAddresses = removeDeliveryAddress.clickOk();

            Common.assertTextOnPage(tool, "The Remove Delivery Address has been submitted successfully.");

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

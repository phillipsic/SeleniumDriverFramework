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

public class CIM0050_edit_delivery_address extends CSSTest {
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
    public void testCIM0050_edit_delivery_address() throws Exception {
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
            Common.assertTextOnPage(tool, "The Add Delivery Address has been submitted successfully");
            Common.assertTextOnPage(tool, "Delivery Addresses");
            ModifyDeliveryAddress modifyDeliveryAddress = deliveryAddresses.clickModify();

            String modifiedAddress = Common.generateTimeStamp();
            modifyDeliveryAddress.selectCountry("United States");
            modifyDeliveryAddress.selectState("Hawaii");
            modifyDeliveryAddress.setAddressLine1("AD1" + modifiedAddress);
            modifyDeliveryAddress.setAddressLine2("AD2" + modifiedAddress);
            modifyDeliveryAddress.setAddressLine3("AD3" + modifiedAddress);
            modifyDeliveryAddress.setAddressLine4("AD4" + modifiedAddress);
            modifyDeliveryAddress.setZipCode("92000");
            modifyDeliveryAddress.setCity("Nanterre");

            ModifyDeliveryAddressConfirmation modifyDeliveryAddressConfirmation = modifyDeliveryAddress.clickOk();

            Common.assertTextOnPage(tool, "United States");
            Common.assertTextOnPage(tool, "Hawaii");
            Common.assertTextOnPage(tool, "AD1" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD2" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD3" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD4" + modifiedAddress);
            Common.assertTextOnPage(tool, "Nanterre");
            Common.assertTextOnPage(tool, "92000");

            deliveryAddresses = modifyDeliveryAddressConfirmation.clickOk();

            Common.assertTextOnPage(tool, "The Modify Delivery Address has been submitted successfully.");
            Common.assertTextOnPage(tool, "United States");
            Common.assertTextOnPage(tool, "Hawaii");
            Common.assertTextOnPage(tool, "AD1" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD2" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD3" + modifiedAddress);
            Common.assertTextOnPage(tool, "AD4" + modifiedAddress);
            Common.assertTextOnPage(tool, "Nanterre");
            Common.assertTextOnPage(tool, "92000");
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

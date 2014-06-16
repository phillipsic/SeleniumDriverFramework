package com.comverse.css.pos.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.EnterIdentificationData;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class NCA0020_Capture_administrative_data extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testNCA0020_Capture_administrative_data() throws Exception {
        try {
            launchCSSApplication();
            String uniqueString = Common.generateTimeStamp();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");

            Common.assertTextOnPage(tool, "Customer Address details");
            enterIdentificationData.setGender("Male");
            enterIdentificationData.setCustomerTitle("Mr.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueString);
            enterIdentificationData.setCustomerLastName("LN" + uniqueString);
            enterIdentificationData.enterCustomerHomeCountry("United States");
            enterIdentificationData.enterCustomerHomeState("Tennessee");
            enterIdentificationData.setCustomerStreetNumber("55");
            enterIdentificationData.setCustomerStreetName("Homestreet");
            enterIdentificationData.enterCustomerCity("Nashville");
            enterIdentificationData.enterCustomerPostCode("11155");

            Common.assertTextOnPage(tool, "Billing Address details");
            common.Assert.verify(tool.getAttributeUsingId(tool, "link_addresschecked", "value").equals("checked"));

            Common.assertTextOnPage(tool, "Service Address");
            enterIdentificationData.clickCopyFromCustomerAddressButton();

            Common.assertTextOnPage(tool, "Customer identity and contact");
            enterIdentificationData.setNationality("United States");
            enterIdentificationData.setLanguage("English");
            enterIdentificationData.setDateOfBirth("05/05/1985");
            enterIdentificationData.setEmailAddress("email@address.com");
            enterIdentificationData.setPhoneNumber("185655530778");
            enterIdentificationData.setFaxNumber("185655530779");

            Common.assertTextOnPage(tool, "Payment Method");
            enterIdentificationData.clickPaymentMethodCheck();

            enterIdentificationData.clickContinue();

            Common.assertTextNotOnPage(tool, "General warning");
            Common.assertTextNotOnPage(tool, "Please review the following fields");
            Common.assertTextOnPage(tool, "Shopping");

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

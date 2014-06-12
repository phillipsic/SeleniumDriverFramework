package com.comverse.css.pos.nca;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.EnterIdentificationData;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class NCA0030_Capture_billing_information extends CSSTest {
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
    public void testNCA0030_Capture_billing_information() throws Exception {
        try {
            launchCSSApplication();
            String uniqueString = Common.generateTimeStamp();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");

            Common.assertTextOnPage(tool, "Customer Address details");
            enterIdentificationData.setGender("Female");
            enterIdentificationData.setCustomerTitle("Miss");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueString);
            enterIdentificationData.setCustomerLastName("LN" + uniqueString);
            enterIdentificationData.enterCustomerHomeCountry("United States");
            enterIdentificationData.enterCustomerHomeState("Tennessee");
            enterIdentificationData.setCustomerStreetNumber("55");
            enterIdentificationData.setCustomerStreetName("Homestreet");
            enterIdentificationData.enterCustomerCity("Nashville");
            enterIdentificationData.enterCustomerPostCode("11155");

            Common.assertTextOnPage(tool, "Billing Address details");
            assertTrue(Common.isCheckBoxSelected(tool, "link_addresschecked"));
            enterIdentificationData.uncheckSameAsCustomerAddress();
            enterIdentificationData.setBillingTitle("Mr.");
            enterIdentificationData.setBillingFirstName("FN" + uniqueString);
            enterIdentificationData.setBillingLastName("LN" + uniqueString);
            enterIdentificationData.enterBillingHomeCountry("United States");
            enterIdentificationData.enterBillingHomeState("Texas");
            enterIdentificationData.setBillingStreetNumber("77");
            enterIdentificationData.setBillingStreetName("Mystreet");
            enterIdentificationData.enterBillingCity("Dallas");
            enterIdentificationData.enterBillingPostCode("11177");

            Common.assertTextOnPage(tool, "Service Address");
            enterIdentificationData.clickCopyFromBillingAddressButton();

            Common.assertTextOnPage(tool, "Customer identity and contact");
            enterIdentificationData.setNationality("United States");
            enterIdentificationData.setLanguage("English");
            enterIdentificationData.setDateOfBirth("03/03/1983");
            enterIdentificationData.setEmailAddress("email@addr.com");
            enterIdentificationData.setPhoneNumber("185655530775");
            enterIdentificationData.setFaxNumber("185655530776");

            Common.assertTextOnPage(tool, "Payment Method");
            tool.driver.findElement(By.xpath("(//input[@name='method'])[1]")).click();
            enterIdentificationData.setBankCode("192837465");
            enterIdentificationData.setBankAgencyCode("15243");
            enterIdentificationData.setBankAccountNumber("918273640591827364059182736405");
            enterIdentificationData.setBankLastName("LNPayment");

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

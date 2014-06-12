package com.comverse.css.csr.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.EnterIdentificationData;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0020_Capture_administrative_data extends CSSTest {
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
    public void testNCA0020_Capture_administrative_data() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueString = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");
            Common.assertTextOnPage(tool, "Search existing persons by external ID");
            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueString);
            enterIdentificationData.setCustomerLastName("LN" + uniqueString);
            enterIdentificationData.setGender("female");
            enterIdentificationData.setEmailAddress("email@address.com");
            enterIdentificationData.setPhoneNumber("0123456");
            enterIdentificationData.setFaxNumber("6543210");

            enterIdentificationData.enterCustomerPostCode("postcode");
            enterIdentificationData.enterCustomerCity("US ville");
            enterIdentificationData.enterCustomerHomeCountry("United States");
            enterIdentificationData.enterCustomerHomeState("Iowa");

            enterIdentificationData.setCustomerStreetNumber("55");
            enterIdentificationData.setCustomerStreetName("Name of Street");
            enterIdentificationData.clickCopyFromCustomerAddressButton();
            enterIdentificationData.uncheckSameAsCustomerAddress();
            enterIdentificationData.clickCopyFromBillingAddressButton();

            Common.assertTextOnPage(tool, "Payment Method");
            enterIdentificationData.clickPaymentMethodCheck();

            Common.assertTextOnPage(tool, "Customer identity and contact");
            Common.assertTextOnPage(tool, "Marketing Preferences");
            Common.assertTextOnPage(tool, "Search existing persons by external ID");
            Common.assertTextOnPage(tool, "Account Contact");
            Common.assertTextOnPage(tool, "Billing Information");
            Common.assertTextOnPage(tool, "Account Details");

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

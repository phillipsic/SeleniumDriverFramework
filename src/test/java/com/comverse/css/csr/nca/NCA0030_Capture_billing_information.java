package com.comverse.css.csr.nca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialBasicPrepaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0030_Capture_billing_information extends CSSTest {
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
    public void testNCA0030_Capture_billing_information() throws Exception {
        try {
            PO_ResidentialBasicPrepaid po_ResidentialBasicPrepaid = new PO_ResidentialBasicPrepaid();
            launchCSSApplicationAndSSOLogin();

            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");

            enterIdentificationData.setCustomerTitle("Mrs.");
            enterIdentificationData.setCustomerFirstName("FN" + uniqueTimeStamp);
            enterIdentificationData.setCustomerLastName("LN" + uniqueTimeStamp);
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

            enterIdentificationData.setBillingTitle("Mr.");
            enterIdentificationData.setBillingFirstName("NCA0030FN" + uniqueTimeStamp);
            enterIdentificationData.setBillingLastName("NCA0030LN" + uniqueTimeStamp);
            enterIdentificationData.setBillingStreetNumber("30");
            enterIdentificationData.setBillingStreetName("NCA0030StreetName");
            enterIdentificationData.enterBillingHomeState("Arizona");
            enterIdentificationData.enterBillingCity("NCA0030City");
            enterIdentificationData.enterBillingPostCode("0030");

            Common.assertTextOnPage(tool, "Payment Method");
            enterIdentificationData.setBankCode("111111111");
            enterIdentificationData.setBankAgencyCode("22222");
            enterIdentificationData.setBankAccountNumber("333333333333333333333333333333");
            enterIdentificationData.setBankLastName("PayMdLN");

            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.filterSubscriberBundlePrimaryOfferByName(po_ResidentialBasicPrepaid.getOfferName());
            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialBasicPrepaid.getOfferName());
            MyBasket myBasket = shopping.clickSelectOfferInPopUpWindow();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            CheckoutReview checkoutReview = myBasket.clickCheckOut();
            CheckoutConfirmation checkoutConfirmation = checkoutReview.clickConfirm();

            String orderNumber = checkoutConfirmation.getOrderNumberFromPage();
            workSpace = checkoutConfirmation.clickOk();
            SearchRequests searchRequests = workSpace.clickRequests();
            SearchOrders searchOrders = searchRequests.clickSearchOrders();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            workSpace = searchOrders.clickHomeMenu();
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            manageAccount.searchByAccountLastNameSinglePerson("NCA0030LN" + uniqueTimeStamp);

            Common.assertTextOnPage(tool, "Bank code:      111111111");
            Common.assertTextOnPage(tool, "Bank agency code:      22222");
            Common.assertTextOnPage(tool, "Bank account number:      333333333333333333333333333333");
            Common.assertTextOnPage(tool, "Owner Last Name:      PayMdLN");

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

package com.comverse.css.csr.bkm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;
import com.comverse.sec.ComverseOneSingleSignOn;

public class BKM0050_Save_the_current_basket_automatically extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testBKM0050_Save_the_current_basket_automatically() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Subscriber subscriber = new Subscriber(uniqueTimeStamp);
            PO_ResidentialUltraPostpaid po_ResidentialUltraPostpaid = new PO_ResidentialUltraPostpaid();
            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();
            enterIdentificationData.enterDefaultIdentificationData();
            Shopping shopping = enterIdentificationData.clickContinue();

            shopping.clickSubscriberBundlePrimaryOfferName(po_ResidentialUltraPostpaid.getOfferName());
            ConfigureBalance configureBalance = shopping.clickSelectOfferInPopUpWindowExpectingConfigureBalance();
            configureBalance.setSpendingLimit(po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET().getBalanceName(), po_ResidentialUltraPostpaid.getBAL_GPRS_WAP_INTERNET()
                    .getBalanceValue());
            MyBasket myBasket = configureBalance.clickContinueExpectingMyBasket();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            assertEquals("Owner", myBasket.getTypeRole());

            assertTrue(myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            assertEquals("1", myBasket.getQuantity());
            assertEquals("$ " + po_ResidentialUltraPostpaid.getRC() + " Monthly", myBasket.getRecurringCharge());
            assertEquals("$ " + po_ResidentialUltraPostpaid.getNRC(), myBasket.getUpfrontCharge());

            assertEquals(enterIdentificationData.person.getPersonStreetNumberProperty() + " " + enterIdentificationData.person.getPersonStreetNameProperty() + " "
                    + enterIdentificationData.person.getPersonCityProperty() + "  IA " + enterIdentificationData.person.getPersonPostCodeProperty() + " "
                    + enterIdentificationData.person.getPersonHomeCountryProperty(), myBasket.getAddress());

            ComverseOneSingleSignOn comverseOneSingleSignOn = myBasket.clickLogoutExpectingSSO();
           
            RestorePreviousBasket restorePreviousBasket = comverseOneSingleSignOn.loginToCSRAsCSRAdminWithPreviousBasket();
            
            myBasket = restorePreviousBasket.clickRestoreSavedBasket();
            myBasket.assign3InventoriesFirstOffer(subscriber);

            assertEquals("Owner", myBasket.getTypeRole());

            assertTrue(myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            assertEquals("1", myBasket.getQuantity());
            assertEquals("$ " + po_ResidentialUltraPostpaid.getRC() + " Monthly", myBasket.getRecurringCharge());
            assertEquals("$ " + po_ResidentialUltraPostpaid.getNRC(), myBasket.getUpfrontCharge());

            assertEquals(enterIdentificationData.person.getPersonStreetNumberProperty() + " " + enterIdentificationData.person.getPersonStreetNameProperty() + " "
                    + enterIdentificationData.person.getPersonCityProperty() + "  IA " + enterIdentificationData.person.getPersonPostCodeProperty() + " "
                    + enterIdentificationData.person.getPersonHomeCountryProperty(), myBasket.getAddress());

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

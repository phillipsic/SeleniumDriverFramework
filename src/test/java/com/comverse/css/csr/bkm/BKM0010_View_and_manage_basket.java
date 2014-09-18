package com.comverse.css.csr.bkm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.css.data.PO.PO_ResidentialUltraPostpaid;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BKM0010_View_and_manage_basket extends CSSTest {
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
    public void testBKM0010_View_and_manage_basket() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
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

            Common.assertTextEquals("Owner", myBasket.getTypeRole());

            Common.assertVerifyTrue(tool, myBasket.getOfferName().matches(po_ResidentialUltraPostpaid.getOfferName() + "[\\s\\S]*$"));
            Common.assertTextEquals("1", myBasket.getQuantity());
            Common.assertTextEquals("$ " + po_ResidentialUltraPostpaid.getRC() + " Monthly", myBasket.getRecurringCharge());
            Common.assertTextEquals("$ " + po_ResidentialUltraPostpaid.getNRC(), myBasket.getUpfrontCharge());

            Common.assertTextEquals(enterIdentificationData.person.getPersonStreetNumberProperty() + " " + enterIdentificationData.person.getPersonStreetNameProperty() + " "
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

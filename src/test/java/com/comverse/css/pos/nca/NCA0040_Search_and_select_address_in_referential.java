package com.comverse.css.pos.nca;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.EnterIdentificationData;
import com.comverse.css.pos.MyShapeChannel;
import com.comverse.css.pos.SearchAddress;
import com.comverse.css.pos.WorkSpace;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

/**
 * Before running this test case, make sure that
 * com.comverse.css.common.data.AddReferentialAddress test is run and the
 * address is added in Back-Office GUI Address Administration.
 */
public class NCA0040_Search_and_select_address_in_referential extends CSSTest {
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
    public void testNCA0040_Search_and_select_address_in_referential() throws Exception {
        try {
            String country = "France";
            String city = "La Defense";
            String steetName = "Terrasses Boieldieu";
            String zipCode = "92042";

            launchCSSApplication();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");

            SearchAddress searchAddress = enterIdentificationData.clickSearchAddress();

            Common.assertTextOnPage(tool, "Search Address");
            Common.assertTextOnPage(tool, "Please enter your address");
            searchAddress.setCountry(country);
            searchAddress.setStreetName(steetName);
            searchAddress.setCity(city);
            searchAddress.setZipCode(zipCode);
            searchAddress.clickOK();

            Common.assertTextNotOnPage(tool, "No matching addresses found");
            Common.assertTextOnPage(tool, "Please select your address from the list");
            searchAddress.clickSelectAddress();

            assertEquals(enterIdentificationData.getCustomerHomeCountry(), country);
            assertEquals(enterIdentificationData.getCustomerStreetName(), steetName);
            assertEquals(enterIdentificationData.getCustomerCity(), city);
            assertEquals(enterIdentificationData.getCustomerPostCode(), zipCode);

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

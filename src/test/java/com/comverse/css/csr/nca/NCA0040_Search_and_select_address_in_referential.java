package com.comverse.css.csr.nca;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.EnterIdentificationData;
import com.comverse.css.csr.SearchAddress;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class NCA0040_Search_and_select_address_in_referential extends CSSTest {
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
    public void testNCA0040_Search_and_select_address_in_referential() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            EnterIdentificationData enterIdentificationData = workSpace.startNewConvergentResidentialCustomer();

            Common.assertTextOnPage(tool, "Please enter the customer identification data");

            SearchAddress searchAddress = enterIdentificationData.clickSearchAddress();
            searchAddress.setCountry("France");
            searchAddress.setStreetName("Terrasses Boieldieu");
            searchAddress.setCity("La Defense");
            searchAddress.setZipCode("92042");
            searchAddress = searchAddress.clickOk();

            // *****************************************************
            // If test fails at this point then maybe missing data
            // run com.comverse.css.common.data.AddReferentialAddress
            // ******************************************************
            Common.assertTextOnPage(tool, "matching addresses found");

            enterIdentificationData = searchAddress.clickSelectAddress();

            assertEquals("France", enterIdentificationData.getCustomerHomeCountry());
            assertEquals("Terrasses Boieldieu", enterIdentificationData.getCustomerStreetName());
            assertEquals("La Defense", enterIdentificationData.getCustomerCity());
            assertEquals("92042", enterIdentificationData.getCustomerPostCode());

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

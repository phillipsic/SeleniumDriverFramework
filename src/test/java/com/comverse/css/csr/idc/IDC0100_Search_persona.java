package com.comverse.css.csr.idc;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AccountDetails;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.PersonIdentificationSearchResult;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;


public class IDC0100_Search_persona extends CSSTest {
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
    public void testIDC0100_Search_persona() throws Exception {
        try {
            String personName = Common.getB2CLoginName();

            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonFirstName("FN" + personName);
            AccountDetails accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonLastName("LN" + personName);
            accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonLastName("LN" + personName);
            identifyCustomer.clickMorePersonSearchFields();
            identifyCustomer.setDateOfBirth("12/12/1975");
            accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.clickMorePersonSearchFields();
            identifyCustomer.setNationalID(personName);
            accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonLastName("*" + personName);
            accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonLastName("LN*");
            PersonIdentificationSearchResult personIdentificationSearchResult = identifyCustomer.clickPersonSearchExpectingManyResults();

            workSpace = personIdentificationSearchResult.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonFirstName("*" + personName);
            accountDetails = identifyCustomer.clickPersonSearchExpectingOneResult();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonFirstName("FN*");
            personIdentificationSearchResult = identifyCustomer.clickPersonSearchExpectingManyResults();

            workSpace = accountDetails.clickHome();
            identifyCustomer = workSpace.gotoManageAccount();
            identifyCustomer.setPersonLastName("FNZ");
            personIdentificationSearchResult = identifyCustomer.clickPersonSearchExpectingManyResults();
            Common.assertTextOnPage(tool, "No person found.");

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

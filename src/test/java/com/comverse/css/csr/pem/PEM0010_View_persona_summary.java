package com.comverse.css.csr.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.AccountDetailsCommon;
import com.comverse.css.commonpages.CustomerSearchResultCommon;
import com.comverse.css.commonpages.IdentifyCustomerCommon;
import com.comverse.css.commonpages.WorkSpaceCommon;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PEM0010_View_persona_summary extends CSSTest {
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
    public void testPEM0010_View_persona_summary() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            WorkSpaceCommon workSpace = new WorkSpaceCommon(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();
            IdentifyCustomerCommon manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResultCommon customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(workSpace.getAccount().getBillingLastNameProperty());
            AccountDetailsCommon accountDetails = customerSearchResult.clickPersonNameLink(workSpace.getPerson().getPersonLastNameProperty());

            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonFirstNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonStreetNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonDateOfBirthProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson().getPersonLanguageProperty());
            Common.assertTextOnPage(tool, "Active");

            accountDetails.clickSelectOtherPerson();
            Common.assertTextOnPage(tool, workSpace.getPerson2().getPersonLastNameProperty());
            Common.assertTextOnPage(tool, workSpace.getPerson2().getPersonFirstNameProperty());

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

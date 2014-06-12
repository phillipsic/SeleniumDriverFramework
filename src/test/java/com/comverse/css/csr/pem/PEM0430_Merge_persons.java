package com.comverse.css.csr.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.AccountDetailsCommon;
import com.comverse.css.commonpages.PersonManagementCommon;
import com.comverse.css.commonpages.PersonMergeCommon;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class PEM0430_Merge_persons extends CSSTest {
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
    public void testPEM0430_Merge_persons() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = manageAccount.searchByPersonLastNameSinglePerson(Common.getPersonLastName());

            PersonManagementCommon personManagement = accountDetails.clickPersonManagement();

            personManagement.addCMP();
            personManagement.clickActions(Common.getPersonFirstName());
            PersonMergeCommon personMerge = personManagement.clickPersonMerge();
            personMerge.setLastName(personManagement.person3.getPersonLastNameProperty());
            personMerge.clickPersonSearch();
            personMerge.clickSelect();

            personMerge.clickOKFromMerge();
            // TODO - need to check the correct person has been set to inactive
            // - there could be other inactive users on the page.
            Common.assertTextOnPage(tool, "inactive");

            // test.setResult("pass");

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

package com.comverse.css.csr.pem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;
import static org.junit.Assert.assertEquals;

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

            String accountLastName = Common.getLastNameRechargableAccount();

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            PersonManagement personManagement = accountDetails.clickPersonManagement();

            personManagement.addCMP();
            personManagement.clickActions(Common.getPersonFirstName());
            PersonMerge personMerge = personManagement.clickPersonMerge();
            String personLastName = personManagement.person3.getPersonLastNameProperty();
            personMerge.setLastName(personLastName);
            personMerge.clickPersonSearch();
            personMerge.clickSelect();

            personManagement = personMerge.clickOKFromMerge();

            assertEquals("inactive", personManagement.getPersonStatus(personLastName));

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

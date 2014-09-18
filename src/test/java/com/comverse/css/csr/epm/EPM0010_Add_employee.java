package com.comverse.css.csr.epm;

import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.ContactInformation;
import com.comverse.css.csr.LoginInformation;
import com.comverse.css.csr.ViewHierarchy;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

public class EPM0010_Add_employee extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new TelcoAdmin();
    }

    @Test
    public void testEPM0010_Add_employee() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace personalizedWorkSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();
            viewHierarchy.addEmployee(uniqueCode, "OCM User");

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            Common.assertTextEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            Common.assertTextEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            Common.assertTextEquals("OCM User", loginInformation.getCurrentRoleFromPage());

            loginInformation.clickLogoutExpectingSSO();

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }
}
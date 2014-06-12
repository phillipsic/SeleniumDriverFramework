package com.comverse.css.csr.uam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

public class UAM0020_Edit_login_information extends CSSTest {
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
    public void testUAM0020_Edit_login_information() throws Exception {
        try {
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplicationAndSSOLogin();

            WorkSpace personalizedWorkSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();

            viewHierarchy.addOCMPublisherEmployee(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            assertEquals("OCM Publisher", loginInformation.getCurrentRoleFromPage());
            ChangeRoles changeRoles = loginInformation.clickChangeRoles();
            changeRoles.clickRadioButtonOCMUser();
            changeRoles.clickOk();
            assertEquals("Are you sure you want to change roles for login " + uniqueCode + " of member FN" + uniqueCode + " LN" + uniqueCode, changeRoles.getConfirmationMessage());

            loginInformation = changeRoles.clickConfirm();
            assertEquals("OCM User", loginInformation.getCurrentRoleFromPage());

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}

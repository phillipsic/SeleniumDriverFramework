package com.comverse.css.csr.uam;

import com.comverse.common.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.OCMPub;
import com.comverse.data.users.TelcoAdmin;

public class UAM0080_Register_login extends CSSTest {

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
    public void testUAM0080_Register_login() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = workSpace.clickManageTelco();

            User OCMPubUser = new OCMPub();
            NewMemberLegalAddress newMemberLegalAddress = viewHierarchy.clickAddEmployeeOCM();
            newMemberLegalAddress.setFirstName("FN" + uniqueCode);
            newMemberLegalAddress.setLastName("LN" + uniqueCode);
            Login login = newMemberLegalAddress.clickContinue();
            login.enterLogin(uniqueCode);
            OCMPubUser.setNewLogin(uniqueCode);

            login.setRoles(OCMPubUser.getRole());

            AddMemberConfirmation addMemberConfirmation = login.clickContinue();

            Common.assertTextOnPage(tool, "Login:  " + OCMPubUser.getLogin());
            Common.assertTextOnPage(tool, "Roles: " + OCMPubUser.getRole());

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

package com.comverse.css.csr.epm;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.TelcoAdmin;

public class EPM0040_Modify_employee_contact extends CSSTest {
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
    public void testEPM0040_Modify_employee_contact() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueCode = Common.generateTimeStamp();

            WorkSpace personalizedWorkSpace = new WorkSpace(tool, test, user);
            ViewHierarchy viewHierarchy = personalizedWorkSpace.clickManageTelco();
            viewHierarchy.addEmployee(uniqueCode, "OCM User");

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            assertEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            assertEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            ModifyEmployeeContact modifyContact = contactInformation.clickModifyContact();

            modifyContact.enterFirstName("FN" + uniqueCode + "Updated");
            modifyContact.enterLastName("LN" + uniqueCode + "Updated");
            modifyContact.enterEmail(uniqueCode + "Updated@Email.com");
            modifyContact.enterPhoneNumber(uniqueCode + "Updated");
            modifyContact.enterFaxNumber(uniqueCode + "Updated");
            modifyContact.enterAddressLineOne(uniqueCode + "Updated");
            modifyContact.enterPostCode(uniqueCode + "Updated");
            modifyContact.enterCity(uniqueCode + "Updated");

            ModifyEmployeeContactConfirmation modifyEmployeeContactConfirmation = modifyContact.clickOk();

            ModifyEmpContactConf modifyEmpContactConf = modifyEmployeeContactConfirmation.clickOk();
            modifyEmpContactConf.clickOk();

            test.setResult("pass");

        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }

}

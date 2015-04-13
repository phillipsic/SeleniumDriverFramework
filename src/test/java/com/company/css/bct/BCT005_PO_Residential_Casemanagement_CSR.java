package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.Test;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.csr.*;
import com.company.data.apps.CSR;
import com.company.data.users.CSRAdmin;

public class BCT005_PO_Residential_Casemanagement_CSR extends Test {

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testBCT005_PO_Residential_Casemanagement_CSR() throws Exception {
        launchCSSApplicationAndSSOLogin();
        String accountLastName = Common.getLastNameRechargableAccount();
        WorkSpace workSpace = new WorkSpace(tool, test, user);

        IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
        AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);
        accountDetails.clickRefreshThisAccount();
        AddNewCase addNewCase = accountDetails.addNewCase();

        addNewCase.selectCaseType("Service Problem");
        addNewCase.selectCaseProblemArea("Poor Quality - Wired Services");
        addNewCase.enterCaseDescription("This was created by automated test BCT005.");
        addNewCase.selectNoteType("Complaint");
        addNewCase.enterNoteDescription("Note - Complaint description");
        AddCaseReview addCaseReview = addNewCase.clickContinue();
        
        AddCaseConfirmation addCaseConfirmation = addCaseReview.clickCreateCase();
        test.setBugId("NoBug");
        Common.assertVerifyTrue(tool, addCaseConfirmation.getConfirmationMessage().matches("^[\\s\\S]*Your case has been successfully created with the reference[\\s\\S]*$"));

        String caseId = addCaseConfirmation.getCaseID();
        accountDetails = addCaseConfirmation.clickOk();
        ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);

        Common.assertVerifyTrue(tool, viewCase.getCaseType().matches("^[\\s\\S]*Service Problem[\\s\\S]*$"));
        Common.assertVerifyTrue(tool, viewCase.getCaseProblemArea().matches("^[\\s\\S]*Poor Quality - Wired Services[\\s\\S]*$"));
        Common.assertVerifyTrue(tool, viewCase.getCaseDescription().matches("^[\\s\\S]*This was created by automated test BCT005.[\\s\\S]*$"));

        viewCase.clickNotesTab();

        Common.assertVerifyTrue(tool, viewCase.getNoteType().matches("^[\\s\\S]*Complaint[\\s\\S]*$"));
        Common.assertVerifyTrue(tool, viewCase.getNoteDescription().matches("^[\\s\\S]*Note - Complaint description[\\s\\S]*$"));

        test.setResult("pass");
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }
}

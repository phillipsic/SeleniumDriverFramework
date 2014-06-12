package com.comverse.caseui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.caseui.common.CaseUITest;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.CustomerSearchResultCommon;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CASEUI;
import com.comverse.data.users.CASEUIUser;
import com.comverse.data.users.CSRAdmin;

public class PBM61_Create_case extends CaseUITest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CASEUI();
        user = new CASEUIUser();
    }

    @Test
    public void testPBM61_Create_case() throws Exception {

        try {
            launchCaseUIApplicationWithSSO();
            String caseType = "Self-Service Problem";
            String problemArea = "Forgot Password";
            String description = "PBM61_Create_case";
            String accountLastname = Common.getLastNameOfPostPaidAccount();

            CaseUIHomePage homePage = new CaseUIHomePage(tool, test, user);
            String mainWindow = Common.getCurrentWindowHandle(tool);

            homePage.clickCaseManagement();
            homePage.clickCases();
            CaseUICases cases = new CaseUICases(tool, test, user);
            cases.clickNewCase();
            cases.clickSearchAccount(mainWindow);
            cases.clickSearch(accountLastname);
            cases.selectFirstAccount(mainWindow);
            cases.selectCaseType(caseType);
            cases.selectProblemArea(problemArea);
            cases.setCaseDescription(description);
            cases.saveNewCase();
            String caseID = cases.getCaseID();
            homePage.clickSignOut();

            user = new CSRAdmin();
            launchCSSApplication();
            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResultCommon customerSearchResult = manageAccount.searchByCaseIDMultiplePersons(caseID);
            customerSearchResult.clickFirstAccountLink();
            Common.assertTextOnPage(tool, caseType);
            Common.assertTextOnPage(tool, problemArea);
            Common.assertTextOnPage(tool, caseID);

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

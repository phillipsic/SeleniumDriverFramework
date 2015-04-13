package com.company.css.bct;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.framework.app.common.AppTest;
import com.framework.app.common.Common;
import com.framework.app.common.Prep;
import com.company.css.pos.*;
import com.company.data.apps.POS;
import com.company.data.users.TelcoRetailerAdmin;

public class BCT003_PO_Residential_Notification_POS extends AppTest {

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @AppTest
    public void testBCT003_PO_Residential_Notification_POS() throws Exception {
        launchApplication();
        String uniqueTimeStamp = Common.generateTimeStamp();
        String accountLastName = Common.getLastNameRechargableAccount();
        MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
        WorkSpace workSpace = myShapeChannel.loginToPOS(user);

        IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

        AccountDetails accountDetails = identifyCustomer.searchByAccountLastNameSinglePerson(accountLastName);

        ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();

        modifyContactInformation.enterFirstName("fn" + uniqueTimeStamp);
        ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();
        test.setBugId("CBS00169186");
        RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();
        test.setBugId("NoBug");

        accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
        RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
        requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
        accountDetails = requestsForCustomer.clickAccounts();
        accountDetails.clickRefreshThisAccount();
        modifyContactInformation = accountDetails.clickModifyBillingContact();
        Common.assertTextEquals("fn" + uniqueTimeStamp, modifyContactInformation.getFirstName());

        test.setResult("pass");

    }

    @Override
    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}

package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.*;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0300_Request_for_coherency_check extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testSUM0300_Request_for_coherency_check() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialUltraPostpaidCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            CoherencyCheckCommon coherencyCheck = subscriberDashboard.clickCoherencyCheckNormal();
            String orderNumber = coherencyCheck.getOrderNumber();
            coherencyCheck.clickOK();
            subscriberDashboard.clickAccountIDFromNavigationPanel();
            SearchOrdersCommon searchOrders = accountDetails.clickSearchOrders();
            searchOrders.setOrderStatusToAll();
            searchOrders.waitUntilOrderCompletedOrFailed(orderNumber);
            searchOrders.clickViewDetails();
            Common.assertTextOnPage(tool, "Coherency Check");
            Common.assertTextOnPage(tool, "Completed");

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

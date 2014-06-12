package com.comverse.css.pos.aca;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

/**
 * 
 * @author Vikram Sharma
 */
public class ACA0050_View_subscriber_combined_history extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testACA0050_View_subscriber_combined_history() throws Exception {
        try {

            launchCSSApplication();
            String accountNumberWithComHist = preparation.readPropertyFromAccountPropertyFile("Invoice.NRC");
            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountID(accountNumberWithComHist);
            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            ViewCombinedHistory viewCombinedHistory = subscriberDashboard.clickonCombinedHistory();
            viewCombinedHistory.enterToDateTodayFromDateMinus10();
            viewCombinedHistory.deselectbox();
            viewCombinedHistory.clickSearch();
            Common.returnCleanPageSource(tool);
            Common.assertTextOnPage(tool, "Combined history found");
            assertTrue(Common.isTextNotOnPage(tool, "No data found"));
            viewCombinedHistory.ViewNRCTermDetails();

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

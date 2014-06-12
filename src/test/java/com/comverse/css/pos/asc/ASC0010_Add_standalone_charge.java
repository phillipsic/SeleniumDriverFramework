package com.comverse.css.pos.asc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerUser;

public class ASC0010_Add_standalone_charge extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerUser();
    }

    @Test
    public void testASC0010_Add_standalone_charge() throws Exception {
        try {
            launchCSSApplication();
            String accountLastname = Common.getBCTLastName();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = myShapeChannel.loginToPOS(user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();

            AccountDetails accountDashboard = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastname);
            AddStandaloneCharge addCharge = accountDashboard.clickAddStandaloneCharge();
            addCharge.selectEventTypeDispatch();
            addCharge.selectNRCTypeDispatchFee();

            Common.assertTextOnPage(tool, "Dispatch");
            Common.assertTextOnPage(tool, "Dispatch Fee");
            Common.assertTextOnPage(tool, "$ 50.00");

            addCharge.confirmStandaloneCharge();

            addCharge.VerifyNRCInUnbilledTransactions();

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

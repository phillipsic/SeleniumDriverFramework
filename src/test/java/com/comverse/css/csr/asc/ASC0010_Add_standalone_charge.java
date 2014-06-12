package com.comverse.css.csr.asc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AccountDetails;
import com.comverse.css.csr.AddStandaloneCharge;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class ASC0010_Add_standalone_charge extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRAdmin();
    }

    @Test
    public void testASC0010_Add_standalone_charge() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastname = Common.getBCTLastName();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
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

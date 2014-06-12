package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.AccountDetails;
import com.comverse.css.csr.IdentifyCustomer;
import com.comverse.css.csr.WorkSpace;
import com.comverse.css.data.PO.PO_DIYRechargesPromotions;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class SUM0220_Add_RPO extends CSSTest {
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
    public void testSUM0220_Add_RPO() throws Exception {
        try {
            PO_DIYRechargesPromotions po_DIYRechargesPromotions = new PO_DIYRechargesPromotions();
            launchCSSApplicationAndSSOLogin();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCADIYRechargesPromotionsCSR();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            accountDetails.selectFirstSubscriberFromNavigationPanel();

            Common.assertTextOnPage(tool, po_DIYRechargesPromotions.getOfferName());
            Common.assertTextOnPage(tool, po_DIYRechargesPromotions.getEngagementDuration());

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

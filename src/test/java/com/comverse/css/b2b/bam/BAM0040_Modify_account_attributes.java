package com.comverse.css.b2b.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2b.*;
import com.comverse.css.common.*;
import com.comverse.data.apps.B2B;
import com.comverse.data.users.B2BAdmin;

public class BAM0040_Modify_account_attributes extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2B();
        user = new B2BAdmin();
    }

    @Test
    public void testBAM0040_Modify_account_attributes() throws Exception {

        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);
            MyshapeBusiness loginPage = new MyshapeBusiness(tool, test, user);
            WorkSpace workSpace = loginPage.loginToB2B(user);
            workSpace.setAccount(account);
            AccountDetails accountDetails = workSpace.clickAccount();

            accountDetails.clickAccountAttributesTab();
            ModifyAccountAttributes modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            account.setBillingCustomerSocialSecurityNumberProperty("SN" + uniqueTimeStamp);

            modifyAccountAttributes.enterSecurityNumber(account.getBillingCustomerSocialSecurityNumberProperty());

            RequestSubmission requestSubmission = modifyAccountAttributes.clickModifyAttributes();
            accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilBizFirstRequestCompletedOrFailed();
            accountDetails = requestsForCustomer.clickAccounts();

            accountDetails.clickAccountAttributesTab();
            modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            Common.assertTextEquals(account.getBillingCustomerSocialSecurityNumberProperty(), modifyAccountAttributes.getSecurityNumber());

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

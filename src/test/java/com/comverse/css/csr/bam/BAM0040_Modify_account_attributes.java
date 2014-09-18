package com.comverse.css.csr.bam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class BAM0040_Modify_account_attributes extends CSSTest {
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
    public void testBAM0040_Modify_account_attributes() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);
            AccountDetails accountDetails = customerSearchResult.clickFirstAccountLink();
            accountDetails.clickAccountAttributesTab();
            ModifyAccountAttributes modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            account.setBillingCustomerSocialSecurityNumberProperty("SN" + uniqueTimeStamp);
            account.setBillingPurchaseOrderProperty("PO" + uniqueTimeStamp);
            account.setBillingSalesCodeProperty("SC" + uniqueTimeStamp);
            account.setBillingSecurityWordProperty("SW" + uniqueTimeStamp);
            account.setBillingSICCodeProperty("3210");

            modifyAccountAttributes.enterSecurityNumber(account.getBillingCustomerSocialSecurityNumberProperty());
            modifyAccountAttributes.enterPurchaseOrder(account.getBillingPurchaseOrderProperty());
            modifyAccountAttributes.enterSalesCode(account.getBillingSalesCodeProperty());
            modifyAccountAttributes.enterSecurityWord(account.getBillingSecurityWordProperty());
            modifyAccountAttributes.enterSICWord(account.getBillingSICCodeProperty());
            RequestSubmission requestSubmission = modifyAccountAttributes.clickModifyAttributes();
            accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            accountDetails = requestsForCustomer.clickAccounts();

            accountDetails.clickAccountAttributesTab();
            // accountDetails.clickRefreshThisAccount();
            modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            Common.assertTextEquals(account.getBillingCustomerSocialSecurityNumberProperty(), modifyAccountAttributes.getSecurityNumber());
            Common.assertTextEquals(account.getBillingPurchaseOrderProperty(), modifyAccountAttributes.getPurchaseOrder());
            Common.assertTextEquals(account.getBillingSalesCodeProperty(), modifyAccountAttributes.getSalesCode());
            Common.assertTextEquals(account.getBillingSecurityWordProperty(), modifyAccountAttributes.getSecurityWord());

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

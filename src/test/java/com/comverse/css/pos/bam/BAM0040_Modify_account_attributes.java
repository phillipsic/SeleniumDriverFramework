package com.comverse.css.pos.bam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class BAM0040_Modify_account_attributes extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testBAM0040_Modify_account_attributes() throws Exception {
        try {
            launchCSSApplication();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearchResult = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);
            AccountDetails accountDetails = customerSearchResult.clickFirstAccountLink();
            accountDetails.clickAccountAttributesTab();
            ModifyAccountAttributes modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            account.setBillingCustomerSocialSecurityNumberProperty("SN" + uniqueTimeStamp);
            account.setBillingPurchaseOrderProperty("PO" + uniqueTimeStamp);
            account.setBillingSalesCodeProperty("SC" + uniqueTimeStamp);
            account.setBillingSecurityWordProperty("SW" + uniqueTimeStamp);
            account.setBillingSICCodeProperty("3,210");

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
            modifyAccountAttributes = accountDetails.clickModifyAccountContact();

            assertEquals(account.getBillingCustomerSocialSecurityNumberProperty(), modifyAccountAttributes.getSecurityNumber());
            assertEquals(account.getBillingPurchaseOrderProperty(), modifyAccountAttributes.getPurchaseOrder());
            assertEquals(account.getBillingSalesCodeProperty(), modifyAccountAttributes.getSalesCode());
            assertEquals(account.getBillingSecurityWordProperty(), modifyAccountAttributes.getSecurityWord());
            assertEquals(account.getBillingSICCodeProperty(), modifyAccountAttributes.getSICWord());

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

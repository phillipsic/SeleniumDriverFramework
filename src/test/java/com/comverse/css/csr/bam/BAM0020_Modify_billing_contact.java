package com.comverse.css.csr.bam;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.*;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRUser;

public class BAM0020_Modify_billing_contact extends CSSTest {

    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new CSR();
        user = new CSRUser();
    }

    @Test
    public void testBAM0020_Modify_billing_contact() throws Exception {

        try {
            launchCSSApplicationAndSSOLogin();
            String uniqueTimeStamp = Common.generateTimeStamp();
            Account account = new Account(uniqueTimeStamp);
            String accountLastName = Common.getLastNameOfPostPaidAccount();

            WorkSpace workSpace = new WorkSpace(tool, test, user);
            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            CustomerSearchResult customerSearch = manageAccount.searchByAccountLastNameMultiplePersons(accountLastName);
            AccountDetails accountDetails = customerSearch.clickFirstAccountLink();

            ModifyContactInformation modifyContactInformation = accountDetails.clickModifyBillingContact();
            account.setBillingFirstNameProperty("BillingFN" + uniqueTimeStamp);
            account.setBillingLastNameProperty("BillingLN" + uniqueTimeStamp);
            account.setBillingEmailProperty("Email-" + uniqueTimeStamp + "@email.com");
            account.setBillingPhoneProperty("PN" + uniqueTimeStamp);
            account.setBillingFaxProperty("FAXN" + uniqueTimeStamp);
            account.setBillingPostCodeProperty("PC" + uniqueTimeStamp);
            account.setBillingCityProperty("CITY" + uniqueTimeStamp);
            account.setBillingStreetNameProperty("ADD1-" + uniqueTimeStamp);

            modifyContactInformation.enterFirstName(account.getBillingFirstNameProperty());
            modifyContactInformation.enterLastName(account.getBillingLastNameProperty());
            modifyContactInformation.enterEmail(account.getBillingEmailProperty());
            modifyContactInformation.enterPhoneNumber(account.getBillingPhoneProperty());
            modifyContactInformation.enterFaxNumber(account.getBillingFaxProperty());
            modifyContactInformation.enterPostCode(account.getBillingPostCodeProperty());
            modifyContactInformation.enterCity(account.getBillingCityProperty());
            modifyContactInformation.enterAddressLineOne(account.getBillingStreetNameProperty());

            ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();
            test.setBugId("CBS00169186");
            RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOk();
            test.setBugId("NoBug");
            accountDetails = requestSubmission.clickOkModifyRequestGoTOAccountDashboard();
            accountDetails.clickRefreshThisAccount();
            RequestsForCustomer requestsForCustomer = accountDetails.clickViewRequestsForThisCustomer();
            requestsForCustomer.waitUntilFirstRequestCompletedOrFailed();
            Common.storeLastNamePostpaidAccount(account.getBillingLastNameProperty(), "Modified by " + this.getClass().getSimpleName());

            accountDetails = requestsForCustomer.clickAccounts();
            accountDetails.clickRefreshThisAccount();
            modifyContactInformation = accountDetails.clickModifyBillingContact();
            assertEquals(account.getBillingFirstNameProperty(), modifyContactInformation.getFirstName());
            assertEquals(account.getBillingLastNameProperty(), modifyContactInformation.getLastName());
            assertEquals(account.getBillingEmailProperty(), modifyContactInformation.getEmail());
            assertEquals(account.getBillingPhoneProperty(), modifyContactInformation.getPhoneNumber());
            assertEquals(account.getBillingFaxProperty(), modifyContactInformation.getFaxNumber());
            assertEquals(account.getBillingPostCodeProperty(), modifyContactInformation.getZipCode());
            assertEquals(account.getBillingCityProperty(), modifyContactInformation.getCity());
            assertEquals(account.getBillingStreetNameProperty(), modifyContactInformation.getAddressLineOne());

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

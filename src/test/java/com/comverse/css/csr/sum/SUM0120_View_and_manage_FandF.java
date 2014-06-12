package com.comverse.css.csr.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.commonpages.*;
import com.comverse.css.csr.WorkSpace;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class SUM0120_View_and_manage_FandF extends CSSTest {
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
    public void testSUM0120_View_and_manage_FandF() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String phoneNumber = "1856334821";

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundleCSR();

            IdentifyCustomerCommon identifyCustomer = workSpace.gotoManageAccount();

            AccountDetailsCommon accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetailsCommon subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            YourFriendsAndFamilyNumbersCommon yourFriendsAndFamilyNumbers = subscriberDashboard.clickManageFriendsAndFamily();
            ConfigurationOfYourFriendsAndFamilyNumbersCommon configurationOfYourFriendsAndFamilyNumbers = yourFriendsAndFamilyNumbers.clickReconfigure();
            configurationOfYourFriendsAndFamilyNumbers.setPhoneNumber(phoneNumber);
            configurationOfYourFriendsAndFamilyNumbers.clickOK();
            yourFriendsAndFamilyNumbers.verifyPhoneNumber(phoneNumber);
            yourFriendsAndFamilyNumbers.clickOK();
            subscriberDashboard.clickManageFriendsAndFamily();
            yourFriendsAndFamilyNumbers.verifyPhoneNumber(phoneNumber);

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

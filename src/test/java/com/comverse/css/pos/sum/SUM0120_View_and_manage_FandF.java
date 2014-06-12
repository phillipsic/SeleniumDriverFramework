package com.comverse.css.pos.sum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class SUM0120_View_and_manage_FandF extends CSSTest {
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
    public void testSUM0120_View_and_manage_FandF() throws Exception {

        try {
            launchCSSApplication();
            String phoneNumber = "1856334821";

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            workSpace.doResitdentialNCAResidentialBasicPrepaidBundlePOS();

            IdentifyCustomer identifyCustomer = workSpace.gotoManageAccount();

            AccountDetails accountDetails = identifyCustomer.searchByPersonLastNameSinglePerson(workSpace.getPerson().getPersonLastNameProperty());

            SubscriberDetails subscriberDashboard = accountDetails.selectFirstSubscriberFromNavigationPanel();
            YourFriendsAndFamilyNumbers yourFriendsAndFamilyNumbers = subscriberDashboard.clickManageFriendsAndFamily();
            ConfigurationOfYourFriendsAndFamilyNumbers configurationOfYourFriendsAndFamilyNumbers = yourFriendsAndFamilyNumbers.clickReconfigure();
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

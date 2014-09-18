package com.comverse.css.pos.uam;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.common.User;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoAdmin;
import com.comverse.data.users.TelcoRetailerAdmin;

public class UAM0050_Change_secret_question_and_answer extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoAdmin();
    }

    @Test
    public void testUAM0050_Change_secret_question_and_answer() throws Exception {

        try {
            String uniqueCode = Common.generateTimeStamp();

            launchCSSApplication();

            MyShapeChannel myShapeChannel = new MyShapeChannel(tool, test, user);
            myShapeChannel.clickAdminLogin(application);
            WelcomeToYourWorkspace welcomeToYourWorkspace = myShapeChannel.loginToPOSAsTelcoAdmin(user);

            SearchRetailer searchRetailer = welcomeToYourWorkspace.clickManageRetailer();
            searchRetailer.setDealerName("*");
            searchRetailer.clickSearchDealerName();
            ViewHierarchy viewHierarchy = searchRetailer.clickDealerLink("Dealer 1");

            String tempPassword = viewHierarchy.addEmployeeTelcoRetailerSubscriber(uniqueCode);

            ContactInformation contactInformation = viewHierarchy.clickEmployeeNameLink("FN" + uniqueCode, "LN" + uniqueCode);
            Common.assertTextEquals("First Name: FN" + uniqueCode, contactInformation.getFirstName());
            Common.assertTextEquals("Last Name: LN" + uniqueCode, contactInformation.getLastName());
            LoginInformation loginInformation = contactInformation.clickViewLoginInformationLink();
            Common.assertTextEquals("Telco Retailer Subscriber", loginInformation.getCurrentRoleFromPage());
            myShapeChannel = loginInformation.clickLogout();
            myShapeChannel.clickHomePage();
            User user2 = new TelcoRetailerAdmin();
            user2.setNewLogin(uniqueCode);
            user2.setNewPassword(tempPassword);
            myShapeChannel.successfulLogin(user2);

            myShapeChannel.setYourPassword(tempPassword);
            myShapeChannel.setNewPassword("Passw0rd!");
            myShapeChannel.setConfirmNewPassword("Passw0rd!");
            myShapeChannel.setSecretAnswer("Passw0rd!");
            myShapeChannel.clickChange();
            WorkSpace workSpace = myShapeChannel.clickAgreeTermsAndConditions();
            contactInformation = workSpace.clickUserInformation();
            loginInformation = contactInformation.clickViewLoginInformationLink();
            ChangeSecretAnswer changeSecretAnswer = loginInformation.clickChangeYourSecretAnswer();
            changeSecretAnswer.setSecretQuestion("What 's your company animal 's name?");
            changeSecretAnswer.setSecretAnswer("Georgie");
            changeSecretAnswer.setPassword("Passw0rd!");
            ConfirmNewSecretAnswer confirmNewSecretAnswer = changeSecretAnswer.clickChangeSecretAnswer();
            ConfirmChange confirmChange = confirmNewSecretAnswer.clickOK();
            loginInformation = confirmChange.clickOK();
            changeSecretAnswer = loginInformation.clickChangeYourSecretAnswer();

            Common.assertTextEquals("Georgie", changeSecretAnswer.getSecretAnswer());

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

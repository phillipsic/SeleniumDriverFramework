package com.comverse.css.b2c.cust;

import org.junit.Before;
import org.junit.Test;

import com.comverse.css.b2c.*;
import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.data.apps.B2C;

public class CUST0040_Modify_Customer_Profile extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new B2C();
    }

    @Test
    public void testCUST0040_Modify_Customer_Profile() throws Exception {
        try {
            launchCSSApplication();
            String login = Common.getB2CLoginName();
            String password = Common.getB2CPassword();

            HomePage homePage = new HomePage(tool, test, user);
            homePage.enterUsername(login);
            homePage.enterPassword(password);
            System.out.println(login + "/" + password);
            SubscriberDetail subscriberDetail = homePage.clickLogIn();
            Common.assertTextOnPage(tool, "Welcome");

            SearchMember myInformation = subscriberDetail.clickMyInformationTab();
            CustomerProfile changeProfile = myInformation.clickChangeProfile();
            ModifyProfileInformation modifyProfileInformation = changeProfile.clickModify();
            modifyProfileInformation.selectApprovalSequencing("Yes");
            ConfirmModifyProfileInformation confirmModifyProfileInformation = modifyProfileInformation.clickOK();
            confirmModifyProfileInformation.clickOK();
            Common.assertTextOnPage(tool, " has been submitted successfully.");

            test.setResult("pass");
        } catch (AlreadyRunException e) {
        } catch (Exception e) {
            verificationErrors.append(e.getMessage());
            throw e;
        }

    }
}

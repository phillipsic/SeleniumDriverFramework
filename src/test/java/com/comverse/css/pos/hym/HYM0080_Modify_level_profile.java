package com.comverse.css.pos.hym;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.pos.*;
import com.comverse.data.apps.POS;
import com.comverse.data.users.TelcoRetailerAdmin;

public class HYM0080_Modify_level_profile extends CSSTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        preparation = new Prep();
        application = new POS();
        user = new TelcoRetailerAdmin();
    }

    @Test
    public void testHYM0080_Modify_level_profile() throws Exception {
        try {
            launchCSSApplication();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            ViewHierarchy viewHierarchy = workSpace.clickHierarchy();
            ProfileInformation profileInformation = viewHierarchy.clickViewProfile();

            ModifyProfileInformation modifyProfileInformation = profileInformation.clickModify();
            modifyProfileInformation.setTimeZone("EST");

            ModifyProfileInformationConfirmation modifyProfileInformationConfirmation = modifyProfileInformation.clickOkToModify();
            RequestSubmission requestSubmission = modifyProfileInformationConfirmation.clickOkToConfirm();
            Common.isTextOnPage(tool, "The \" Modify Profile Information\" has been submitted successfully.");
            profileInformation = requestSubmission.clickOkToSubmitRequest();
            profileInformation.clickHierarchy();

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
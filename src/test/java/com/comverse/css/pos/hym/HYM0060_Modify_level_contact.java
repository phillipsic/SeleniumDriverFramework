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

public class HYM0060_Modify_level_contact extends CSSTest {
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
    public void testHYM0060_Modify_level_contact() throws Exception {
        try {
            launchCSSApplication();

            String levelName = "POS_" + Common.generateTimeStamp();
            String uniqueString = "Channel_" + Common.generateTimeStamp();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            ViewHierarchy viewHierarchy = workSpace.clickHierarchy();

            viewHierarchy.addWeeklyLevel();
            viewHierarchy.clickWeeklyLevel();

            AddLevelContactInformation addLevelContactInformation = viewHierarchy.clickAddLevel();
            addLevelContactInformation.setLevelName(levelName);
            addLevelContactInformation.setLevelState("Georgia");
            addLevelContactInformation.setLevelZipCode("Post Code");
            AddLevelConfirmation addLevelConfirmation = addLevelContactInformation.clickOk();

            AddLevel addLevel = addLevelConfirmation.clickOk();
            Common.isTextOnPage(tool, "The \" Add Level\" has been submitted successfully.");
            viewHierarchy = addLevel.clickOk();
            viewHierarchy.clickWeeklyLevel();
            viewHierarchy.clickLevelLink(levelName);
            ContactInformation contactInformation = viewHierarchy.clickViewContact();
            ModifyContactInformation modifyContactInformation = contactInformation.clickModifyContactInformation();
            modifyContactInformation.setLevelName(uniqueString);
            modifyContactInformation.setLevelState("Ohio");
            ModifyContactInformationConfirmation modifyContactInformationConfirmation = modifyContactInformation.clickOk();
            RequestSubmission requestSubmission = modifyContactInformationConfirmation.clickOkToConfirm();
            Common.isTextOnPage(tool, "The \"Modify Level Legal Contact\" has been submitted successfully.");
            contactInformation = requestSubmission.clickOkToSubmit();
            Common.assertTextOnPage(tool, "Level name: " + uniqueString);
            Common.assertTextOnPage(tool, "Ohio");
            contactInformation.clickBack();
            Common.isTextOnPage(tool, uniqueString);

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
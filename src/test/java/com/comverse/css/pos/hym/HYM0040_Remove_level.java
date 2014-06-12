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

public class HYM0040_Remove_level extends CSSTest {
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
    public void testHYM0040_Remoove_level() throws Exception {
        try {
            launchCSSApplication();

            String levelName = "POS_" + Common.generateTimeStamp();

            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);
            ViewHierarchy viewHierarchy = workSpace.clickHierarchy();

            AddLevelContactInformation addLevelContactInformation = viewHierarchy.clickAddLevel();
            addLevelContactInformation.setLevelName(levelName);
            addLevelContactInformation.setLevelState("Iowa");
            addLevelContactInformation.setLevelZipCode("Post Code");
            AddLevelConfirmation addLevelConfirmation = addLevelContactInformation.clickOk();

            AddLevel addLevel = addLevelConfirmation.clickOk();
            Common.isTextOnPage(tool, "The \" Add Level\" has been submitted successfully.");
            viewHierarchy = addLevel.clickOk();
            viewHierarchy.clickLevelLink(levelName);

            RemoveLevel removeLevel = viewHierarchy.clickRemoveLevel();
            Common.isTextOnPage(tool, "Click OK to confirm the removal of the '" + levelName
                    + "' Deactivated users will be removed and subscribers will be moved to the parent level.");
            removeLevel.clickOkToRemoveLevel();
            Common.isTextOnPage(tool, "The \"Remove Level\" has been submitted successfully.");
            viewHierarchy = removeLevel.clickOkToConfirm();
            Common.isTextNotOnPage(tool, levelName);

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
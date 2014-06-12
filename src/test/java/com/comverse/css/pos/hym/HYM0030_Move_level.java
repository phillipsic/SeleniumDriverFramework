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

public class HYM0030_Move_level extends CSSTest {
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
    public void testHYM0030_Move_level() throws Exception {
        try {
            launchCSSApplication();

            String levelName = "Shape" + Common.generateTimeStamp();
            String weeklyLevelName = "KK" + Common.generateTimeStamp();

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

            viewHierarchy.addWeeklyLevel();
            viewHierarchy.clickWeeklyLevel();

            viewHierarchy.clickAddLevel();
            addLevelContactInformation.setLevelName(weeklyLevelName);
            addLevelContactInformation.setLevelState("Iowa");
            addLevelContactInformation.setLevelZipCode("Post Code");
            addLevelContactInformation.clickOk();

            addLevelConfirmation.clickOk();
            Common.isTextOnPage(tool, "The \" Add Level\" has been submitted successfully.");
            viewHierarchy = addLevel.clickOk();

            viewHierarchy.clickLevelLink(levelName);
            MoveLevel moveLevel = viewHierarchy.clickMoveLevel();
            MoveLevelStatus moveLevelStatus = moveLevel.clickSelectForLevelName(weeklyLevelName);
            Common.isTextOnPage(tool, "The \" Move Level\" has been submitted successfully.");
            moveLevelStatus.clickHierarchy();

            viewHierarchy.clickMoveLevel();
            moveLevel.findSelectByLevelname(weeklyLevelName);

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
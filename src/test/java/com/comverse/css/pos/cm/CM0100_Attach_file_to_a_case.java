package com.comverse.css.pos.cm;

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

public class CM0100_Attach_file_to_a_case extends CSSTest {
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
    public void testCM0100_Attach_file_to_a_case() throws Exception {

        try {
            launchCSSApplication();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            String attachmentName = Common.generateTimeStamp();
            MyShapeChannel loginPage = new MyShapeChannel(tool, test, user);
            WorkSpace workSpace = loginPage.loginToPOS(user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            viewCase.clickAttachmentsTab();
            CreateAttachment createAttachment = viewCase.clickAddAttachment();
            createAttachment.addAttachmentName(attachmentName);
            createAttachment.addDescription("Created by POS CM0100_Attach_file_to_a_case");
            createAttachment.uploadAttachment("\\test\\com\\comverse\\css\\common\\data\\Attachment\\Attachment2.txt");
            createAttachment.clickContinue();
            createAttachment.clickOKFromAddAttachment();
            viewCase = createAttachment.clickOKFromCreateNewAttachmentResult();
            test.setBugId("CBS00163973");
            Common.assertTextOnPage(tool, attachmentName);
            test.setBugId("NoBug");
            viewCase.clickBack();

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

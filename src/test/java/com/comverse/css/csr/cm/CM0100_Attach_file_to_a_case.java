package com.comverse.css.csr.cm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.comverse.css.common.AlreadyRunException;
import com.comverse.css.common.CSSTest;
import com.comverse.css.common.Common;
import com.comverse.css.common.Prep;
import com.comverse.css.csr.*;
import com.comverse.data.apps.CSR;
import com.comverse.data.users.CSRAdmin;

public class CM0100_Attach_file_to_a_case extends CSSTest {
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
    public void testCM0100_Attach_file_to_a_case() throws Exception {
        try {
            launchCSSApplicationAndSSOLogin();
            String accountLastName = Common.getLastNameOfPostPaidAccount();
            String attachmentName = Common.generateTimeStamp();

            WorkSpace workSpace = new WorkSpace(tool, test, user);

            IdentifyCustomer manageAccount = workSpace.gotoManageAccount();
            AccountDetails accountDetails = manageAccount.gotoAccountDashboardUsingAccountLastName(accountLastName);

            String caseId = accountDetails.doAddCase();

            ViewCase viewCase = accountDetails.clickLinkOfCaseID(caseId);
            viewCase.clickAttachmentsTab();
            CreateAttachment createAttachment = viewCase.clickAddAttachment();
            createAttachment.addAttachmentName(attachmentName);
            createAttachment.addDescription("Created by POS CM0100_Attach_file_to_a_case");
            createAttachment.uploadAttachment("\\src\\test\\com\\comverse\\css\\common\\data\\Attachment\\Attachment2.txt");
            createAttachment.clickContinue();
            createAttachment.clickOKFromAddAttachment();
            createAttachment.clickOKFromCreateNewAttachmentResult();

            test.setBugId("CBS00163973");
            Common.assertTextOnPage(tool, "Attachment2.txt");
            test.setBugId("NoBug");

            Common.assertTextOnPage(tool, "1 attachment(s) found");
            Common.assertTextOnPage(tool, attachmentName);
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

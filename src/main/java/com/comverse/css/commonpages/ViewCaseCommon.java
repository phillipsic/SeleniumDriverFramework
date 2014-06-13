/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class ViewCaseCommon extends CommonMenu {

    public ViewCaseCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();

        // Check that we're on the right page.
        if (!"View Case".equals(currentScreen)) {
            throw new IllegalStateException("Expecting: View Case, but got: " + currentScreen);
        }
    }

    public String getCaseType() throws Exception {
        String caseID = tool.driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();
        return caseID;
    }

    public String getCaseStatus() throws Exception {
        String caseStatus = tool.driver.findElement(By.xpath("//tr[4]/td/span[2]")).getText();
        return caseStatus;
    }

    public String getCaseJustificationStatus() throws Exception {
        String caseStatus = tool.driver.findElement(By.xpath("//tr[6]/td/span[2]")).getText();
        return caseStatus;
    }

    public String getCaseProblemArea() throws Exception {
        String caseProblemArea = tool.driver.findElement(By.xpath("//tr[8]/td/span[2]")).getText();
        return caseProblemArea;
    }

    public String getCaseDescription() throws Exception {
        String caseDescription = tool.driver.findElement(By.xpath("//*[@id=\"description\"]")).getText();
        System.out.println("caseDescription : " + caseDescription);
        return caseDescription;
    }

    public String getNoteType() throws Exception {
        String noteType = tool.driver.findElement(By.xpath("//table[@class='listTable']/tbody/tr[1]/td")).getText();

        System.out.println("noteType : " + noteType);
        return noteType;
    }

    public String getNoteDescription() throws Exception {
        String noteDesc = tool.driver.findElement(By.name("noteDescription")).getText();
        System.out.println("noteDesc : " + noteDesc);
        return noteDesc;
    }

    public void clickNotesTab() throws Exception {
        tool.clickUsingXPath(tool, "//em[contains(text(), 'Notes')]");
    }

    public void clickAttachmentsTab() throws Exception {

        tool.clickUsingXPath(tool, "//em[contains(text(), 'Attachments')]");
    }

    public EditCaseCommon clickEditCase() throws Exception {
        tool.clickUsingLinkText(tool, "Edit Case");
        return new EditCaseCommon(tool, test, user);
    }

    public CreateAttachmentCommon clickAddAttachment() throws Exception {
        tool.clickUsingLinkText(tool, "Add");
        return new CreateAttachmentCommon(tool, test, user);
    }

    public EditCaseCommon clickReopen() throws Exception {
        tool.clickUsingLinkText(tool, "Reopen");
        return new EditCaseCommon(tool, test, user);
    }

    public AccountDetailsCommon clickBack() throws Exception {
        tool.clickUsingID(tool, "youcan_ON_BACK");
        return new AccountDetailsCommon(tool, test, user);
    }

    public ListCasesCommon clickBackExpectingListCases() throws Exception {
        tool.clickUsingID(tool, "youcan_ON_BACK");
        return new ListCasesCommon(tool, test, user);
    }
}

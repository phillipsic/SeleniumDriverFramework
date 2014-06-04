/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewCaseCommon extends CommonMenu {

    public ViewCaseCommon(WebDriver driver) throws Exception {
        super(driver);
        String currentScreen = driver.getTitle();

        // Check that we're on the right page.
        if (!"View Case".equals(currentScreen)) {
            throw new IllegalStateException("Expecting: View Case, but got: " + currentScreen);
        }
    }

    public String getCaseType() throws Exception {
        String caseID = driver.findElement(By.xpath("//tr[7]/td/span[2]")).getText();
        return caseID;
    }

    public String getCaseStatus() throws Exception {
        String caseStatus = driver.findElement(By.xpath("//tr[4]/td/span[2]")).getText();
        return caseStatus;
    }

    public String getCaseJustificationStatus() throws Exception {
        String caseStatus = driver.findElement(By.xpath("//tr[6]/td/span[2]")).getText();
        return caseStatus;
    }

    public String getCaseProblemArea() throws Exception {
        String caseProblemArea = driver.findElement(By.xpath("//tr[8]/td/span[2]")).getText();
        return caseProblemArea;
    }

    public String getCaseDescription() throws Exception {
        String caseDescription = driver.findElement(By.xpath("//*[@id=\"description\"]")).getText();
        System.out.println("caseDescription : " + caseDescription);
        return caseDescription;
    }

    public String getNoteType() throws Exception {
        String noteType = driver.findElement(By.xpath("//table[@class='listTable']/tbody/tr[1]/td")).getText();
        
         System.out.println("noteType : " + noteType);
        return noteType;
    }

    public String getNoteDescription() throws Exception {
        String noteDesc = driver.findElement(By.name("noteDescription")).getText();
        System.out.println("noteDesc : " + noteDesc);
        return noteDesc;
    }

    public void clickNotesTab() throws Exception {
        driver.findElement(By.xpath("//em[contains(text(), 'Notes')]")).click();
    }

    public void clickAttachmentsTab() throws Exception {

        driver.findElement(By.xpath("//em[contains(text(), 'Attachments')]")).click();
    }

    public EditCaseCommon clickEditCase() throws Exception {
        driver.findElement(By.linkText("Edit Case")).click();
        return new EditCaseCommon(driver);
    }

    public CreateAttachmentCommon clickAddAttachment() throws Exception {
        driver.findElement(By.linkText("Add")).click();
        return new CreateAttachmentCommon(driver);
    }

    public EditCaseCommon clickReopen() throws Exception {
        driver.findElement(By.linkText("Reopen")).click();
        return new EditCaseCommon(driver);
    }

    public AccountDetailsCommon clickBack() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new AccountDetailsCommon(driver);
    }

    public ListCasesCommon clickBackExpectingListCases() throws Exception {
        driver.findElement(By.id("youcan_ON_BACK")).click();
        return new ListCasesCommon(driver);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ViewCaseCommon;

public class ViewCase extends ViewCaseCommon {

    public ViewCase(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public EditCase clickEditCase() throws Exception {
        super.clickEditCase();
        return new EditCase(driver);
    }

    @Override
    public CreateAttachment clickAddAttachment() throws Exception {
        super.clickAddAttachment();
        return new CreateAttachment(driver);
    }

}

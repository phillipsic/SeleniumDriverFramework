/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RemoveLevelCommon;

/**
 * 
 * @author Koushic
 */

public class RemoveLevel extends RemoveLevelCommon {

    public RemoveLevel(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public ViewHierarchy clickOk() throws Exception {

        super.clickOk();
        return new ViewHierarchy(driver);
    }

}

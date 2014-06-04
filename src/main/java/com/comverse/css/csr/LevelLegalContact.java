/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.LevelLegalContactCommon;

/**
 * 
 * @author iphilli
 */
public class LevelLegalContact extends LevelLegalContactCommon {

    public LevelLegalContact(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public ViewHierarchy clickBack() throws Exception {

        super.clickBack();
        return new ViewHierarchy(driver);
    }

    @Override
    public ModifyLevelLegalContact clickModifyLevelLegalContact() throws Exception {

        super.clickModifyLevelLegalContact();
        return new ModifyLevelLegalContact(driver);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.ModifyLevelLegalContactCommon;

/**
 * 
 * @author iphilli
 */
public class ModifyLevelLegalContact extends ModifyLevelLegalContactCommon {

    public ModifyLevelLegalContact(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public void setNewLevelName(String uniqueString) throws Exception {

        super.setNewLevelName(uniqueString);
    }

    @Override
    public void setNewLevelState(String uniqueState) throws Exception {

        super.setNewLevelState(uniqueState);
    }

    @Override
    public ModifyLevelLegalContact clickOk() throws Exception {

        super.clickOk();
        return new ModifyLevelLegalContact(driver);
    }

    @Override
    public ModifyLevelLegalContact clickOkAgain() throws Exception {

        super.clickOkAgain();
        return new ModifyLevelLegalContact(driver);
    }

    @Override
    public LevelLegalContact clickOkButton() throws Exception {

        super.clickOkButton();
        return new LevelLegalContact(driver);
    }
}

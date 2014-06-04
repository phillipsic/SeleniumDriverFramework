/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.MoveLevelCommon;

/**
 * 
 * @author Koushic
 */
public class MoveLevel extends MoveLevelCommon {

    public MoveLevel(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public MoveLevel clickSelectByLevelName(String weeklyLevelName) throws Exception {

        super.clickSelectByLevelName(weeklyLevelName);
        return new MoveLevel(driver);
    }

    @Override
    public ViewHierarchy clickHierarchy() throws Exception {

        super.clickHierarchy();
        return new ViewHierarchy(driver);
    }

    @Override
    public MoveLevel levelNameWithOutSelectLink(String weeklyLevelName) throws Exception {

        super.levelNameWithOutSelectLink(weeklyLevelName);
        return new MoveLevel(driver);
    }
}

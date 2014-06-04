/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.MoveMemberCommon;

/**
 * 
 * @author mkumar
 */
public class MoveMember extends MoveMemberCommon {

    public MoveMember(WebDriver driver) throws Exception {

        super(driver);

    }

    @Override
    public MoveMember clickSelectByLevelName(String levelName) throws Exception {

        super.clickSelectByLevelName(levelName);
        return new MoveMember(driver);
    }

    @Override
    public MoveMember findSelectByLevelName(String levelName) throws Exception {

        super.findSelectByLevelName(levelName);
        return new MoveMember(driver);
    }

    @Override
    public ContactInformation clickOk() throws Exception {

        super.clickOk();
        return new ContactInformation(driver);
    }

}

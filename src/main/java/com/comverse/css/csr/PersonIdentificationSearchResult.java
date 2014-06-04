/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.PersonIdentificationSearchResultCommon;

/**
 * 
 * @author iphilli
 */
public class PersonIdentificationSearchResult extends PersonIdentificationSearchResultCommon {

    public PersonIdentificationSearchResult(WebDriver driver) throws Exception {
        super(driver);

    }

    @Override
    public WorkSpace clickHome() throws Exception {
        super.clickHome();
        return new WorkSpace(driver);
    }
}

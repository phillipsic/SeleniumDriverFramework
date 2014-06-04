/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.WebDriver;

import com.comverse.css.commonpages.RemoveBasketCommon;
import org.openqa.selenium.By;

/**
 * 
 * @author iphilli
 */
public class RemoveBasket extends RemoveBasketCommon {

    public RemoveBasket(WebDriver driver) throws Exception {

        super(driver);

    }

   public WorkSpace clickYes() throws Exception {

        driver.findElement(By.xpath("//form[@id='form_YES']/div/input")).click();
        return new WorkSpace(driver);
    }
}

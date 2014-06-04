package com.comverse.common;

import org.openqa.selenium.By;

public class Tool extends Main {

    // public WebDriver driver;

    public Tool() {

        // super(driver);
    }

    public void clickUsingXPath(String xpath) throws Exception {

        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickUsingID(String id) throws Exception {

        driver.findElement(By.id(id)).click();
    }

    public void clickUsingName(String name) throws Exception {

        driver.findElement(By.name(name)).click();
    }

    public void clickUsingLinkText(String linkText) throws Exception {

        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickUsingCssSelector(String cssSelector) throws Exception {

        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void enterStringUsingId(String id, String data) throws Exception {

        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(data);
    }

}

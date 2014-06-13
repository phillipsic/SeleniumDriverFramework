package com.comverse.css.pos;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.AddressAddCommon;

public class AddressAdd extends AddressAddCommon {

    public AddressAdd(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.driver.getTitle();
        String expectedScreen = "Address Add";

        if (!expectedScreen.equals(tool.driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    @Override
	public void setStreetName(String streetname) throws Exception {

        tool.driver.findElement(By.id("streetName")).clear();
        tool.driver.findElement(By.id("streetName")).sendKeys(streetname);

    }

    @Override
	public void setCity(String city) throws Exception {

        tool.driver.findElement(By.id("city")).clear();
        tool.driver.findElement(By.id("city")).sendKeys(city);

    }

    @Override
	public void setZipCode(String zipcode) throws Exception {

        tool.driver.findElement(By.id("postalCode")).clear();
        tool.driver.findElement(By.id("postalCode")).sendKeys(zipcode);

    }

    @Override
	public void selectCountry(String country) throws Exception {

        new Select(tool.searchUsingID(tool, "countryCode")).selectByVisibleText(country);

    }

    @Override
	public AddressAdministration clickOK() throws Exception {

        tool.driver.findElement(By.xpath("//input[@value='Ok']")).click();

        return new AddressAdministration(tool, test, user);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.csr;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 *
 * @author gmaroth
 */
public class OutboundCommunicationTemplate {
    
    
    public void doAddTemplates() throws Exception {
           
      clickSearch();
      /*  String Temp1 = "Case-Case_Creation_Report-email-FR.jrxml";
 
       
       
       String text1 ;
       text1 = driver.findElement(By.xpath(".//div[contains(text(),'Case-Case_Creation_Report-email-FR.jrxml')]") ).get;
       
      if (Temp1.equals(driver.findElement(By.xpath(".//div[contains(text(),'Case-Case_Creation_Report-email-FR.jrxml')]") ))) {
            
            
            System.out.println("this is our loop it is entering in the loop");
        
                           
    }else {
       
           
       System.out.println("Temp1 " + Temp1); 
       System.out.println("this is our loop it is not entering in the loop");
       
       
     }
       */    
    }

    private void clickSearch() {
                
        driver.findElement(By.xpath(".//*[@id='OutboundCommTemplateSearchForm']/fieldset[2]/input[3]")).click();
    }

    public WebDriver driver;

    public OutboundCommunicationTemplate(WebDriver driver) {
        this.driver = driver;
        String currentScreen = driver.getTitle();
        String expectedScreen = "Outbound Communication Template";

        if (!expectedScreen.equals(driver.getTitle())) {

            throw new IllegalStateException("Expecting: " + expectedScreen + " , but got: " + currentScreen);
        }

    }

    public AddOutboundCommunicationTemplate clickAdd() throws Exception {

        driver.findElement(By.xpath("//input[@value='Add']")).click();
        return new AddOutboundCommunicationTemplate(driver);
    }

    public void clickBack() throws Exception {

        driver.findElement(By.xpath("//input[@value='Back']")).click();
    }
    
    
}

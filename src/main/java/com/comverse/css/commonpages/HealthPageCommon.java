/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class HealthPageCommon extends CommonMenu {

    public HealthPageCommon(AutomationTool tool, Test test, User user, String baseUrl) throws Exception {
        super(tool, test, user);

        System.out.println("baseUrl:" + baseUrl);

        tool.driver.get(baseUrl);

        boolean sapi = tool.getPageSource(tool).contains("SAPI Information");

        if (sapi == false) {
            throw new IllegalStateException("SAPI page is not available");
        } else {
            System.out.println("Sapi Page is Available");
        }

    }

    public boolean crmhealthcheck(String baseUrl, String Text) throws Exception {

        tool.driver.get(baseUrl);

        boolean crm = tool.getPageSource(tool).contains(Text);

        if (crm == true) {

            System.out.println("crmhealthcheck  FAILED - " + baseUrl);
        } else {

            System.out.println("crmhealthcheck  PASSED");

        }

        return crm;
    }

    public boolean rcsHealthCheck(String baseUrl, String Text) throws Exception {

        tool.driver.get(baseUrl);

        boolean rcs = tool.getPageSource(tool).contains(Text);

        if (rcs == true) {

            System.out.println("rcsHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("rcsHealthCheck  PASSED");

        }

        return rcs;
    }

    public boolean rhtHealthCheck(String baseUrl, String Text) throws Exception {

        tool.driver.get(baseUrl);

        boolean rht = tool.getPageSource(tool).contains(Text);

        if (rht == true) {

            System.out.println("rhtHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("rhtHealthCheck  PASSED");

        }
        return rht;
    }

    public boolean obcHealthcheck(String baseUrl, String Text) throws Exception {
        tool.driver.get(baseUrl);

        boolean OBC = tool.getPageSource(tool).contains(Text);

        if (OBC == true) {

            System.out.println("obcHealthcheck  FAILED - " + baseUrl);
        } else {

            System.out.println("obcHealthcheck  PASSED");

        }

        return OBC;

    }

    public boolean dbHealthCheck(String baseUrl, String Text) throws Exception {

        tool.driver.get(baseUrl);

        boolean db = tool.getPageSource(tool).contains(Text);

        if (db == true) {

            System.out.println("dbHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("dbHealthCheck  PASSED");

        }

        return db;
    }
}

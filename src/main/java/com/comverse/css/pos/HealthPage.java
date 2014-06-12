/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comverse.css.pos;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.commonpages.CommonMenu;

public class HealthPage extends CommonMenu {

    public HealthPage(AutomationTool tool, Test test, User user, String baseUrl) throws Exception {
        super(tool, test, user);

        System.out.println("baseUrl:" + baseUrl);

        tool.driver.get(baseUrl);

        boolean sapi = tool.driver.getPageSource().contains("SAPI Information");

        if (sapi == false) {

            throw new IllegalStateException("SAPI page is not available");

        } else {

            System.out.println("Sapi Page is Available");

        }

    }

    public boolean crmhealthcheck(String baseUrl, String Text) {

        tool.driver.get(baseUrl);

        boolean crm = tool.driver.getPageSource().contains(Text);

        if (crm == true) {

            System.out.println("crmhealthcheck  FAILED - " + baseUrl);
        } else {

            System.out.println("crmhealthcheck  PASSED");

        }

        return crm;
    }

    public boolean rcsHealthCheck(String baseUrl, String Text) {

        tool.driver.get(baseUrl);

        boolean rcs = tool.driver.getPageSource().contains(Text);

        if (rcs == true) {

            System.out.println("rcsHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("rcsHealthCheck  PASSED");

        }

        return rcs;
    }

    public boolean rhtHealthCheck(String baseUrl, String Text) {

        tool.driver.get(baseUrl);

        boolean rht = tool.driver.getPageSource().contains(Text);

        if (rht == true) {

            System.out.println("rhtHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("rhtHealthCheck  PASSED");

        }
        return rht;
    }

    public boolean obcHealthcheck(String baseUrl, String Text) {
        tool.driver.get(baseUrl);

        boolean OBC = tool.driver.getPageSource().contains(Text);

        if (OBC == true) {

            System.out.println("obcHealthcheck  FAILED - " + baseUrl);
        } else {

            System.out.println("obcHealthcheck  PASSED");

        }

        return OBC;

    }

    public boolean dbHealthCheck(String baseUrl, String Text) {

        tool.driver.get(baseUrl);

        boolean db = tool.driver.getPageSource().contains(Text);

        if (db == true) {

            System.out.println("dbHealthCheck  FAILED - " + baseUrl);
        } else {

            System.out.println("dbHealthCheck  PASSED");

        }

        return db;
    }
}

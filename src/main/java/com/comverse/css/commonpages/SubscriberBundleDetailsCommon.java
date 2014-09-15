package com.comverse.css.commonpages;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;
import com.comverse.css.common.Common;

public class SubscriberBundleDetailsCommon extends CommonMenu {

    public SubscriberBundleDetailsCommon(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectedScreen = "Subscriber Bundle Details";

        if (!expectedScreen.equals(tool.getTitle())) {

            throw new IllegalStateException("<<< Expecting: " + expectedScreen + " , but got: " + currentScreen + " >>>");
        }
    }

    public void checkOffer(String SUBSCRIBER_BUNDLE) throws Exception {
        Common.assertTextOnPage(tool, SUBSCRIBER_BUNDLE);
    }
}

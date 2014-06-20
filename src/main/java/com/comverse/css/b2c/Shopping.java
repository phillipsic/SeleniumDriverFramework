package com.comverse.css.b2c;

import com.comverse.common.AutomationTool;
import com.comverse.common.Test;
import com.comverse.common.User;

public class Shopping extends B2CMenu {

    public Shopping(AutomationTool tool, Test test, User user) throws Exception {
        super(tool, test, user);
        String currentScreen = tool.getTitle();
        String expectScreen = "Shopping";

        if (!expectScreen.equals(currentScreen)) {

            throw new IllegalStateException("Expecting: " + expectScreen + " , but got: " + currentScreen);
        }
    }

    public ChooseYourPrimaryOffer clickGSMMobileLink() throws Exception {

        tool.clickUsingXPath("//li[contains(.,'Welcome to a new world of convergence')]/img");
        tool.clickUsingLinkText("GSM Mobile");

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourPrimaryOffer clickNetworkTVLink() throws Exception {

        tool.clickUsingXPath("//li[contains(.,'Welcome to a new world of convergence')]/img");
        tool.clickUsingLinkText("Network TV");

        return new ChooseYourPrimaryOffer(tool, test, user);
    }

    public ChooseYourHandset clickVoiceDevicesLink() throws Exception {

        tool.clickUsingXPath("//li[contains(.,'Voice Items')]/img");
        tool.clickUsingLinkText("Voice Devices");

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseYourHandset clickDataDevicesLink() throws Exception {

        tool.clickUsingXPath("//li[contains(.,'Data Items')]/img");
        tool.clickUsingLinkText("Data Devices");

        return new ChooseYourHandset(tool, test, user);
    }

    public ChooseAccessories clickPhoneAccessoriesLink() throws Exception {

        tool.clickUsingXPath("//li[starts-with(.,'Accessories')]/img");
        tool.clickUsingLinkText("Phone Accessories");
        return new ChooseAccessories(tool, test, user);

    }

    public ChooseYourPrimaryOfferInThisAccountBundle clickFamilyPackLink() throws Exception {

        tool.clickUsingXPath("//li[contains(.,'Keep in touch with your family')]/img");
        tool.clickUsingLinkText("Family Pack");

        return new ChooseYourPrimaryOfferInThisAccountBundle(tool, test, user);
    }

    @Override
	public SubscriberDetail clickMyAccount() throws Exception {
        tool.clickUsingLinkText("My Account");
        return new SubscriberDetail(tool, test, user);
    }
}

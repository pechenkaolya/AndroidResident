package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewPosting {
    private static AppiumDriver<MobileElement> driver;

    public NewPosting(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

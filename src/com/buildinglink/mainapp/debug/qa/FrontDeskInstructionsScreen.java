package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FrontDeskInstructionsScreen {
    private static AppiumDriver<MobileElement> driver;

    public FrontDeskInstructionsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

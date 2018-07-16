package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewRepairRequest {
    private static AppiumDriver<MobileElement> driver;
    public NewRepairRequest(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

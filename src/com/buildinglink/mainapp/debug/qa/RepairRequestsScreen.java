package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RepairRequestsScreen {
    private static AppiumDriver<MobileElement> driver;

    public RepairRequestsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

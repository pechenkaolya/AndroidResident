package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RepairRequestCategories {
    private static AppiumDriver<MobileElement> driver;

    public RepairRequestCategories(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

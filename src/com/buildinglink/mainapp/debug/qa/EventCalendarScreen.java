package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class EventCalendarScreen {
    private static AppiumDriver<MobileElement> driver;

    public EventCalendarScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

package com.buildinglink.mainapp.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MyProfileScreen {
    private static AppiumDriver<MobileElement> driver;

    public MyProfileScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

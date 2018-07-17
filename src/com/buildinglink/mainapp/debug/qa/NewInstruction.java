package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewInstruction {
    private static AppiumDriver<MobileElement> driver;

    public NewInstruction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

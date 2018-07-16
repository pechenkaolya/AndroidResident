package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class FDITypes {
    private static AppiumDriver<MobileElement> driver;

    public FDITypes(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

}

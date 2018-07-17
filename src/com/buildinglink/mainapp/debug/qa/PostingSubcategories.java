package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PostingSubcategories {
    private static AppiumDriver<MobileElement> driver;

    public PostingSubcategories(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

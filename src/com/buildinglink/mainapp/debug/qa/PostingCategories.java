package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PostingCategories {
    private static AppiumDriver<MobileElement> driver;

    public PostingCategories(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

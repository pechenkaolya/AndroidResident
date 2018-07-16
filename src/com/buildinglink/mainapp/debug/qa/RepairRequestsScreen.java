package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;

public class RepairRequestsScreen {
    private static AppiumDriver<MobileElement> driver;
    public RepairRequestsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By title = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView");
    private By addButton = By.id("com.buildinglink.mainapp.debug.qa:id/menu_item_add");
    private By allRequests = By.className("android.widget.TextView");

}

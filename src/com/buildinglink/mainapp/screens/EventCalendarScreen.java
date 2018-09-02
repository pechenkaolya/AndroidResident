package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EventCalendarScreen {
    private static AppiumDriver<MobileElement> driver;
    public EventCalendarScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By date = By.id(Server.setEndpoint()+ ":id/calendarEventDate");

    public String getDate(){
        return driver.findElement(date).getText();
    }
}

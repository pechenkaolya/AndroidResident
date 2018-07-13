package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.Random;

import static com.buildinglink.mainapp.additionalClasses.RandomValueGenerator.generateRandomValue;

public class HomeScreen {

    private static AppiumDriver<MobileElement> driver;

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By allowPushNotificationsAllert = By.id("android:id/message");
    private By refreshButton = By.id("com.buildinglink.mainapp.debug.qa:id/action_refresh");
    private By okButton = By.id("android:id/button1");
    private By cancelButton = By.id("android:id/button2");
    private By allUpcomingEvents = By.id("com.buildinglink.mainapp:id/agendaDescriptionView");
    private By homeIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.TextView[1]");
    private By lifestyleIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.TextView[2]");
    private By greenPlusButton = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.ImageButton");
    private By contactsIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.TextView[3]");
    private By myProfileIcon = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.TextView[4]");
    private By repairRequestsButton = By.name("Repair Requests");

    public HomeScreen tapOnOkButton(){
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        driver.findElement(okButton).click();
        return this;
    }

    public HomeScreen tapOnCancelButton(){
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        driver.findElement(cancelButton).click();
        return this;
    }

    public HomeScreen tapRefreshButton(){
        driver.findElement(refreshButton).click();
        return this;
    }

    public HomeScreen tapHomeIcon(){
        driver.findElement(homeIcon).click();
        return this;
    }

    public HomeScreen tapRepairRequestsButton(){
        driver.findElement(repairRequestsButton).click();
        return this;
    }

    public RepairRequestsScreen openRepairRequestsModule (){
        this.tapRepairRequestsButton();
        return new RepairRequestsScreen(driver);
    }







}

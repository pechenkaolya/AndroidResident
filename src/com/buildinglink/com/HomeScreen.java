package com.buildinglink.com;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ActionSupplier;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.*;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.buildinglink.com.RandomValueGenerator.generateRandomValue;
import static junit.framework.TestCase.assertTrue;

public class HomeScreen {
    private static AppiumDriver<MobileElement> driver;
    WebDriverWait wait = new WebDriverWait(driver,120);

    @BeforeClass
    public static void setUp() {  //set up desired capabilities
        DesiredCapabilities caps = new	DesiredCapabilities();//To	create	an	object
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "00f1edb5378094e3"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "57daea9e9d064ab4"); //Tab 2
        //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.buildinglink.mainapp");//To specify the android app package
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.buildinglink.mainapp.login.view.viewcontrollers.activities.SplashActivity");//To specify the	activity which we want to launch
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

            driver.findElementById("com.buildinglink.mainapp:id/userNameView").sendKeys("tuser2");
            driver.findElementById("com.buildinglink.mainapp:id/passwordView").sendKeys("tuser2");
            driver.navigate().back();
            driver.findElementById("com.buildinglink.mainapp:id/loginButton").click();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void allowToSendPushNotifications() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
        driver.findElement(By.id("android:id/button1")).click();
    }
/*
    @Test
    public void openUpcomingEvent(){
        if(driver.findElementsById("com.buildinglink.mainapp:id/agendaDescriptionView").size()!=0){
            List<MobileElement> allUpcomingEvents = driver.findElementsById("com.buildinglink.mainapp:id/agendaDescriptionView");
            String titleOfEventOnHomeScreen = allUpcomingEvents.get(1).getText();
            allUpcomingEvents.get(1).click();
            List<MobileElement> allTextViewClassElements = driver.findElementsByClassName("android.widget.TextView");//get all elements with class Text View
            boolean isTitleExisted = false;

            for (MobileElement event : allTextViewClassElements) {
                if (event.getText().equals(titleOfEventOnHomeScreen))
                    isTitleExisted = true;
            }
            assertTrue(isTitleExisted);
            driver.navigate().back();
        }
    }
*/

    @Ignore
    @Test
    public void checkDeliveriesBadgesNumber(){
        try {
            //  driver.findElementByName("Deliveries");
            //  MobileElement repairRequestsIcon = driver.findElementByName("Repair Requests");

            List<MobileElement> allBadgesOnHomeScreen = driver.findElements(By.id("com.buildinglink.mainapp:id/indicatorView"));
            //  List<WebElement> list = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.imdb.mobile:id/label']"));

            if (allBadgesOnHomeScreen != null && !allBadgesOnHomeScreen.isEmpty()) {

                for (MobileElement badge : allBadgesOnHomeScreen) {
                    System.out.println(badge.getText());
                }

                /*MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"com.buildinglink.mainapp:id/indicatorView\")).scrollIntoView("
                                + "new UiSelector().className(\"android.view.ViewGroup\").instance(4))"));*/

                //Identify Elememt using Text
               /*
                MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"android.view.ViewGroup\")).setMaxSearchSwipes(5).scrollIntoView("
                                + "new UiSelector().resourceId(\"com.buildinglink.mainapp:id/indicatorView\")"));
                System.out.println(element.getLocation());
                //Perform the action on the element
                System.out.println(element.getText());
                */
                driver.findElementByAccessibilityId("com.buildinglink.mainapp:id/textLifestyle").click();
            }
        }
        catch(Exception e)
        {
            e.getMessage();
        }


    }


/*
    @AfterClass
    public static void close(){
        driver.closeApp();
    }
*/
}

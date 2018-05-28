package com.buildinglink.com;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeScreen {
    private static AppiumDriver<MobileElement> driver;
    WebDriverWait wait = new WebDriverWait(driver,120);


    @BeforeClass public static void setUp() {  //set up desired capabilities
        DesiredCapabilities caps = new	DesiredCapabilities();//To	create	an	object
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "00f1edb5378094e3"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.buildinglink.mainapp");//To	specify	the	android	app	package
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.buildinglink.mainapp.login.view.viewcontrollers.activities.SplashActivity");//To specify the	activity which	we	want to	launch
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

	@Test
    public void openUpcomingEvent(){
        //List getListOfEvents = driver.findElementsById("com.buildinglink.mainapp:id/agendaDescriptionView");
        try {
            List<MobileElement> allEvents = driver.findElementsById("com.buildinglink.mainapp:id/agendaDescriptionView");;
           /* System.out.println("Element Count - " + allEvents.size());
            for(MobileElement event : allEvents) {
                System.out.println("Text - " + event.getText());
            }*/
           String getTitleOfEvent = allEvents.get(1).getText();
            System.out.println("Title - " + getTitleOfEvent);
            allEvents.get(1).click();

          /*
            MobileElement getFirstEvent = driver.findElementById("com.buildinglink.mainapp:id/agendaDescriptionView");
            String firstEventText = getFirstEvent.getText();
            getFirstEvent.click();
            MobileElement getTitleOfOpenedEvent = driver.findElementById("com.buildinglink.mainapp:id/agendaDescriptionView");
            */
        }catch(Exception e){
            e.getMessage();
        }

       /// System.out.println(getListOfEvents.get(1).);
        //driver.findElementById("com.buildinglink.mainapp:id/loginButton").click();

    }
/*
    @AfterClass
    public static void close(){
        driver.closeApp();
    }
*/
}

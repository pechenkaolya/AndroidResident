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
    WebDriverWait wait = new WebDriverWait(driver,120);

    @BeforeClass
    public static void setUp() {  //set up desired capabilities
        DesiredCapabilities caps = new	DesiredCapabilities();//To	create	an	object
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "00f1edb5378094e3"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        //caps.setCapability(MobileCapabilityType.DEVICE_NAME, "57daea9e9d064ab4"); //Tab 2
        //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.buildinglink.mainapp.debug.qa"); //package of the qa build
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.buildinglink.mainapp.login.view.viewcontrollers.activities.SplashActivity");//To specify the	activity which we want to launch
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);

            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/userNameView").sendKeys("sotest");
            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/passwordView").sendKeys("666f4");
            driver.navigate().back();
            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/loginButton").click();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void allowToSendPushNotifications() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
        driver.findElement(By.id("android:id/button1")).click();
    }

    @Ignore
    @Test
    public void createRequestsViaGreenPlusButton(){
        MobileElement greenPlusButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.ImageButton");
        greenPlusButton.click();

        MobileElement submitRepairRequestButton = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/submitARepairRequest");
        submitRepairRequestButton.click();

        List<MobileElement> chooseCategory = driver.findElementsById("com.buildinglink.mainapp.debug.qa:id/categoryName");
        int countAllCategories = chooseCategory.size();
        Random random = new Random();
        int getRandomCategory = random.nextInt(countAllCategories);
        chooseCategory.get(getRandomCategory).click();

        MobileElement problemDescription = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/requestDescription");
        String problemDescriptionValue = "Green plus probDesc" + generateRandomValue(15,"string");
        problemDescription.sendKeys(problemDescriptionValue);
        driver.navigate().back();

        MobileElement contactPhone = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView("
                + "new UiSelector().resourceId(\"com.buildinglink.mainapp.debug.qa:id/phone\"))"));
        // driver.findElementById("com.buildinglink.mainapp:id/phone");
        contactPhone.clear();
        contactPhone.sendKeys(generateRandomValue(10,"numeral"));
        driver.navigate().back();

        MobileElement additionalEmail = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/email");
        String additionalEmailValue = generateRandomValue(6,"numString") + "@" + generateRandomValue(4,"numString") + ".com";
        additionalEmail.clear();
        additionalEmail.sendKeys(additionalEmailValue);
        driver.navigate().back();

        MobileElement saveButton = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/menu_save");
        saveButton.click();
    }

    @Test
    public void createInstructionViaGreenPlusButton(){
        MobileElement greenPlusButton = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup[2]/android.widget.ImageButton");
        greenPlusButton.click();

        MobileElement submitFDIButton = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/submitFdi");
        submitFDIButton.click();

        List<MobileElement> chooseType = driver.findElementsById("com.buildinglink.mainapp.debug.qa:id/typeName");
        int countAllTypes = chooseType.size();
        Random random = new Random();
        int getRandomType = random.nextInt(countAllTypes);
        chooseType.get(getRandomType).click();

        MobileElement instructions = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/instruction");
        String instructionsValue = "Green plus inst" + generateRandomValue(15,"string");
        instructions.sendKeys(instructionsValue);
        driver.navigate().back();

        MobileElement saveButton = driver.findElementById("com.buildinglink.mainapp.debug.qa:id/menu_item_save");
        saveButton.click();
    }

    @AfterClass
    public static void close(){
        driver.closeApp();
    }
}

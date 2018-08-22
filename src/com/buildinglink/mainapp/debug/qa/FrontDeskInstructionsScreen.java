package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class FrontDeskInstructionsScreen {
    private static AppiumDriver<MobileElement> driver;

    public FrontDeskInstructionsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By addButton = By.id("com.buildinglink.mainapp.debug.qa:id/menu_item_add");
    private By allInstructions = By.className("android.view.ViewGroup");
    private By instructionDescription = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.support.v7.widget.RecyclerView\")).scrollIntoView("
            + "new UiSelector().resourceId(\"com.buildinglink.mainapp.debug.qa:id/description\"))");
    private By editButton = By.id("com.buildinglink.mainapp.debug.qa:id/editButtonText");
    private By expireNowButton = By.id("com.buildinglink.mainapp.debug.qa:id/expireNowText");
    private By okButton = By.id("android:id/button1");

    public void tapAddButton(){
        driver.findElement(addButton).click();
    }

    public FrontDeskInstructionsScreen expandInstruction(){
        driver.findElement(instructionDescription).click();
        return this;
    }

    public void tapEditButton(){
        driver.findElement(editButton).click();
    }

    public FrontDeskInstructionsScreen tapExpireNowButton(){
        driver.findElement(expireNowButton).click();
        return this;
    }

    public FrontDeskInstructionsScreen tapOnOkButton(){
        driver.findElement(okButton);
        return this;
    }

}

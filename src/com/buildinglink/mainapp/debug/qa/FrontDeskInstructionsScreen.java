package com.buildinglink.mainapp.debug.qa;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Random;

public class FrontDeskInstructionsScreen {
    private static AppiumDriver<MobileElement> driver;

    public FrontDeskInstructionsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By addButton = By.id(Server.setEndpoint()+":id/menu_item_add");
    private By allInstructions = By.className("android.view.ViewGroup");
    private By instructionDescription = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.support.v7.widget.RecyclerView\")).scrollIntoView("
            + "new UiSelector().clickable(true).className(\"android.view.ViewGroup\"))");
    private By editButton = By.id(Server.setEndpoint()+":id/editButtonText");
    private By expireNowButton = By.id(Server.setEndpoint()+":id/expireNowText");
    private By okButton = By.id("android:id/button1");

    public void tapAddButton(){
        driver.findElement(addButton).click();
    }

    public FrontDeskInstructionsScreen expandInstruction(){
        int allInstructionsOnScreen = driver.findElements(instructionDescription).size();
        System.out.println(allInstructionsOnScreen);
        Random random = new Random();
        int getRandomNumber = random.nextInt(allInstructionsOnScreen);
        driver.findElements(instructionDescription).get(getRandomNumber).click();
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

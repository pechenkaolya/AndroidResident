package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import com.buildinglink.mainapp.prodBuild.RepairRequests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Random;

public class RepairRequestsScreen {
    private static AppiumDriver<MobileElement> driver;
    public RepairRequestsScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

    private By addButton = By.id(Server.setEndpoint()+":id/menu_item_add");
    private By allRequests = By.className("android.view.ViewGroup");
    private By requestDescription = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.support.v7.widget.RecyclerView\")).scrollIntoView("
            + "new UiSelector().clickable(true).className(\"android.view.ViewGroup\"))");
    private By editButton = By.id(Server.setEndpoint()+":id/editButton");
    private By activityLogButton = By.id(Server.setEndpoint()+":id/activityLogText");

    public NewRepairRequest tapAddButton(){
        driver.findElement(addButton).click();
        return new NewRepairRequest(driver);
    }

    public RepairRequestsScreen expandRequest(){
        int allRequestsOnScreen = driver.findElements(requestDescription).size();
        Random random = new Random();
        int getRandomNumber = random.nextInt(allRequestsOnScreen);
        driver.findElements(requestDescription).get(getRandomNumber).click();
        return this;
    }

    public EditRepairRequest tapEditButton(){
        driver.findElement(editButton).click();
        return new EditRepairRequest(driver);
    }

}

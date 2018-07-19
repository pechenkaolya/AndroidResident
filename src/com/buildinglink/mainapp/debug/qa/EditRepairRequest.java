package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.util.Random;

public class EditRepairRequest extends NewRepairRequest {
    //private static AppiumDriver<MobileElement> driver;

    public EditRepairRequest(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By statusField = By.id("com.buildinglink.mainapp.debug.qa:id/status");
    private By openStatus = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView");
    private By onHoldStatus = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView");
    private By closedStatus = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView");
    private By statusCheckedIndicator = By.id("com.buildinglink.mainapp.debug.qa:id/checkedIndicator");
    private By requestCategory = By.id(("com.buildinglink.mainapp.debug.qa:id/category"));

    public EditRepairRequest changeStatusfield() {
        this.getCurrentStatusInt();
        int statusIntToChange = this.getRandomStatusInt();
        driver.findElement(statusField).click();
        switch(statusIntToChange){
            case 0: driver.findElement(openStatus).click();
                break;
            case 1: driver.findElement(onHoldStatus).click();
                break;
            case 2: driver.findElement(closedStatus).click();
        }
        return this;
    }

    private int getCurrentStatusInt(){
        String currentStatus = driver.findElement(statusField).getText();
        int currentStatusInt = 0;
        switch(currentStatus){
            case "Open": currentStatusInt = 0;
                break;
            case "On Hold": currentStatusInt = 1;
                break;
            case "Closed": currentStatusInt = 2;
        }
        return currentStatusInt;
    }

    private int getRandomStatusInt(){
        Random random = new Random();
        int randomStatusInt = random.nextInt(2);
        if (getCurrentStatusInt()==randomStatusInt){
            if(getCurrentStatusInt()==0){
                randomStatusInt = 1;
            }
            if(getCurrentStatusInt()==1){
                randomStatusInt = 2;
            }
            if(getCurrentStatusInt()==2){
                randomStatusInt = 0;
            }
        }
        return randomStatusInt;
    }


}

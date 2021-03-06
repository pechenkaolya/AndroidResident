package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Random;

public class RepairRequestCategories {
    private static AppiumDriver<MobileElement> driver;

    public RepairRequestCategories(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By categoriesList = By.id(Server.setEndpoint()+":id/categoryName");

    public void selectCategory(){
        int countAllCategories = driver.findElements(categoriesList).size();
        Random random = new Random();
        int getRandomCategory = random.nextInt(countAllCategories);
        driver.findElements(categoriesList).get(getRandomCategory).click();
    }
}

package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Date;
import java.util.List;

public class NewInstruction {
    private static AppiumDriver<MobileElement> driver;

    public NewInstruction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By saveButton = By.id("com.buildinglink.mainapp.debug.qa:id/menu_item_save");
    private By instructionsField = By.id("com.buildinglink.mainapp.debug.qa:id/instruction");
    private By startDateField = By.id("com.buildinglink.mainapp.debug.qa:id/startDate");
    private By expiresField = By.id("com.buildinglink.mainapp.debug.qa:id/expires");
    private By error = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");

    public void tapSaveButton(){
        driver.findElement(saveButton).click();
    }

    public NewInstruction tapOkButton(){
        driver.findElement(okButton).click();
        return this;
    }

    public NewInstruction typeInstructions(String instructions){
        driver.findElement(instructionsField).sendKeys(instructions);
        driver.navigate().back();
        return this;
    }

    public NewInstruction typeStartDate(){
        //driver.findElement(startDateField).click();
        List<MobileElement> textFieldsList = driver.findElements(startDateField);
        int size = textFieldsList.size();
        textFieldsList.get(0).sendKeys("25");
        textFieldsList.get(1).sendKeys("Jul");
        textFieldsList.get(2).sendKeys("2018");
        this.tapOkButton();
        return this;
    }

    public NewInstruction typeExpires(){
        driver.findElement(expiresField);
        return this;
    }


}

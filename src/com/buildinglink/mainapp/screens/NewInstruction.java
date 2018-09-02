package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class NewInstruction {
    protected static AppiumDriver<MobileElement> driver;
    public NewInstruction(){};
    public NewInstruction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    protected By saveButton = By.id(Server.setEndpoint()+":id/menu_item_save");
    protected By instructionsField = By.id(Server.setEndpoint()+":id/instruction");
    private By startDateField = By.id(Server.setEndpoint()+":id/startDate");
    private By expiresField = By.id(Server.setEndpoint()+":id/expires");
    protected By error = By.id("android:id/message");
    protected By okButton = By.id("android:id/button1");
    protected By successMessage = By.id(Server.setEndpoint()+":id/snackbar_text");
    protected By saveWaiverButton = By.id(Server.setEndpoint()+":id/menu_item_submit");
    protected By waiverField = By.id(Server.setEndpoint()+":id/waiverEditText");
    protected By waiverCheckbox = By.id(Server.setEndpoint()+":id/waiverCheckBox");

    public void tapSaveButton(){
        driver.findElement(saveButton).click();
    }

    public String getErrorMessage(){
        String getError = driver.findElement(error).getText();
        this.tapOkButton();
        driver.navigate().back();
        return getError;
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

    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }

    private void tapSaveWaiverButton(){
        driver.findElement(saveWaiverButton).click();
    }

    private boolean checkIfWaiverPresents(){
        try{
            return driver.findElement(waiverField).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    private boolean checkIfWaiverCheckboxPresents(){
        try{
            return driver.findElement(waiverCheckbox).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public void acceptLiabilityWaiver(){
        if (this.checkIfWaiverPresents()){
            driver.findElement(waiverField).sendKeys("yes");
            this.tapSaveWaiverButton();
        }
        if (this.checkIfWaiverCheckboxPresents()){
            driver.findElement(waiverCheckbox).click();
            this.tapSaveWaiverButton();
        }
    }

}

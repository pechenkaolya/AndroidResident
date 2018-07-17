package com.buildinglink.mainapp.debug.qa;

import com.buildinglink.mainapp.additionalClasses.RandomValueGenerator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class NewRepairRequest {
    private static AppiumDriver<MobileElement> driver;
    public NewRepairRequest(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private By saveButton = By.id("com.buildinglink.mainapp.debug.qa:id/menu_save");
    private By problemDescriptionField = By.id("com.buildinglink.mainapp.debug.qa:id/requestDescription");
    private By entryInstructionsField = By.id("com.buildinglink.mainapp.debug.qa:id/entryInstructions");
    private By contactPhoneField = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView("
            + "new UiSelector().resourceId(\"com.buildinglink.mainapp.debug.qa:id/phone\"))");
    private By additionalEmailField = By.id("com.buildinglink.mainapp.debug.qa:id/email");
    private By error = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");
    private By successMessage = By.id("com.buildinglink.mainapp.debug.qa:id/snackbar_text");
    private By saveWaiverButton = By.id("com.buildinglink.mainapp.debug.qa:id/menu_item_submit");
    private By waiverField = By.id("com.buildinglink.mainapp.debug.qa:id/waiverEditText");
    private By waiverCheckbox = By.id("com.buildinglink.mainapp.debug.qa:id/waiverCheckBox");

    public void tapSaveButton(){
        driver.findElement(saveButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(error).getText();
    }

    public NewRepairRequest tapOnOkButton(){
        driver.findElement(okButton).click();
        return this;
    }

    public NewRepairRequest typeProblemDescription(String problemDescription) {
        driver.findElement(problemDescriptionField).sendKeys(problemDescription);
        driver.navigate().back();
        return this;
    }

    public NewRepairRequest typeEntryInstructions(String entryInstructions) {
        driver.findElement(entryInstructionsField).sendKeys(entryInstructions);
        driver.navigate().back();
        return this;
    }

    public NewRepairRequest typeContactPhone(String contactPhone) {
        driver.findElement(contactPhoneField).clear();
        driver.findElement(contactPhoneField).sendKeys(contactPhone);
        driver.navigate().back();
        return this;
    }

    public NewRepairRequest typeAdditionalEmail(String additionalEmail) {
        driver.findElement(additionalEmailField).clear();
        driver.findElement(additionalEmailField).sendKeys(additionalEmail);
        driver.navigate().back();
        return this;
    }

    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }

    public void tapSaveWaiverButton(){
        driver.findElement(saveWaiverButton).click();
    }

    public boolean checkIfWaiverPresents(){
        try{
            return driver.findElement(waiverField).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean checkIfWaiverCheckboxPresents(){
        try{
            return driver.findElement(waiverCheckbox).isDisplayed();
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public void acceptLiabilityWaiver(){
        if (this.checkIfWaiverPresents()== true){
            driver.findElement(waiverField).sendKeys("yes");
            this.tapSaveWaiverButton();
        }
        if (this.checkIfWaiverCheckboxPresents()== true){
            driver.findElement(waiverCheckbox).click();
            this.tapSaveWaiverButton();
        }
    }

}

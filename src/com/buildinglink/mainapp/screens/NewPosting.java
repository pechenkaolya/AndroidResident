package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.Random;

public class NewPosting {
    private static AppiumDriver<MobileElement> driver;

    public NewPosting(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By saveButton = By.id(Server.setEndpoint()+":id/save");
    private By titleField = By.id(Server.setEndpoint()+":id/postingTitle");
    private By priceField = By.id(Server.setEndpoint()+":id/postingSubjectPrice");
    private By descriptionField = By.id(Server.setEndpoint()+":id/postingSubjectDescription");
    private By relatedLinkField = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView("
            + "new UiSelector().text(\"RELATED LINK\"))");
    private By durationOfPostField = MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().className(\"android.view.ViewGroup\")).scrollIntoView("
            + "new UiSelector().textContains(\"DURATION OF POST\"))");
    private By error = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");
    private By successMessage = By.id(Server.setEndpoint()+":id/snackbar_text");
    private By maxDurationTitle = By.id(Server.setEndpoint()+":id/postDurationHeader");

    public void tapSaveButton(){
        driver.findElement(saveButton).click();
    }

    public String getErrorMessage(){
        return driver.findElement(error).getText();
    }

    public NewPosting tapOnOkButton(){
        driver.findElement(okButton).click();
        return this;
    }

    public NewPosting typeTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
        driver.navigate().back();
        return this;
    }

    public NewPosting typePrice(String price) {
        driver.findElement(priceField).sendKeys(price);
        driver.navigate().back();
        return this;
    }

    public NewPosting typeDescription(String description) {
        driver.findElement(descriptionField).sendKeys(description);
        driver.navigate().back();
        return this;
    }

    public NewPosting typeRelatedLink(String relatedLink) {
        driver.findElement(relatedLinkField).sendKeys(relatedLink);
        driver.navigate().back();
        return this;
    }

    public NewPosting typeDurationOfPost(String durationOfPost) {
        driver.findElement(durationOfPostField).clear();
        driver.findElement(durationOfPostField).sendKeys(durationOfPost);
        driver.navigate().back();
        return this;
    }

    public String generateRandomDuration(){
        Random random = new Random();
        int getRandomDuration = random.nextInt(getMaxDuration());
        return Integer.toString(getRandomDuration);
    }

    private int getMaxDuration(){
        String maxDuration = driver.findElement(maxDurationTitle).getText().replaceFirst(".*?(\\d+).*", "$1");
        return Integer.parseInt(maxDuration);
    }

    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }

}

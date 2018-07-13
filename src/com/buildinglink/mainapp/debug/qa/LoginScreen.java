package com.buildinglink.mainapp.debug.qa;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class LoginScreen {
    private static AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("com.buildinglink.mainapp.debug.qa:id/userNameView");
    private By passwordField = By.id("com.buildinglink.mainapp.debug.qa:id/passwordView");
    private By rememberMeCheckbox = By.id("com.buildinglink.mainapp.debug.qa:id/rememberMeCheckbox");
    private By forgotPasswordLink = By.id("com.buildinglink.mainapp.debug.qa:id/forgotLogin");
    private By enterButton = By.id("com.buildinglink.mainapp.debug.qa:id/loginButton");
    private By visitBuildinglinkLink = By.id("com.buildinglink.mainapp.debug.qa:id/aboutButton");
    private By commentsLink = By.id("com.buildinglink.mainapp.debug.qa:id/commentsButton");
    private By copyrightValue = By.id("com.buildinglink.mainapp.debug.qa:id/copyright");
    private By error = By.id("android:id/message");

    public void tapRememberMeCheckbox(){
        driver.findElement(rememberMeCheckbox).click();
    }

    public HomeScreen tapEnter(){
        driver.findElement(enterButton).click();
        return new HomeScreen(driver);
    }

    public LoginScreen typeUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginScreen typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomeScreen loginWithCorrectCreds(String username, String password) {
        this.typeUsernameField(username);
        this.typePasswordField(password);
        driver.navigate().back();
        this.tapEnter();
        return new HomeScreen(driver);
    }

    public LoginScreen loginWithInvalidCreds(String username, String password){
        this.typeUsernameField(username);
        this.typePasswordField(password);
        driver.navigate().back();
        this.tapEnter();
        return new LoginScreen(driver);
    }

    public String getCopyrightValue(){
        return driver.findElement(copyrightValue).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }




}

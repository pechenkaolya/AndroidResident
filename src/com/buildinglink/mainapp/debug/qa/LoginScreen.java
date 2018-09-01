package com.buildinglink.mainapp.debug.qa;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginScreen {
    private static AppiumDriver<MobileElement> driver;

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By usernameField = By.id(Server.setEndpoint()+":id/userNameView");
    private By passwordField = By.id(Server.setEndpoint()+":id/passwordView");
    private By rememberMeCheckbox = By.id(Server.setEndpoint()+":id/rememberMeCheckbox");
    private By forgotPasswordLink = By.id(Server.setEndpoint()+":id/forgotLogin");
    private By enterButton = By.id(Server.setEndpoint()+":id/loginButton");
    private By visitBuildinglinkLink = By.id(Server.setEndpoint()+":id/aboutButton");
    private By commentsLink = By.id(Server.setEndpoint()+":id/commentsButton");
    private By copyrightValue = By.id(Server.setEndpoint()+":id/copyright");
    private By error = By.id("android:id/message");
    private By okButton = By.id("android:id/button1");

    public LoginScreen tapRememberMeCheckbox(){
        driver.findElement(rememberMeCheckbox).click();
        return this;
    }

    private HomeScreen tapEnter(){
        driver.findElement(enterButton).click();
        return new HomeScreen(driver);
    }

    public String returnForgotPasswordLink(){
        driver.findElement(forgotPasswordLink).click();
        return driver.findElementById("com.android.chrome:id/url_bar").getText();
    }

    public String expectedForgotPasswordLink(){
        if (Server.setEndpoint()=="com.buildinglink.mainapp.debug.qa")
            return "https://webservices-live.blkqa.com/v2/global/login/forgotpassword.aspx";
        if (Server.setEndpoint()=="com.buildinglink.mainapp.debug.staging")
            return "staging.buildinglink.com/v2/global/login/forgotpassword.aspx";
        else return "https://buildinglink.com/v2/global/login/forgotpassword.aspx";
    }

    public String returnBuildinglinkLink(){
        driver.findElement(visitBuildinglinkLink).click();
        return driver.findElementById("com.android.chrome:id/url_bar").getText();
    }

    public String expectedBuildinglinkLink(){
        if (Server.setEndpoint()=="com.buildinglink.mainapp.debug.qa")
            return "https://webservices-live.blkqa.com";
        if (Server.setEndpoint()=="com.buildinglink.mainapp.debug.staging")
            return "staging.buildinglink.com";
        else return "https://buildinglink.com";
    }

    public LoginScreen openCommentsSuggestions (){
        driver.findElement(commentsLink).click();
        return this;
    }

    private LoginScreen typeUsernameField(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    private LoginScreen typePasswordField(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public HomeScreen loginWithValidCreds(String username, String password) {
        this.typeUsernameField(username);
        this.typePasswordField(password);
        driver.navigate().back();
        this.tapEnter();
        return new HomeScreen(driver);
    }

    public HomeScreen loginWithTestUser() {
        this.loginWithValidCreds("otest","testtest");
        return new HomeScreen(driver);
    }

    public LoginScreen loginWithInvalidCreds(String username, String password){
        this.typeUsernameField(username);
        this.typePasswordField(password);
        driver.navigate().back();
        this.tapEnter();
        return this;
    }

    public String getCopyrightValue(){
        return driver.findElement(copyrightValue).getText();
    }

    public String getErrorText(){
        WebDriverWait wait = new WebDriverWait(driver,120);
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        return driver.findElement(error).getText();
    }

    public LoginScreen tapOnOkButton(){
        driver.findElement(okButton).click();
        return this;
    }
}
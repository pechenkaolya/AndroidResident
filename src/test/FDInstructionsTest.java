package test;

import com.buildinglink.mainapp.additionalClasses.DeviceDesiredCapabilities;
import com.buildinglink.mainapp.additionalClasses.RandomValueGenerator;
import com.buildinglink.mainapp.debug.qa.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class FDInstructionsTest {
    private static AppiumDriver<MobileElement> driver;
    private HomeScreen homeScreen = new HomeScreen(driver);
    private FrontDeskInstructionsScreen fdInstructionsScreen = new FrontDeskInstructionsScreen(driver);
    private FDITypes fdiTypes = new FDITypes(driver);
    private NewInstruction newInstruction = new NewInstruction(driver);

    @BeforeClass
    public static void setUp() {
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), DeviceDesiredCapabilities.setUpNexus5X());

            LoginScreen loginScreen = new LoginScreen(driver);
            loginScreen.loginWithTestUser();

            WebDriverWait wait = new WebDriverWait(driver,20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle"))); //wait till BuildingLink Push Notifications popup appears

            HomeScreen homeScreen = new HomeScreen(driver);
            homeScreen.tapOnOkButton();

        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addNewInstruction(){
        homeScreen.openFDInstructionsModule();
        fdInstructionsScreen.tapAddButton();
        fdiTypes.selectType();
        newInstruction.typeInstructions("NewInstr"+RandomValueGenerator.generateRandomValue(10, "string"))
                      .tapSaveButton();
        newInstruction.acceptLiabilityWaiver();
        Assert.assertEquals("Your instruction has been saved", newInstruction.getSuccessMessage());
    }

    @Test
    public void checkEmptyInstructionField(){
        homeScreen.openFDInstructionsModule();
        fdInstructionsScreen.tapAddButton();
        fdiTypes.selectType();
        newInstruction.getErrorMessage();
        Assert.assertEquals("You must enter an instruction", newInstruction.getErrorMessage());
    }

    @AfterClass
    public static void close() {
        driver.closeApp();
    }

}

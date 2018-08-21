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

public class RepairRequestsTest {
    private static AppiumDriver<MobileElement> driver;
    private HomeScreen homeScreen = new HomeScreen(driver);
    private RepairRequestCategories repairRequestCategories = new RepairRequestCategories(driver);
    private NewRepairRequest newRepairRequest = new NewRepairRequest(driver);
    private RepairRequestsScreen repairRequestsScreen = new RepairRequestsScreen(driver);
    private EditRepairRequest editRepairRequest = new EditRepairRequest(driver);

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
    public void addNewRequest(){
        homeScreen.openRepairRequestsModule();
        repairRequestsScreen.tapAddButton();
        repairRequestCategories.selectCategory();
        newRepairRequest.typeProblemDescription("NewDesc" + RandomValueGenerator.generateRandomValue(10,"string"))
                        .typeEntryInstructions("EntryInst" + RandomValueGenerator.generateRandomValue(10,"string"))
                        .typeContactPhone(RandomValueGenerator.generateRandomValue(10,"numeral"))
                        .typeAdditionalEmail(RandomValueGenerator.generateRandomValue(10,"numString") + "@"+RandomValueGenerator.generateRandomValue(10,"numString")+".com")
                        .tapSaveButton();
        newRepairRequest.acceptLiabilityWaiver();
        Assert.assertEquals("Your request has been saved", newRepairRequest.getSuccessMessage());
    }

    @Test
    public void checkEmptyDescription(){
        homeScreen.openRepairRequestsModule();
        repairRequestsScreen.tapAddButton();
        repairRequestCategories.selectCategory();
        newRepairRequest.tapSaveButton();
        Assert.assertEquals("You must enter a description", newRepairRequest.getErrorMessage());
    }

    @Test
    public void editRequest(){
        homeScreen.openRepairRequestsModule();
        repairRequestsScreen.expandRequest()
                            .tapEditButton();
        editRepairRequest.changeStatusToRandom()
                         .tapRequestCategoryField();
        repairRequestCategories.selectCategory();
        editRepairRequest.typeProblemDescription("Updated desc" + RandomValueGenerator.generateRandomValue(5,"numString"))
                         .typeEntryInstructions("Updated EI" + RandomValueGenerator.generateRandomValue(10,"string"))
                         .typeContactPhone(RandomValueGenerator.generateRandomValue(10,"numeral"))
                         .typeAdditionalEmail(RandomValueGenerator.generateRandomValue(10,"numString") + "@" +RandomValueGenerator.generateRandomValue(10,"numString")+".com")
                         .tapSaveButton();
        editRepairRequest.acceptLiabilityWaiver();
        Assert.assertEquals("Your request has been saved", editRepairRequest.getSuccessMessage());
    }

    @Test
    public void closeRequest(){
        homeScreen.openRepairRequestsModule();
        repairRequestsScreen.expandRequest()
                            .tapEditButton();
        editRepairRequest.changeStatusToClosed()
                         .tapSaveButton();
        editRepairRequest.acceptLiabilityWaiver();
        Assert.assertEquals("Your request has been saved", editRepairRequest.getSuccessMessage());
    }

    @AfterClass
    public static void close() {
        driver.closeApp();
    }

}

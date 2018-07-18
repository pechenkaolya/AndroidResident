package test;

import com.buildinglink.mainapp.additionalClasses.RandomValueGenerator;
import com.buildinglink.mainapp.debug.qa.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class HomeScreenTest {
    private static AppiumDriver<MobileElement> driver;
    private HomeScreen homeScreen = new HomeScreen(driver);
    private RepairRequestCategories repairRequestCategories = new RepairRequestCategories(driver);
    private NewRepairRequest newRepairRequest = new NewRepairRequest(driver);
    private FDITypes fdiTypes = new FDITypes(driver);
    private NewInstruction newInstruction = new NewInstruction(driver);
    private PostingCategories postingCategories = new PostingCategories(driver);
    private PostingSubcategories postingSubcategories = new PostingSubcategories(driver);
    private NewPosting newPosting = new NewPosting(driver);

    @BeforeClass
    public static void setUp() {  //set up desired capabilities
        DesiredCapabilities caps = new	DesiredCapabilities();//To	create	an	object
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "00f1edb5378094e3"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0"); //Android-057
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.buildinglink.mainapp.debug.qa"); //package of the qa build
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.buildinglink.mainapp.login.view.viewcontrollers.activities.SplashActivity");//To specify the	activity which we want to launch
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/userNameView").sendKeys("sotest");
            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/passwordView").sendKeys("666f4");
            driver.navigate().back();
            driver.findElementById("com.buildinglink.mainapp.debug.qa:id/loginButton").click();
            WebDriverWait wait = new WebDriverWait(driver,120);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/alertTitle")));
            driver.findElement(By.id("android:id/button1")).click();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void openUpcomingEvent(){
        homeScreen.openUpcomingEvent();
        driver.navigate().back();
        //need to add Assert method
    }

    @Test
    public void addRequestViaGreenPlusButton(){
        homeScreen.tapGreenPlusButton();
        homeScreen.tapSubmitRepairRequestButton();
        repairRequestCategories.selectCategory();
        newRepairRequest.typeProblemDescription("ProblemDesc"+ RandomValueGenerator.generateRandomValue(15, "numString"));
        newRepairRequest.typeEntryInstructions("EntryInst" + RandomValueGenerator.generateRandomValue(15, "numString"));
        newRepairRequest.typeContactPhone(RandomValueGenerator.generateRandomValue(13,"numeral"));
        newRepairRequest.typeAdditionalEmail(RandomValueGenerator.generateRandomValue(10,"numString")+"@"+RandomValueGenerator.generateRandomValue(10,"string")+".com");
        newRepairRequest.tapSaveButton();
        newRepairRequest.acceptLiabilityWaiver();
        Assert.assertEquals("Your request has been saved", newRepairRequest.getSuccessMessage());
    }

    @Test
    public void addInstructionViaGreenPlusButton(){
        homeScreen.tapGreenPlusButton();
        homeScreen.tapSubmitFDIButton();
        fdiTypes.selectType();
        newInstruction.typeInstructions("Instr" + RandomValueGenerator.generateRandomValue(15,"string"));
        newInstruction.tapSaveButton();
        newInstruction.acceptLiabilityWaiver();
        Assert.assertEquals("Your instruction has been saved", newInstruction.getSuccessMessage());
    }

    @Test
    public void addPostingViaGreenPlusButton(){
        homeScreen.tapGreenPlusButton();
        homeScreen.tapPostToBulletinBoardButton();
        postingCategories.selectCategory();
        postingSubcategories.selectSubcategory();
        newPosting.typeTitle("Title" + RandomValueGenerator.generateRandomValue(5, "string"));
        newPosting.typePrice(RandomValueGenerator.generateRandomValue(1000));
        newPosting.typeDescription("Desc"+RandomValueGenerator.generateRandomValue(12,"numString"));
        newPosting.typeRelatedLink(RandomValueGenerator.generateRandomValue(10,"string") + ".com");
        newPosting.typeDurationOfPost(newPosting.generateRandomDuration());
        newPosting.tapSaveButton();
        Assert.assertEquals("Your post has been saved", newPosting.getSuccessMessage());
    }

    @AfterClass
    public static void close() {
        driver.closeApp();
    }
}

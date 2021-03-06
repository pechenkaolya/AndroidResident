package test;

import com.buildinglink.mainapp.common.DeviceDesiredCapabilities;
import com.buildinglink.mainapp.common.RandomValueGenerator;
import com.buildinglink.mainapp.screens.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.*;

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
    public static void setUp() {
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), DeviceDesiredCapabilities.setUpDevice());
            LoginScreen loginScreen = new LoginScreen(driver);
            loginScreen.loginWithTestUser();
            HomeScreen homeScreen = new HomeScreen(driver);
            homeScreen.tapOnOkButton();
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
        homeScreen.tapGreenPlusButton()
                .tapSubmitRepairRequestButton();
        repairRequestCategories.selectCategory();
        newRepairRequest.typeProblemDescription("AddedViaGreenDesc"+ RandomValueGenerator.generateRandomValue(15, "numString"))
                .typeEntryInstructions("EntryInst" + RandomValueGenerator.generateRandomValue(15, "numString"))
                .typeContactPhone(RandomValueGenerator.generateRandomValue(13,"numeral"))
                .typeAdditionalEmail(RandomValueGenerator.generateRandomValue(10,"numString")+"@"+RandomValueGenerator.generateRandomValue(10,"string")+".com")
                .tapSaveButton();
        newRepairRequest.acceptLiabilityWaiver();
        Assert.assertEquals("Your request has been saved", newRepairRequest.getSuccessMessage());
    }

    @Test
    public void addInstructionViaGreenPlusButton(){
        homeScreen.tapGreenPlusButton()
                .tapSubmitFDIButton();
        fdiTypes.selectType();
        newInstruction.typeInstructions("AddedViaGreenInstr" + RandomValueGenerator.generateRandomValue(15,"string"))
                .tapSaveButton();
        newInstruction.acceptLiabilityWaiver();
        Assert.assertEquals("Your instruction has been saved", newInstruction.getSuccessMessage());
    }

    @Test
    public void addPostingViaGreenPlusButton(){
        homeScreen.tapGreenPlusButton()
                .tapPostToBulletinBoardButton();
        postingCategories.selectCategory();
        postingSubcategories.selectSubcategory();
        newPosting.typeTitle("Title" + RandomValueGenerator.generateRandomValue(5, "string"))
                .typePrice(RandomValueGenerator.generateRandomValue(1000))
                .typeDescription("AddedViaGreenDesc"+RandomValueGenerator.generateRandomValue(12,"numString"));
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

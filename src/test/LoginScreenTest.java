package test;

import com.buildinglink.mainapp.common.DeviceDesiredCapabilities;
import com.buildinglink.mainapp.common.RandomValueGenerator;
import com.buildinglink.mainapp.debug.qa.LoginScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.*;
import java.net.URL;
import java.time.Year;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginScreenTest {
    private static AppiumDriver<MobileElement> driver;
    private LoginScreen loginScreen = new LoginScreen(driver);

    @BeforeClass
    public static void setUp() {
        try {
            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), DeviceDesiredCapabilities.setUpNexus5X());
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkYearInCopyright(){
        int currentYear = Year.now().getValue();
        assertTrue(loginScreen.getCopyrightValue().contains(Integer.toString(currentYear)));
    }

    @Test
    public void checkForgotPasswordLink(){
        assertEquals("https://webservices-live.blkqa.com/v2/global/login/forgotpassword.aspx", loginScreen.openForgotPasswordLink());
        driver.navigate().back();
    }

    @Test
    public void checkBuildinglinkLink(){
        assertTrue(loginScreen.openBuildinglinkLink().contains("https://webservices-live.blkqa.com"));
        driver.navigate().back();
    }

    @Test
    @Ignore //flaky test
    public void openCommentsSuggestionsLink(){
        loginScreen.openCommentsSuggestions();
        driver.navigate().back();
        //need to add Assert
    }

    @Test
    public void loginWithInvalidCredentials(){
        loginScreen.loginWithInvalidCreds(RandomValueGenerator.generateRandomValue(10, "numString"), RandomValueGenerator.generateRandomValue(10, "numString"));
        Assert.assertEquals("Username or password is incorrect",loginScreen.getErrorText());
        loginScreen.tapOnOkButton();
    }

    @Test
    public void loginAsFrontDeskStaff(){
        loginScreen.loginWithInvalidCreds("tfrontdesk1", "testtest");
        Assert.assertEquals("This app is restricted to residents",loginScreen.getErrorText());
        loginScreen.tapOnOkButton();
    }

    @Test
    public void loginAsMaintenanceStaff(){
        loginScreen.loginWithInvalidCreds("blmaintenance", "testtest");
        Assert.assertEquals("This app is restricted to residents",loginScreen.getErrorText());
        loginScreen.tapOnOkButton();
    }

    @Test
    public void loginAsCarValet(){
        loginScreen.loginWithInvalidCreds("tcarv", "testtest");
        Assert.assertEquals("This app is restricted to residents",loginScreen.getErrorText());
        loginScreen.tapOnOkButton();
    }

    @Test
   // @Ignore
    public void checkRememberMeSwitchedOff() {
        loginScreen.tapRememberMeCheckbox()
                   .loginWithCorrectCreds("otest","testtest");
        //need to add Assert
    }

    @AfterClass
    public static void close() {
        driver.closeApp();
    }

}

import Pages.BasePage;
import Pages.ContactUsPage;
import Pages.LoginScreen;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginScreenTest extends UseCaseBase {
    private static MainPage mainPage;
    private static LoginScreen loginScreen;

    @BeforeAll
    public static void classSetup() {
        mainPage = new MainPage();
        loginScreen = new LoginScreen();
    }

    @BeforeEach
    public void beforeTest() {
        mainPage.navigateToLoginPage();
    }

    @Test
    public void loginScreenOpenTest() {
        Boolean isOpened = loginScreen.openLoginScreen().isScreenOpened();
        assertTrue(isOpened);
    }

    @Test
    public void loginNegativeTestEmpty() {
        Boolean isRobot = loginScreen.openLoginScreen().fillForm("", "").clickSignInButton().isImNotRobotOpen();
        assertTrue(isRobot);
    }

    @Test
    public void loginNegativeTestIncorrect() {
        loginScreen.openLoginScreen().fillForm("capitanJackVorobey.com", "A").clickSignInButton();
        mainPage.takesScreenshot("LoginScreenTest");

        String actualURL = loginScreen.checkIfNotSignUp();
        String expectedURL = "https://kidkiddos.com/account/login";
        assertEquals(actualURL, expectedURL);

    }
}


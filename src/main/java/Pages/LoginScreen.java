package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginScreen extends BasePage {
    private static final String ICON_LOGIN = "//a[@href='/account/login']";
    private static final String email = "//input[@id='CustomerEmail']";
    private static final String password = "//input[@id='CustomerPassword']";
    private static final String signInButton = "//input[@value ='Sign In']";

    private static final String errorMessage = "//*[contains(text(),'To continue')]";


    public boolean isScreenOpened() {
        return elementExists(ICON_LOGIN);

    }

    public LoginScreen openLoginScreen() {
        clickElementByXpath(ICON_LOGIN);
        return new LoginScreen();
    }


    public LoginScreen fillForm(String EMAIL, String PASS) {

        findElementByXpath(email).sendKeys(EMAIL);
        findElementByXpath(password).sendKeys(PASS);
        return new LoginScreen();
    }

    public LoginScreen clickSignInButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(signInButton)));
        clickElementByXpath(signInButton);
        return new LoginScreen();

    }

    public static boolean isImNotRobotOpen() {
        findElementByXpath(errorMessage);
        return true;
    }

    public String checkIfNotSignUp() {
        String actualURL = webDriver.getCurrentUrl();

        return actualURL;

    }
}


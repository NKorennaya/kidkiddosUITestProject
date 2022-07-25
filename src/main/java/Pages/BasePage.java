package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, 5);

    }

    protected static void clickElementByXpath(String xpath) {
        logger.info("Clicking element with xpath: " + xpath);
        findElementByXpath(xpath).click();
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }

    protected static boolean elementExists(String xpath) {
        try {
            //   findElementByXpath(xpath);
            logger.info("Checking element with  exists" +
                    ": " + xpath);


            webDriver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception err) {


            return false;
        }

    }

    protected static WebElement findElementByXpath(String xpath) {
        WebElement element;
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        element = webDriver.findElement(By.xpath(xpath));
        return element;
    }

    protected static String getCurrentPageUrl() {
        return webDriver.getCurrentUrl();

    }

    protected static WebElement moveToElement(String xpath) {
        WebElement element;
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        element = webDriver.findElement(By.xpath(xpath));
        element.click();
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        return element;
   }

    public void takesScreenshot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("Screenshorts/" + name + ".jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


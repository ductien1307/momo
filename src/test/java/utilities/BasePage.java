package utilities;

import com.google.common.collect.ImmutableMap;
import constant.Xpath;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);
    public WebDriverWait wait;
    public static AppiumDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 20);
    }


    public boolean elementDisplayed(String text) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if (strage.contains("id")){
//            return driver.findElementByAccessibilityId(text).isDisplayed();
//        }
//        else
//        return driver.findElement(MobileBy.iOSNsPredicateString()).isDisplayed();
        return driver.findElementByAccessibilityId(text).isDisplayed();
    }

    public String getTextOf(MobileElement element) {
        /*logger.info("get text of OS: " + os);
        waitUntilElementVisiable(element);
        String value = null;
        if (os.contains("android")) {
            value = element.getText();
        } else value = element.getAttribute("label");

        logger.info("text of element " + element + " is:" + value);
        return value;*/
        return null;

    }


    public void scrollToElementIos(MobileElement parent, String label) {
        Map<String, Object> args = new HashMap<>();
        args.put("element", parent.getId());
//        args.put("predicateString", "label == \"" + label + "\"");
        String value = "label == \"%s\"";
        args.put("predicateString", String.format(value, label));
        args.put("toVisible", true);
        args.put("direction", "down");
        driver.executeScript("mobile: scroll", args);
    }

    public void enterKey() {
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
    }

    public void backKey() {
        driver.navigate().back();
    }

    public String xPathDynamic(String expected) {
        return String.format(Xpath.XPATH_BY_TEXT, expected);
    }

    public String xPathDynamic(String expected, String locator) {
        return String.format(locator, expected);
    }

    private void waitElementClickAble(String locator) {
        MobileElement element = (MobileElement) driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitElementVisibility(String locator) {
        MobileElement element = (MobileElement) driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementPresence(String locator) {
        List<MobileElement> button = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)))
                .stream()
                .map(element -> (MobileElement) element)
                .collect(Collectors.toList());
    }

    public void typeTextTo(String locator, String text) throws InterruptedException {
        sleep(2);
        MobileElement element = (MobileElement) driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void clickOn(String locator) throws InterruptedException {
        sleep(8);
        waitElementClickAble(locator);
        waitElementVisibility(locator);
        //waitElementPresence(locator);
        MobileElement element = (MobileElement) driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sleep(int second) throws InterruptedException {
        Thread.sleep(second * 1000);
    }

    public void launchActivity(String appPackage, String appActivity) {
        ((AndroidDriver) driver).startActivity(new Activity(appPackage, appActivity));
    }

    public void printInfoElements(String locator) {
        List<WebElement> childElements = driver.findElements(By.xpath(locator));
        logger.info("Size:" + childElements.size());
        for (int i = 0; i < childElements.size(); i++) {
            logger.info(i + ":" + childElements.get(i).getText());
        }
    }

    public void verticalScrolling(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        // int anchor = (int) (size.width /2);
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(anchor, endPoint))
                .release()
                .perform();
    }

    public boolean showKeyboard() {
        String command = "adb -s input keyevent KEYCODE_SEARCH";
        try {
            Process result = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BUTTON_1));
        //driver.executeScript("",ImmutableMap.of("name","home"));
        //driver.sendKeyEvent(66);
        boolean isDisplayed = ((AndroidDriver) driver).isKeyboardShown();
        return isDisplayed;
    }

}

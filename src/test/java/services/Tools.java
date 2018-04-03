package services;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static io.appium.java_client.touch.offset.PointOption.point;


public class Tools {
    private static AndroidDriver driver;

    public static void setDriver(AndroidDriver driver) {
        Tools.driver = driver;
    }

    public static void swipeElements(WebElement startEl, WebElement endEl) {
        Point locStart = startEl.getLocation();
        Point locEnd = endEl.getLocation();
        new TouchAction(driver).longPress(point(locStart.x, locStart.y)).moveTo(point(locEnd.x, locEnd.y)).release().perform();
    }

    public static void swipeByCoordinates(Integer startX, Integer startY, Integer endX, Integer endY) {
        new TouchAction(driver).longPress(point(startX, startY)).moveTo(point(endX,endY)).release().perform();
    }

    public static void waitForElementDisplayed(WebElement element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickIfElemPresent(List<MobileElement> elements) {
        if (elements.size() != 0) {
            elements.get(0).click();
        }
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }

}

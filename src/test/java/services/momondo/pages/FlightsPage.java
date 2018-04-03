package services.momondo.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import services.Tools;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.CHAIN;


public class FlightsPage {

    private final AndroidDriver driver;

    public FlightsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
    }

    @HowToUseLocators(androidAutomation = CHAIN)
    @AndroidFindBys({
            @AndroidBy(id = "toggleButton1"),
            @AndroidBy(className = "android.widget.TextView")
    })
    private MobileElement oneWayFlight;


    public void goToFlightsSection() {
        Tools.swipeRightToLeft(845,370, 122, 382);
        Tools.waitForElementDisplayed(oneWayFlight);
        oneWayFlight.click();
    }

    public void selectFlights() {
        System.out.println("In flights section");
    }




}




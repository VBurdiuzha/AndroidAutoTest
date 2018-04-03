package services.momondo.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.*;
import services.momondo.MomondoVars;
import org.openqa.selenium.support.PageFactory;
import services.Tools;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.pagefactory.LocatorGroupStrategy.CHAIN;


public class LoginPage {

    private final AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
    }


    @WithTimeout(time = 15, unit = TimeUnit.SECONDS)
    @AndroidFindBy(id = "tabProfile")
    private MobileElement userProfile;

    @AndroidFindBy(id = "profileMenuHeader")
    private MobileElement profileHandler;

    @AndroidFindBy(id = "connectWithEmailButton")
    private MobileElement emailLoginBotton;

    @AndroidFindBy(id = "emailEditText")
    private MobileElement emailField;

    @AndroidFindBy(id = "passwordEditText")
    private MobileElement passwordField;

    @AndroidFindBy(id = "connectWithEmailButton")
    private MobileElement loginButton;

    @AndroidFindBy(id = "textinput_error")
    private MobileElement textInputError;

    @AndroidFindBy(id = "profileMenuHeader")
    private MobileElement profileMenu;

    @AndroidFindBy(accessibility = "Navigate up")
    private List<MobileElement> closeMessageBtn;

    @HowToUseLocators(androidAutomation = CHAIN)
    @AndroidFindBys({
            @AndroidBy(id = "toggleButton1"),
            @AndroidBy(className = "android.widget.TextView")
            })
    private MobileElement oneWayFlight;


    public void openLoginPage() {
        userProfile.click();
        profileHandler.click();
        emailLoginBotton.click();
        Tools.waitForElementDisplayed(emailField);
        emailField.sendKeys(MomondoVars.email);
    }

    private void login(String pwd) {
        passwordField.sendKeys(pwd);
        loginButton.click();
    }

    public void successLogin() {
        passwordField.clear();
        login(MomondoVars.password);
        if (closeMessageBtn.size() != 0) {
            closeMessageBtn.get(0).click();
        }
        Tools.waitForElementDisplayed(profileMenu);
    }

    public void failureLogin() {
        login(MomondoVars.wrongPassword);
        Assert.assertTrue(textInputError.getText().length() != 0);

    }


}




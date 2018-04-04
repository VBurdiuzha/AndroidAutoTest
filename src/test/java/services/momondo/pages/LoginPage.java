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
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "tabProfile")
    private MobileElement userProfile;

    @AndroidFindBy(id = "connectWithEmailButton")
    private MobileElement emailLoginButton;

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
    private MobileElement navigateUpBtn;

    @AndroidFindBy(id = "welcomeImageView")
    private List<MobileElement> welcomeTitle;

    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
    @HowToUseLocators(androidAutomation = CHAIN)
    @AndroidFindBys({
            @AndroidBy(id = "profileMenuHeader"),
            @AndroidBy(id = "medallionTitle")
    })
    private MobileElement userNameTitle;


    public void openLoginPage() {
        userProfile.click();
        profileMenu.click();
        emailLoginButton.click();
        Tools.waitForElementDisplayed(emailField);
        emailField.sendKeys(MomondoVars.EMAIL);
    }

    private void login(String pwd) {
        passwordField.sendKeys(pwd);
        loginButton.click();
    }

    public void successLogin() {
        passwordField.clear();
        login(MomondoVars.PASSWORD);
        if (Tools.elementsArePresent(welcomeTitle)) {
            navigateUpBtn.click();
        }
        Tools.waitForElementDisplayed(profileMenu);
        Assert.assertEquals(userNameTitle.getText(), MomondoVars.EMAIL);

    }

    public void failureLogin() {
        login(MomondoVars.WRONG_PASSWORD);
        Assert.assertTrue(textInputError.getText().length() != 0);
    }


}





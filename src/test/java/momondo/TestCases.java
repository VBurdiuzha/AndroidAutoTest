package momondo;


import momondo.pages.FlightsPage;
import momondo.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestCases extends AppiumTestBase{
    private LoginPage loginPage;
    private FlightsPage flightsPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
        loginPage = new LoginPage(driver);
        flightsPage = new FlightsPage(driver);
        System.out.println("Pages Initialized");
    }

    @BeforeGroups( groups = {"loginGroup"})
    protected void loginPreparation() {
        loginPage.openLoginPage();
    }

    @BeforeGroups( groups = {"flightsGroup"})
    protected void goToFlightSection() {
        flightsPage.goToFlightsSection();
    }

    @Test(description = "Failure Login to Planeta Kino App", groups = {"loginGroup"}, priority = 1)
    protected void failureLoginTest() {
        loginPage.failureLogin();
    }

    @Test(description = "Successful Login to Planeta Kino App", groups = {"loginGroup"}, priority = 2)
    protected void successLoginTest() {
        loginPage.successLogin();
    }

    @Test(description = "Search Flight",  priority = 3, groups = {"flightsGroup"})
    protected void flightTest() {
        flightsPage.selectFlights();
    }

}
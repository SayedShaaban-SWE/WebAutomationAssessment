package stepDefinitions.admin;
import io.cucumber.java.en.*;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;
import static stepDefinitions.Hooks.driver;

public class AdminStepDef {
    private static int numberOfRecords;
    private final DashboardPage homePage = new DashboardPage(driver);
    private final LoginPage loginPage = new LoginPage(driver);
    private final AdminPage adminPage = new AdminPage(driver);


    @When("I should navigated to login page")
    public void isLoginPageDisplayed(){
        assertEquals("Login",loginPage.getLoginTxt());
    }

    @When("I enter {string} as username")
    public void iEnterUsername(String userName) {
        loginPage.sendUserName(userName);
    }

    @And("I enter {string} as password")
    public void iEnterPassword(String password) {
        loginPage.sendPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("I should navigated to home page")
    public void iShouldNavigatedToHomePage() {
        assertEquals("Dashboard",homePage.getDashboardPageTxt());
    }

    @When("I click on Admin tab on the left side menu")
    public void iClickOnAdminTabOnTheLeftSideMenu() {
        homePage.clickOnAdminTap();
    }

    @Then("I should navigated to admin page")
    public void iShouldNavigatedToAdminPage() {
        assertEquals("Admin",adminPage.getAdminPageTxt());
    }

    @Given("I should see number of records displayed")
    public void iShouldSeeNumberOfRecordsDisplayed(){
        assertTrue(adminPage.isNumberOfRecordsDisplayed());
        numberOfRecords = adminPage.getNumberOfRecords();
    }

    @When("I click on add button")
    public void iClickOnAddButton() {
        adminPage.clickOnAddBtn();
    }

    @And("I enter the employee name as {string}, username as {string}, password as {string}")
    public void iEnterTheRequiredDataForTheNewUser(String name, String userName, String password) throws InterruptedException {
        adminPage.enterUserDetails(name,userName,password);
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        adminPage.clickOnSaveBtn();
    }

    @Then("I should see the number of records increased by 1")
    public void iShouldSeeTheNumberOfRecordsIncreasedBy1(){
        assertEquals(numberOfRecords +1,adminPage.getNumberOfRecords());
    }

    @And("I click on delete button for the new user")
    public void iClickOnDeleteButtonForTheNewUser() {
        adminPage.deleteTheUser();
    }

    @Then("I should see the number of records decreased by 1")
    public void iShouldSeeTheNumberOfRecordsDecreasedBy1(){
        adminPage.clickOnResetBtn();
        assertEquals(numberOfRecords-1,adminPage.getNumberOfRecords());
    }

    @When("I search about the user i added with username as {string}")
    public void iSearchAboutTheUserIAddedWithUsernameAs(String userName) {
        adminPage.searchWithUsername(userName);
    }
}

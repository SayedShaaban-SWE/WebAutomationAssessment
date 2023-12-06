package stepDefinitions.admin;
import io.cucumber.java.en.*;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;
import static stepDefinitions.Hooks.driver;

public class AdminStepDef {
    private int numberOfRecords;
    private final HomePage homePage = new HomePage(driver);
    private final LoginPage loginPage = new LoginPage(driver);
    private final AdminPage adminPage = new AdminPage(driver);


    @When("I should navigated to login page")
    public void isLoginPageDisplayed(){
        assertEquals("",loginPage.getLoginTxt());
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
        assertEquals("",homePage.getHomePageTxt());
    }

    @When("I click on Admin tab on the left side menu")
    public void iClickOnAdminTabOnTheLeftSideMenu() {
        homePage.clickOnAdminTap();
    }

    @Then("I should navigated to admin page")
    public void iShouldNavigatedToAdminPage() {
        assertEquals("",adminPage.getAdminPageTxt());
    }

    @Given("I should see number of records displayed")
    public void iShouldSeeNumberOfRecordsDisplayed() {
        assertTrue(adminPage.isNumberOfRecordsDisplayed());
        numberOfRecords = adminPage.getNumberOfRecords();
    }

    @When("I click on add button")
    public void iClickOnAddButton() {
        adminPage.clickOnAddBtn();
    }

    @And("I enter the required data for the new user")
    public void iEnterTheRequiredDataForTheNewUser() {
        adminPage.enterRecordData();
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        adminPage.clickOnSaveBtn();
    }

    @Then("I should see the number of records increased by 1")
    public void iShouldSeeTheNumberOfRecordsIncreasedBy1() {
        assertEquals(numberOfRecords + 1,adminPage.getNumberOfRecords());
    }

    @Given("I click on delete button for the new user")
    public void iClickOnDeleteButtonForTheNewUser() {
        adminPage.deleteTheUser();
    }

    @Then("I should see the number of records decreased by 1")
    public void iShouldSeeTheNumberOfRecordsDecreasedBy1() {
        assertEquals(numberOfRecords,adminPage.getNumberOfRecords());
    }
}

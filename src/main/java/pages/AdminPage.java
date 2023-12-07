package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    private static final By ADMIN_PAGE_TXT = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6[1]");
    private static final By RECORDS_NUMBER = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span");
    private static final By ADD_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
    private static final By EMPLOYEE_NAME_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    private static final By USERNAME_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private static final By USER_ROLE_LIST = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i");
    private static final By USER_STATUS_LIST = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
    private static final By PASSWORD_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private static final By CONFIRM_PASSWORD_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private static final By SAVE_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
    private static final By SEARCH_INPUT_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    private static final By SEARCH_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    private static final By RESET_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]");
    private static final By DELETE_BUTTON = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]");
    private static final By CONFIRM_DELETE_BUTTON = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
    private WebDriver driver;
    private WebDriverWait wait;
    Actions actions;
    public AdminPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }
    public String getAdminPageTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_PAGE_TXT));
        return driver.findElement(ADMIN_PAGE_TXT).getText();
    }
    public boolean isNumberOfRecordsDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RECORDS_NUMBER));
        return driver.findElement(RECORDS_NUMBER).isDisplayed();
    }
    public int getNumberOfRecords(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RECORDS_NUMBER));
        String text = driver.findElement(RECORDS_NUMBER).getText();// Text with space before the number
        int number = Integer.parseInt(text.replaceAll("\\D+", ""));// Remove non-digits
        return number;
    }
    public void clickOnAddBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_BUTTON));
        driver.findElement(ADD_BUTTON).click();
    }
    public void enterUserDetails(String name, String userName, String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(USER_ROLE_LIST));
        driver.findElement(USER_ROLE_LIST).click();
        for (int i=1; i<=2; i++)
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(USER_STATUS_LIST).click();
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        WebElement EmployeeName =driver.findElement(EMPLOYEE_NAME_FIELD);
        EmployeeName.sendKeys(name);
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();

        driver.findElement(USERNAME_FIELD).sendKeys(userName);

        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(password);
    }
    public void clickOnSaveBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        driver.findElement(SAVE_BUTTON).click();
    }
    public void searchWithUsername(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT_FIELD));
        driver.findElement(SEARCH_INPUT_FIELD).sendKeys(userName);
        driver.findElement(SEARCH_BUTTON).click();
    }
    public void deleteTheUser(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_BUTTON));
        driver.findElement(DELETE_BUTTON).click();
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
    }
    public void clickOnResetBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RESET_BUTTON));
        driver.findElement(RESET_BUTTON).click();
    }
}

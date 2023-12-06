package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPage {
    private static final By ADMIN_PAGE_TXT = By.id("");
    private static final By RECORDS_NUMBER = By.id("");
    private static final By ADD_BUTTON = By.id("");
    private static final By SAVE_BUTTON = By.id("");
    private static final By SEARCH_INPUT_FIELD = By.id("");
    private static final By DELETE_BUTTON = By.id("");
    private WebDriver driver;
    private WebDriverWait wait;
    public AdminPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
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
        return Integer.parseInt(driver.findElement(RECORDS_NUMBER).getText());
    }
    public void clickOnAddBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_BUTTON));
        driver.findElement(ADD_BUTTON).click();
    }
    public void enterRecordData(){

    }
    public void clickOnSaveBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_BUTTON));
        driver.findElement(SAVE_BUTTON).click();
    }
    public void searchWithUsername(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT_FIELD));
        WebElement searchField= driver.findElement(SEARCH_INPUT_FIELD);
        searchField.sendKeys(userName);
        searchField.submit();
    }
    public void deleteTheUser(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_BUTTON));
        driver.findElement(DELETE_BUTTON).click();
    }
}

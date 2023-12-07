package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private static final By LOGIN_TXT = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5");
    private static final By USERNAME_INPUT_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
    private static final By PASSWORD_INPUT_FIELD = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
    private static final By LOGIN_BTN = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private WebDriver driver;
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getLoginTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_TXT));
        return driver.findElement(LOGIN_TXT).getText();
    }

    public void sendUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT_FIELD));
        driver.findElement(USERNAME_INPUT_FIELD).sendKeys(userName);
    }
    public void sendPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT_FIELD));
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    }
    public DashboardPage clickOnLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BTN));
        driver.findElement(LOGIN_BTN).click();
        return new DashboardPage(driver);
    }
}

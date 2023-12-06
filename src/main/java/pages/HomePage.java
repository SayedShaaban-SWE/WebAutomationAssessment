package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final By HOME_PAGE_TXT = By.id("");
    private static final By ADMIN_TAP = By.id("");

    private WebDriver driver;
    private WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public String getHomePageTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(HOME_PAGE_TXT));
        return driver.findElement(HOME_PAGE_TXT).getText();
    }
    public AdminPage clickOnAdminTap(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_TAP));
        driver.findElement(ADMIN_TAP).click();
        return new AdminPage(driver);
    }
    public void goBack(){
        driver.navigate().back();
    }


}

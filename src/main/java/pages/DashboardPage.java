package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private static final By DASHBOARD_PAGE_TXT = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    private static final By ADMIN_TAP = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span");

    private WebDriver driver;
    private WebDriverWait wait;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public String getDashboardPageTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DASHBOARD_PAGE_TXT));
        return driver.findElement(DASHBOARD_PAGE_TXT).getText();
    }
    public AdminPage clickOnAdminTap(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADMIN_TAP));
        driver.findElement(ADMIN_TAP).click();
        return new AdminPage(driver);
    }
}

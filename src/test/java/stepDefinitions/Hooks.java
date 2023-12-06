package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Properties prop;
    @Before
    public void setUpDriver(){
        // to Get values from the properties file
        prop = new Properties();
        FileInputStream input = null;
        try {
            //Load the properties file
            input = new FileInputStream("src/main/resources/config.properties");
            prop.load(input);
            if (prop.getProperty("browserName").equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
            }else if (prop.getProperty("browserName").equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
            }else if (prop.getProperty("browserName").equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try {
                Files.write(Path.of("screenshots/"+"FailedScreenshot "+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".png"), screenshot);
                Allure.addAttachment("FailedScenarioScreenshot",new ByteArrayInputStream(screenshot));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
    }
}

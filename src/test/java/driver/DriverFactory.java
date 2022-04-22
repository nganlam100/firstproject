package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getChromedriver(){
        String currentProjectLocation = System.getProperty("user.dir");
        String macOSChromePath = "src/test/resources/drivers/chromedriver.exe";
        String windowChromePath = "\\src\\test\\resources\\drivers\\chromedriver.exe";
        String relativeChromeDriverPath = OS.isFamilyMac() ? macOSChromePath : windowChromePath;
        String chromeDriverPath = currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").concat(""));
        return driver;
    }
}

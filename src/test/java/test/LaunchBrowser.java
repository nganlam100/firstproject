package test;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        String currentProjectLocation = System.getProperty("user.dir");
        String relativeChromeDriverPath = "/src/test/resources/drivers/chromedriver.exe";
        String chromeDriverPath = currentProjectLocation.concat(relativeChromeDriverPath);
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.getBrowserName();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/downloads/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        driver.quit();
    }
}

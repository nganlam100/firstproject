package test;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverFactory.getChromedriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        Thread.sleep(1000);
        driver.quit();
    }
}

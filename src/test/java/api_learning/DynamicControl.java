package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControl implements Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();

        try{
            driver.get(baseUrl.concat(dynamicControl));
            //remove checkbox
            WebElement checkboxBtnElem = driver.findElement(By.tagName("input"));
            WebElement removeBtnElem = driver.findElement(By.tagName("button"));
            if (!checkboxBtnElem.isSelected()){
                checkboxBtnElem.click();
                removeBtnElem.click();
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
            WebElement msgElem = driver.findElement(By.id("message"));
            System.out.println(msgElem.getText());
            WebElement addBtnElem = driver.findElement(By.tagName("button"));
            addBtnElem.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loading"))));
            msgElem = driver.findElement(By.id("message"));
            System.out.println(msgElem.getText());

            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}

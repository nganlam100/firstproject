package api_learning;

import driver.DriverFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrame implements Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        try {
            driver.get(baseUrl.concat(iFramePage));
            //Locate iframe
            WebElement iframe = driver.findElement(By.cssSelector("[id$='ifr']"));

            //Switch to that frame
            driver.switchTo().frame(iframe);

            //inside iframe
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("abc abc");

            //Switch to parent iframe
            driver.switchTo().defaultContent();
            WebElement linkText = driver.findElement(By.linkText("Elemental Selenium"));
            System.out.println(linkText.getAttribute("href"));

            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}

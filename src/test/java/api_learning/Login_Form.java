package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login_Form implements Urls{
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        try{
            driver.get(baseUrl.concat(login));

            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();


            By flashMsgSel = By.id("flash-messages");
            WebElement flashMgsElm = driver.findElement(flashMsgSel);
            System.out.println("\t --->" + flashMgsElm.getText());

            //Go back to the login page
            driver.navigate().back();
            printTitleAndUrl(driver);

            //Multiple matching elem
            List<WebElement> inputElem = driver.findElements(By.tagName("input"));
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            usernameElem = inputElem.get(USERNAME_INDEX);
            passwordElem = inputElem.get(PASSWORD_INDEX);
            usernameElem.clear();
            usernameElem.sendKeys("teo");
            passwordElem.clear();
            passwordElem.sendKeys("tuilateo");

            loginBtnElem = driver.findElement(loginBtnSel);
            loginBtnElem.click();

            //Get power link text
            By powerLinkTextSel = By.linkText("Elemental Selenium");
            WebElement powerLinkTextElem = driver.findElement(powerLinkTextSel);
            System.out.println(powerLinkTextElem.getText());

            By backgroundColorSel = By.cssSelector(".error");
            WebElement backgroundColorElem = driver.findElement(backgroundColorSel);
            System.out.println(backgroundColorElem.getCssValue("background-color"));

            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
    private static void printTitleAndUrl(WebDriver driver){
        System.out.println("\t --->" + driver.getCurrentUrl());
        System.out.println("\t --->" + driver.getTitle());
    }
}

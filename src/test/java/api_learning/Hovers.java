package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Hovers implements Urls{
    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();

        try{
            driver.get(baseUrl.concat(hovers));

            List<WebElement> figureElems = driver.findElements(figureSel);
            if (figureElems.isEmpty()){
                throw new RuntimeException("There is no profile image");
            }
            for (WebElement figureElem : figureElems){
                WebElement profileNameElem = driver.findElement(profileNameSel);
                WebElement profileLinkElem = driver.findElement(profileLinkSel);

                //Define action
                Actions actions = new Actions(driver);

                //Before mouse hover
                System.out.println("Is profile name displayed: " + profileNameElem.isDisplayed());
                System.out.println("Is profile link displayed: " + profileLinkElem.isDisplayed());

                //Mouse hover
                actions.moveToElement(figureElem).perform();

                System.out.println("Is profile name displayed: " + profileNameElem.isDisplayed());
                System.out.println("Is profile link displayed: " + profileLinkElem.isDisplayed());

                System.out.println("Profile Name: " + profileNameElem.getText());
                System.out.println("Profile Link: " + profileLinkElem.getAttribute("href"));
            }

            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}

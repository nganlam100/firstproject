package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JsSnippetExecution implements Urls{

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.getChromedriver();
        try{
            driver.get(baseUrl.concat(floatingPage));
            scrollToBottom(driver);

            Thread.sleep(2000);

            scrollToTop(driver);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
    private static void scrollToBottom(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    private static void scrollToTop(WebDriver driver){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
    }
}

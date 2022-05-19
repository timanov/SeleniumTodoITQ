package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.login.LoginPage;

import java.util.logging.Logger;

import static constans.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    public static Logger log = Logger.getLogger(LoginPage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void open(String url) {
        driver.get(url);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void delay(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

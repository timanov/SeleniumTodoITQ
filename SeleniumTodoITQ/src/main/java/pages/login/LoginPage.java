package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

import java.util.logging.Logger;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { super(driver); }
    private static Logger log = Logger.getLogger(LoginPage.class.getName());

    private final By loginField = By.xpath("/html/body/app-root/div/app-login/form/div/input[1]");
    private final By passwordField = By.xpath("/html/body/app-root/div/app-login/form/div/input[2]");
    private final By buttonEnter = By.xpath("/html/body/app-root/div/app-login/form/div/button[1]");
    private final By buttonExit = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[7]/a");
    private String login = "";
    private String password = "";

    public LoginPage inputLogin() {
        log.info("Вводим логин");
        driver.findElement(loginField).sendKeys(login);

        return this;
    }

    public LoginPage inputPassword() {
        log.info("Вводим пароль");
        driver.findElement(passwordField).sendKeys(password);

        return this;
    }

    public LoginPage clickLoginBtn() {
        log.info("Нажимаем кнопку войти");
        driver.findElement(buttonEnter).click();

        return this;
    }

    public LoginPage clickExitBtn() {
        log.info("Нажимаем кнопку выйти");
        driver.findElement(buttonExit);

        return this;
    }


    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

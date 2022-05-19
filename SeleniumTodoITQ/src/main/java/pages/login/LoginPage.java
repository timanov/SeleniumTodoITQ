package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { super(driver); }

    private final By loginField = By.xpath("/html/body/app-root/div/app-login/form/div/input[1]");
    private final By passwordField = By.xpath("/html/body/app-root/div/app-login/form/div/input[2]");
    private final By buttonEnter = By.xpath("/html/body/app-root/div/app-login/form/div/button[1]");
    private final By buttonExit = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[7]/a");
    private final By buttonNewUser = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[5]/a");
    private String login = "";
    private String password = "";

    public LoginPage inputLogin(String login) {
        log.info("Вводим логин");
        driver.findElement(loginField).sendKeys(login);
        delay(1000);

        return this;
    }

    public LoginPage inputPassword(String password) {
        log.info("Вводим пароль");
        driver.findElement(passwordField).sendKeys(password);
        delay(1000);

        return this;
    }

    public LoginPage clickLoginBtn() {
        log.info("Нажимаем кнопку [Войти]");
        driver.findElement(buttonEnter).click();
        delay(1000);

        return this;
    }

    public LoginPage clickExitBtn() {
        log.info("Нажимаем кнопку [Выйти]");
        driver.findElement(buttonExit).click();
        delay(1000);

        return this;
    }

    public LoginPage clickNewUser() {
        log.info("Нажимаем кнопку [Новый пользователь]");
        driver.findElement(buttonNewUser).click();
        delay(1000);

        return this;
    }
}

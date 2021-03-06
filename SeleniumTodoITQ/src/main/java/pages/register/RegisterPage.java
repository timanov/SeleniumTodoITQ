package pages.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) { super(driver); }

    private final By loginField = By.xpath("//*[@id=\"email\"]");
    private final By passwordField = By.xpath("//*[@id=\"password\"]");
    private final By lastNameField = By.xpath("//*[@id=\"lastName\"]");
    private final By firstNameField = By.xpath("//*[@id=\"firstName\"]");
    private final By middleNameField = By.xpath("//*[@id=\"middleName\"]");
    private final By emailField = By.xpath("/html/body/app-root/div/app-register/form/div[6]/div/input");
    private final By buttonEnter = By.xpath("/html/body/app-root/div/app-register/form/button");


    public RegisterPage inputLoginRegister(String login) {
        log.info("Вводим логин");
        driver.findElement(loginField).sendKeys(login);
        delay(1000);

        return this;
    }

    public RegisterPage inputPasswordRegister(String password) {
        log.info("Вводим пароль");
        driver.findElement(passwordField).sendKeys(password);
        delay(1000);

        return this;
    }

    public RegisterPage lastNameFieldRegister (String lastName) {
        log.info("Вводим фамилию");
        driver.findElement(lastNameField).sendKeys(lastName);
        delay(1000);

        return this;
    }

    public RegisterPage firstNameFieldRegister (String firstName) {
        log.info("Вводим Имя");
        driver.findElement(firstNameField).sendKeys(firstName);
        delay(1000);

        return this;
    }

    public RegisterPage middleNameFieldRegister (String middleName) {
        log.info("Вводим Отчество");
        driver.findElement(middleNameField).sendKeys(middleName);
        delay(1000);

        return this;
    }

    public RegisterPage emailFieldRegister (String email) {
        log.info("Вводим Email");
        driver.findElement(emailField).sendKeys(email);
        delay(1000);

        return this;
    }

    public RegisterPage clickLoginBtnRegister() {
        log.info("Нажимаем кнопку [Создать]");
        driver.findElement(buttonEnter).click();
        delay(1000);

        return this;
    }

}

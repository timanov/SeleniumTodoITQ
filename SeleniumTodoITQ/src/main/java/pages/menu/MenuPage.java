package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import pages.login.LoginPage;

import java.util.List;
import java.util.logging.Logger;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) { super(driver); }
    private static Logger log = Logger.getLogger(LoginPage.class.getName());

    private final By createAndNewCourse = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[1]/a");
    private final By buttonDropDownCourse = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[1]/select");
    private final By buttonDropDownStudents = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[2]/select");
    private final By buttonDropDownStatus = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[3]/select");
    private List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'select']//option"));


    public MenuPage clickCreateAndNewCourse() {
        log.info("Нажимаем на кнопку [Добавить/Редактировать курс]");
        driver.findElement(createAndNewCourse).click();

        return this;
    }

    public MenuPage clickDropDownCourse() {
        log.info("Нажимаем на выпадающий список 'Выберите курс'");
        driver.findElement(buttonDropDownCourse).click();

        return this;
    }

    public MenuPage clickDropDownCourseValue(String course) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите курс'");

        for (WebElement option : options) {
            if (option.getText().contains(course)) {
                option.click();
                break;
            }
        }

        return this;
    }

    public MenuPage clickDropDownStudents() {
        log.info("Нажимаем на выпадающий список 'Выберите студента'");
        driver.findElement(buttonDropDownStudents).click();

        return this;
    }

    public MenuPage clickDropDownStudentsValue(String student) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите студента'");

        for (WebElement option : options) {
            if (option.getText().contains(student)) {
                option.click();
                break;
            }
        }

        return this;
    }

    public MenuPage clickDropDownStatus() {
        log.info("Нажимаем на выпадающий список 'Выберите статус'");
        driver.findElement(buttonDropDownStatus).click();

        return this;
    }

    public MenuPage clickDropDownStatusValue(String status) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите статус'");

        for (WebElement option : options) {
            if (option.getText().contains(status)) {
                option.click();
                break;
            }
        }

        return this;
    }


}

package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) { super(driver); }

    private final By buttonCreateAndNewCourse = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[1]/a");
    private final By buttonCreateNewTask = By.xpath("/html/body/app-root/div/app-list-todos/div[2]/div/button");
    private final By buttonWork = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[2]/a");

    private final By buttonDropDownCourse = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[1]/select");
    private final By buttonDropDownStudents = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[2]/select");
    private final By buttonDropDownStatus = By.xpath("/html/body/app-root/div/app-list-todos/div[1]/div[3]/select");


    public MenuPage clickCreateAndNewCourse() {
        log.info("Нажимаем на кнопку [Добавить/Редактировать курс]");
        driver.findElement(buttonCreateAndNewCourse).click();
        delay(1000);

        return this;
    }

    public MenuPage clickNewTask() {
        log.info("Нажимаем на кнопку [Добавить новое задание]");
        driver.findElement(buttonCreateNewTask).click();
        delay(1000);

        return this;
    }

    public MenuPage clickWork() {
        log.info("Нажимаем на кнопку [Работы]");
        driver.findElement(buttonCreateNewTask).click();
        delay(1000);

        return this;
    }

    public MenuPage clickDropDownCourse() {
        log.info("Нажимаем на выпадающий список 'Выберите курс'");
        driver.findElement(buttonWork).click();
        delay(1000);

        return this;
    }

    public MenuPage clickDropDownCourseValue(String course) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите курс'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'select']//option"));

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
        delay(1000);

        return this;
    }

    public MenuPage clickDropDownStudentsValue(String student) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите студента'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'select']//option"));

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
        delay(1000);

        return this;
    }

    public MenuPage clickDropDownStatusValue(String status) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите статус'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'select']//option"));

        for (WebElement option : options) {
            if (option.getText().contains(status)) {
                option.click();
                break;
            }
        }

        return this;
    }


}

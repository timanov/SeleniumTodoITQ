package pages.create_course;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
public class CreateCoursePage extends BasePage {

    public CreateCoursePage(WebDriver driver) { super(driver); }

    private final By nameCourseField = By.xpath("//*[@id=\"course\"]");
    private final By buttonCreateCourse = By.xpath("/html/body/app-root/div/app-create-course/form/div[1]/button");

    public CreateCoursePage inputCourseName(String courseName) {
        log.info("Вводим имя курса");
        driver.findElement(nameCourseField).sendKeys(courseName);
        delay(1000);

        return this;
    }

    public CreateCoursePage clickCreateCourse() {
        log.info("Нажимаем на кнопку [Создать курс]");
        driver.findElement(buttonCreateCourse).click();
        delay(1000);

        return this;
    }

    public CreateCoursePage alertTrue() {
        log.info("Кликаем на alert");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        delay(1000);

        return this;
    }


}

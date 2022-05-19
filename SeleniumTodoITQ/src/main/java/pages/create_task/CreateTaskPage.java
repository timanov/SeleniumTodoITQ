package pages.create_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import java.util.List;
public class CreateTaskPage extends BasePage {

    public CreateTaskPage(WebDriver driver) { super(driver); }

    private final By buttonDropDownSelectLecture = By.xpath("//*[@id=\"selectedLecture\"]");
    private final By descriptionField = By.xpath("/html/body/app-root/div/app-todo/form/div[4]/textarea");
    private final By buttonSave = By.xpath("/html/body/app-root/div/app-todo/form/button");

    public CreateTaskPage clickDropDownCourseValue(String course) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите курс'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'selectedCourse']//option"));

        for (WebElement option : options) {
            if (option.getText().contains(course)) {
                option.click();
                break;
            }
        }

        return this;
    }

    public CreateTaskPage clickDropDownLecture() {
        log.info("Нажимаем на выпадающий список 'Выберите лекцию'");
        driver.findElement(buttonDropDownSelectLecture).click();
        delay(1000);

        return this;
    }

    public CreateTaskPage clickDropDownLectureValue(String lecture) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите лекцию'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'selectedLecture']//option"));

        for (WebElement option : options) {
            if (option.getText().contains(lecture)) {
                option.click();
                break;
            }
        }

        return this;
    }


    public CreateTaskPage clickDropDownStatusValue(String status) {
        log.info("Выбираем значение в выпадающим списке: 'Выберите статус'");

        List<WebElement> options = driver.findElements(By.xpath("//select[@id = 'selectedStatus']//option"));

        for (WebElement option : options) {
            if (option.getText().contains(status)) {
                option.click();
                break;
            }
        }

        return this;
    }

    public CreateTaskPage inputDescription(String description) {
        log.info("Указываем описание");
        driver.findElement(descriptionField).sendKeys(description);
        delay(1000);

        return this;
    }

    public CreateTaskPage clickSaveTask() {
        log.info("Сохраняем новую задачу");
        driver.findElement(buttonSave).click();
        delay(1000);

        return this;
    }




}

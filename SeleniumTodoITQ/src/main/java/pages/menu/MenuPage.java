package pages.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.create_course.CreateCoursePage;
import pages.login.LoginPage;

import java.util.logging.Logger;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) { super(driver); }
    private static Logger log = Logger.getLogger(LoginPage.class.getName());

    private final By CreateAndNewCourse = By.xpath("/html/body/app-root/app-menu/header/nav/ul[2]/li[1]/a");


    public MenuPage clickCreateAndNewCourse() {
        log.info("Нажимаем на кнопку [Добавить/Редактировать курс]");
        driver.findElement(CreateAndNewCourse).click();

        return this;
    }
}

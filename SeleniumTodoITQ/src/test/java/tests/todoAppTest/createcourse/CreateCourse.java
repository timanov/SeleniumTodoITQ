package tests.todoAppTest.createcourse;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Random;

import static constans.Constant.Credential.LOGIN_ADMIN;
import static constans.Constant.Credential.PASSWORD_ADMIN;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class CreateCourse extends BaseTest {

    private final int courseName = new Random().nextInt(11) + 22241330;

    @Test
    public void id2() {
        loginToTodo(); //Авторизация под админом
        createNewCourse(); //Создание нового курса

    }
    @Step("1. Авторизация под админом")
    public void loginToTodo(){
        basePage.open(TODO_HOME_PAGE);
        loginPage.setLogin(LOGIN_ADMIN);
        loginPage.setPassword(PASSWORD_ADMIN);
        loginPage
                .inputLogin()
                .inputPassword()
                .clickLoginBtn();
    }

    @Step("2. Создание нового курса")
    public void createNewCourse() {
        menuPage.clickCreateAndNewCourse();
        createCoursePage.inputCoursName(String.valueOf(courseName));
        createCoursePage.clickCreateCourse();
        delay(2000);
        createCoursePage.alertTrue();
        loginPage.clickExitBtn();
        delay(3000);
    }
}

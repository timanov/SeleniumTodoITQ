package tests.createcourse;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.login.LoginTest;

import static constans.Constant.Credential.LOGIN_ADMIN;
import static constans.Constant.Credential.PASSWORD_ADMIN;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class CreateCourse extends BaseTest {

    private final String courseName = "Курс123456";

    @Test
    public void id2() {
        loginToTodo(); //Авторизация в Todo
        createNewCourse(); //Создание нового курса

    }
    @Step("1. Авторизация в Todo")
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
        createCoursePage.inputCoursName(courseName);
        createCoursePage.clickCreateCourse();
        //createCoursePage.alertTrue();
    }
}

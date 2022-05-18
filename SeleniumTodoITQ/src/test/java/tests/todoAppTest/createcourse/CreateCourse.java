package tests.todoAppTest.createcourse;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.Random;

import static constans.Constant.Credential.*;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class CreateCourse extends BaseTest {

    private final int courseName = new Random().nextInt(145635) + 2213320;

    @Test
    public void id2() {
        loginToTodoAdmin(); //Авторизация под админом
        createNewCourse(); //Создание нового курса
        loginToTodoUser(); //Авторизация под пользователем
        searchNewCourse(); //Поиск созданного курса администратором
        searchStudent(); //Проверка выпадающего списка 'Выберите студента'
        searchStatus(); //Проверка выпадающего списка 'Выберите студента'



    }
    @Step("1. Авторизация под админом")
    public void loginToTodoAdmin(){
        basePage.open(TODO_HOME_PAGE);
        loginPage
                .inputLogin(LOGIN_ADMIN)
                .inputPassword(PASSWORD_ADMIN)
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
        delay(3000);;
    }

    @Step("3. Авторизация под пользователем")
    public void loginToTodoUser(){
        loginPage
                .inputLogin(LOGIN_USER)
                .inputPassword(PASSWORD_USER)
                .clickLoginBtn();
    }

    @Step("4. Поиск созданного курса администратором")
    public void searchNewCourse() {
        menuPage.clickDropDownCourse();
        menuPage.clickDropDownCourseValue(String.valueOf(courseName));
        delay(5000);
    }

    @Step("5. Проверка выпадающего списка 'Выберите студента'")
    public void searchStudent() {
        menuPage.clickDropDownStudents();
        menuPage.clickDropDownStudentsValue(LOGIN_ADMIN);

        delay(5000);
    }

    @Step("6. Проверка выпадающего списка 'Выберите студента'")
    public void searchStatus() {
        menuPage.clickDropDownStatus();
        menuPage.clickDropDownStatusValue("Все");
        menuPage.clickDropDownStatusValue("Review");
        menuPage.clickDropDownStatusValue("ToDo");
        menuPage.clickDropDownStatusValue("Hold");
        menuPage.clickDropDownStatusValue("Closed");

        delay(5000);
    }
}

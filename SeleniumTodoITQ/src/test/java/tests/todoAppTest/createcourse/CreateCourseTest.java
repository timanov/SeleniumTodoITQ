package tests.todoAppTest.createcourse;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.sql.*;
import java.util.Random;

import static constans.Constant.Credential.*;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class CreateCourseTest extends BaseTest {

    private final int courseName = new Random().nextInt(145635) + 2213320;
    private final int primaryKey = new Random().nextInt(200) + 224;
    private final String SELECT_QUERY_GET = "SELECT id FROM course WHERE name = '"+ courseName +"'";



    @Test
    public void id2() throws SQLException, ClassNotFoundException {
        loginToTodoAdmin(); //Авторизация под админом
        createNewCourse(); //Создание нового курса
        loginToTodoUser(); //Авторизация под пользователем
        searchNewCourse(); //Поиск созданного курса администратором
        searchStudent(); //Проверка выпадающего списка 'Выберите студента'
        searchStatus(); //Проверка выпадающего списка 'Выберите студента'
        createNewtask(); //Создание нового задания
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
                .inputLogin(LOGIN_ADMIN)
                .inputPassword(PASSWORD_ADMIN)
                .clickLoginBtn();
    }

    @Step("4. Поиск созданного курса администратором")
    public void searchNewCourse() {
        menuPage.clickDropDownCourse();
        menuPage.clickDropDownCourseValue(String.valueOf(courseName));
        menuPage.clickDropDownCourseValue("Все курсы");

    }

    @Step("5. Проверка выпадающего списка 'Выберите студента'")
    public void searchStudent() {
        menuPage.clickDropDownStudents();
        menuPage.clickDropDownStudentsValue(LOGIN_ADMIN);
        menuPage.clickDropDownStudentsValue("Все студенты");

    }

    @Step("6. Проверка выпадающего списка 'Выберите студента'")
    public void searchStatus() {
        menuPage.clickDropDownStatus();
        menuPage.clickDropDownStatusValue("Closed");
        menuPage.clickDropDownStatusValue("Review");
        menuPage.clickDropDownStatusValue("ToDo");
        menuPage.clickDropDownStatusValue("Hold");
        menuPage.clickDropDownStatusValue("Все");

    }

    @Step("7. Создание нового задания")
    public void createNewtask() throws SQLException, ClassNotFoundException {
        dbSteps.DbQuerySelect(SELECT_QUERY_GET, "id");

        String SELECT_QUERY_INSERT = "INSERT INTO lecture values ('" + primaryKey + "','" + courseName + "','Проверка урок23а','" + dbSteps.responseQuery +"')";
        dbSteps.DbQueryInsert(SELECT_QUERY_INSERT);
        menuPage.clickNewTask();
        createTaskPage
                    .clickDropDownCourseValue(String.valueOf(courseName))
                    .clickDropDownLecture()
                    .clickDropDownLectureValue("Проверка")
                    .clickDropDownStatusValue("ToDo")
                    .inputDescription("Привет, это описанввпие 234325325")
                    .clickSaveTask();
        createCoursePage.alertTrue();
        menuPage.clickDropDownStatusValue("ToDo");
        loginPage.clickExitBtn();

    }

}

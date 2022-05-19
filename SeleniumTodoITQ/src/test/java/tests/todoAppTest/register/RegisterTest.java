package tests.todoAppTest.register;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;


import java.sql.SQLException;
import java.util.Random;

import static constans.Constant.Urls.TODO_HOME_PAGE;
import static org.testng.AssertJUnit.assertEquals;

public class RegisterTest extends BaseTest {

    private final int login = new Random().nextInt(15340) + 222330;
    private final int password = new Random().nextInt(14300) + 22241330;
    private final int randomInt = new Random().nextInt(1500) + 2424;
    private final String email = "miha6" + randomInt + "43@mail.ru";
    private final String lastName = "Алексеевич";
    private final String firstName = "Михаил";
    private final String middleName = "Тиманов";


    @Test
    public void id3() throws SQLException, ClassNotFoundException {
        registerToDo(); //Регистрация пользователя
        loginToTodo(); //Авторизация в приложении и нажать на кнопку [Выйти]
        assertUser(); //Проверка заполнения таблицы с юзером
    }

    @Step("1. Регистрация пользователя")
    public void registerToDo(){
        basePage.open(TODO_HOME_PAGE);
        loginPage.clickNewUser();
        registerPage
                    .inputLoginRegister(String.valueOf(login))
                    .inputPasswordRegister(String.valueOf(password))
                    .lastNameFieldRegister(lastName)
                    .firstNameFieldRegister(firstName)
                    .middleNameFieldRegister(middleName)
                    .emailFieldRegister(email)
                    .clickLoginBtnRegister();
        createCoursePage.alertTrue();
    }

    @Step("2. Авторизация в приложении и нажать на кнопку [Выйти]")
    public void loginToTodo() {
        loginPage
                .inputLogin(String.valueOf(login))
                .inputPassword(String.valueOf(password))
                .clickLoginBtn()
                .clickExitBtn();
        delay(1000);
    }

    @Step("3. Проверка заполнения таблицы с юзером")
    public void assertUser() throws SQLException, ClassNotFoundException {
        String SELECT_QUERY_GET_USER = "SELECT * FROM user WHERE email = '" + email + "'";
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "email");
        assertEquals(dbSteps.responseQuery,email);
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "enabled");
        assertEquals(dbSteps.responseQuery,"1");
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "firstName");
        assertEquals(dbSteps.responseQuery,firstName);
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "lastName");
        assertEquals(dbSteps.responseQuery,lastName);
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "middleName");
        assertEquals(dbSteps.responseQuery,middleName);
        dbSteps.DbQuerySelect(SELECT_QUERY_GET_USER, "username");
        assertEquals(dbSteps.responseQuery,String.valueOf(login));
    }
}

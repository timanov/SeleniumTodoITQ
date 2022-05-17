package tests.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constans.Constant.Credential.*;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class LoginTest extends BaseTest {

    @Test
    public void id1() {
        loginToTodo(); //Проверка на вход и выход из приложения под админом
        loginToTodoUser(); //Проверка на вход и выход из приложения под пользователем
    }

    public void loginToTodo() {
        basePage.open(TODO_HOME_PAGE);
        loginPage.setLogin(LOGIN_ADMIN);
        loginPage.setPassword(PASSWORD_ADMIN);
        loginPage.inputLogin();
        loginPage.inputPassword();
        loginPage.clickLoginBtn();
        loginPage.clickExitBtn();
    }

    public void loginToTodoUser() {
        basePage.open(TODO_HOME_PAGE);
        loginPage.setLogin(LOGIN_USER);
        loginPage.setPassword(PASSWORD_USER);
        loginPage.inputLogin();
        loginPage.inputPassword();
        loginPage.clickLoginBtn();
        loginPage.clickExitBtn();
    }
}

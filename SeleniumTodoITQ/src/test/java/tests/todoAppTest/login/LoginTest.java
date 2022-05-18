package tests.todoAppTest.login;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constans.Constant.Credential.*;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class LoginTest extends BaseTest {

    @Test
    public void id1() {
        loginToTodoAdmin(); //Авторизация под админом
        loginToTodoUser(); //Авторизация под пользователем
    }

    public void loginToTodoAdmin() {
        basePage.open(TODO_HOME_PAGE);
        loginPage
                .inputLogin(LOGIN_ADMIN)
                .inputPassword(PASSWORD_ADMIN)
                .clickLoginBtn()
                .clickExitBtn();
    }

    public void loginToTodoUser() {
        basePage.open(TODO_HOME_PAGE);
        loginPage
                .inputLogin(LOGIN_ADMIN)
                .inputPassword(PASSWORD_ADMIN)
                .clickLoginBtn()
                .clickExitBtn();
    }
}

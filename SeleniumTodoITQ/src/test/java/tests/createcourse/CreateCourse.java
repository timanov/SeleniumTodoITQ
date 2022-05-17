package tests.createcourse;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.login.LoginTest;

import static constans.Constant.Credential.LOGIN_ADMIN;
import static constans.Constant.Credential.PASSWORD_ADMIN;
import static constans.Constant.Urls.TODO_HOME_PAGE;

public class CreateCourse extends BaseTest {

    @Test
    public void id2() {
        loginToTodo(); //Проверка на вход и выход из приложения под админом
    }

    public void loginToTodo(){
        basePage.open(TODO_HOME_PAGE);
        loginPage.setLogin(LOGIN_ADMIN);
        loginPage.setPassword(PASSWORD_ADMIN);
        loginPage.inputLogin();
        loginPage.inputPassword();
        loginPage.clickLoginBtn();
        loginPage.clickExitBtn();
    }
}

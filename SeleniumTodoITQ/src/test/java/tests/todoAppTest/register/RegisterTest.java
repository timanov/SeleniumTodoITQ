package tests.todoAppTest.register;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;


import static constans.Constant.Urls.TODO_HOME_PAGE;

public class RegisterTest extends BaseTest {

    private final String login = "m6i232shkat234imanov";
    private final String password = "8m712is3hkatimanov123";

    @Test
    public void id3() {
        registerToDo(); //Регистрация пользователя
        loginToTodo(); //Авторизация в приложении и нажать на кнопку [Выйти]
    }

    @Step("1. Регистрация пользователя")
    public void registerToDo(){
        basePage.open(TODO_HOME_PAGE);
        loginPage.clickNewUser();
        registerPage.inputLoginRegister(login);
        registerPage.inputPasswordRegister(password);
        registerPage.lastNameFieldRegister("Лома");
        registerPage.firstNameFieldRegister("Ломан");
        registerPage.middleNameFieldRegister("Ломанми");
        registerPage.emailFieldRegister("k32e2eke123@gmail.com");
        registerPage.clickLoginBtnRegister();
    }

    @Step("2. Авторизация в приложении и нажать на кнопку [Выйти]")
    public void loginToTodo() {
        basePage.open(TODO_HOME_PAGE);
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        delay(3000);
        loginPage
                .inputLogin()
                .inputPassword()
                .clickLoginBtn()
                .clickExitBtn();
    }
}

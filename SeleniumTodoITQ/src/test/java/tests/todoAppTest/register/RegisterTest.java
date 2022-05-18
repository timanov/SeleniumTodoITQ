package tests.todoAppTest.register;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import tests.base.BaseTest;


import java.util.Random;

import static constans.Constant.Urls.TODO_HOME_PAGE;

public class RegisterTest extends BaseTest {

    private final int login = new Random().nextInt(15340) + 222330;
    private final int password = new Random().nextInt(14300) + 22241330;
    private final int randomInt = new Random().nextInt(1500) + 2424;
    private final String email = "miha6" + randomInt + "43@mail.ru";

    @Test
    public void id3() {
        registerToDo(); //Регистрация пользователя
        loginToTodo(); //Авторизация в приложении и нажать на кнопку [Выйти]
    }

    @Step("1. Регистрация пользователя")
    public void registerToDo(){
        basePage.open(TODO_HOME_PAGE);
        loginPage.clickNewUser();
        registerPage.inputLoginRegister(String.valueOf(login));
        registerPage.inputPasswordRegister(String.valueOf(password));
        registerPage.lastNameFieldRegister("Лопвп");
        registerPage.firstNameFieldRegister("вапыан");
        registerPage.middleNameFieldRegister("Лманми");
        registerPage.emailFieldRegister(email);
        registerPage.clickLoginBtnRegister();
    }

    @Step("2. Авторизация в приложении и нажать на кнопку [Выйти]")
    public void loginToTodo() {
        basePage.open(TODO_HOME_PAGE);

        delay(6000);
        loginPage
                .inputLogin(String.valueOf(login))
                .inputPassword(String.valueOf(password))
                .clickLoginBtn()
                .clickExitBtn();
    }
}

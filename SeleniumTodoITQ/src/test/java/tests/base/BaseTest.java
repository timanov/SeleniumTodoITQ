package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.create_course.CreateCoursePage;
import pages.listing.RealtListingPage;
import pages.login.LoginPage;
import pages.menu.MenuPage;
import pages.realt_home.RealtHomePage;
import tests.createcourse.CreateCourse;

import java.awt.*;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected RealtHomePage realtHomePage = new RealtHomePage(driver);
    protected RealtListingPage realtListingPage = new RealtListingPage(driver);
    protected LoginPage loginPage = new LoginPage(driver);
    protected MenuPage menuPage = new MenuPage(driver);
    protected CreateCoursePage createCoursePage = new CreateCoursePage(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage() {
        if (CLEAR_COOKIES_AND_STORAGE)
        {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

//    @AfterSuite (alwaysRun = false)
//    public void close() {
//        if (HOLD_BROWSER_OPEN) {
//            driver.quit();
//        }
//    }



}

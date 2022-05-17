package tests.searchappartment;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constans.Constant.Urls.TODO_HOME_PAGE;


public class SearchApartmentTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing () {
        basePage.open(TODO_HOME_PAGE);
        realtHomePage
                .enterCountRooms()
                .clickToFind();

        realtListingPage.checkCountCards();
    }
}

package uiTest;

import coreUI.SeleniumSetup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uiTestData.TestValues;
import useConfig.ConfigProviderUi;

import java.util.List;

import static helpers.StringModifier.getUniqueString;

public class TestFlow extends SeleniumSetup {

    @Test
    public void checkTicket(){
        String title = getUniqueString(TestValues.TEST_TITLE);
        List<?> topBooksList = new LoginPage().auth(ConfigProviderUi.LOGIN , ConfigProviderUi.PASSWORD)
                .gotoStore()
                .getBooksList(10);
//        Assertions.assertTrue(ticketPage.getTitle().contains(title));
//        Assertions.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
//        Assertions.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
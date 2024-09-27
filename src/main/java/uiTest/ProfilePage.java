package uiTest;

import coreUI.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseSeleniumPage {

    @FindBy(xpath = "//button[@id='gotoStore']")
    private WebElement gotoStoreButton;

    public ProfilePage() {
        PageFactory.initElements(driver,this);
    }

    public BooksPage gotoStore(){
        gotoStoreButton.click();
        return new BooksPage();
    }

}
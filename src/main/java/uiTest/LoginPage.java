package uiTest;

import coreUI.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import useConfig.ConfigProviderUi;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(id = "userName")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@id='login']")
    private WebElement loginButton;

    public LoginPage() {
        driver.get(ConfigProviderUi.START_URL);
        PageFactory.initElements(driver,this);
    }

    public ProfilePage auth(String loginValue, String passwordValue){
        userName.sendKeys(loginValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        return new ProfilePage();
    }

}

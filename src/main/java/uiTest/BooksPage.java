package uiTest;

import coreUI.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiTestData.BookData;
import useConfig.ConfigProviderUi;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BaseSeleniumPage {
//    @FindBy(id = "userName")
//    private WebElement userName;
//
//    @FindBy(id = "password")
//    private WebElement password;
//
//    @FindBy(xpath = "//div[@class='rt-tr-group']")
//    private List<WebElement> bookElements;

    public BooksPage() {
        PageFactory.initElements(driver,this);
    }

    public List<BookData> getBooksList(int quantity){

        List<WebElement> bookElements = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        List<BookData> books = new ArrayList<>();

        for (WebElement bookElement : bookElements) {
            String imageUrl = bookElement.findElement(By.xpath("//div[@class='rt-td']//img")).getAttribute("src");

            String bookTitle = bookElement.findElement(By.xpath("//div[@class='rt-td']//span//a")).getText();

            String author = bookElement.findElement(By.xpath("//div[@class='rt-td'][3]")).getText();

            String publisher = bookElement.findElement(By.xpath("//div[@class='rt-td'][4]")).getText();

            BookData book = new BookData(imageUrl, bookTitle, author, publisher);
            books.add(book);
        }

        for (BookData book2 : books) {
            System.out.println(book2);
        }

        return books;
    }

}
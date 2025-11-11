package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.logging.XMLFormatter;

public class MyBoardPage extends BasePage {
    public MyBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement boardName;

    @FindBy(xpath = "//button[@aria-label='Show menu']")
    WebElement btnDots;
    @FindBy(xpath = "//div[text()='Close board']")
    WebElement btnCloseBoard;
    @FindBy(xpath = "//button[@data-testid='popover-close-board-confirm']")
    WebElement btnClose;
    @FindBy(xpath = "//button[@data-testid='close-board-delete-board-button']")
    WebElement btnDeleteBoard;
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement btnDelete;


    public boolean validateBoardName(String text) {
        return validateTextInElement(boardName, text);
    }

    public void deleteBoard() {
        clickWait(btnDots);
        clickWait(btnCloseBoard);
        clickWait(btnClose);
        driver.navigate().refresh();
        clickWait(btnDots);
        clickWait(btnDeleteBoard);
        clickWait(btnDelete);
    }




}

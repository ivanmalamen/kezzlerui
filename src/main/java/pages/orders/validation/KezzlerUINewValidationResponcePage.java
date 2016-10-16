package pages.orders.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForElement;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by admin on 10/16/2016.
 */
public class KezzlerUINewValidationResponcePage {
    WebDriver driver;
    WaitForElement wait;
    String message;
    By newValidationSaveButton = By.xpath("//button[@id='save-button']");
    By newValidationNameInput = By.xpath("//input[@id='name']");
    By newValidationMessageInput = By.xpath("//div[contains(@class,'ng-pristine ng-valid ta-bind ng-touched')]");
    By newValidationMessageInputClosed = By.xpath("//text-angular[@id='web-message-input-field']");
    By newValidationTypeList = By.xpath("//select[@id='type']");
    By validationTableItem = By.xpath("//td[contains(.,'aa')]");
    By validationTable = By.xpath("//td[@data-title-text='Name']");


    public KezzlerUINewValidationResponcePage(WebDriver driver, WaitForElement wait, String message){
        this.driver = driver;
        this.wait = wait;
        this.message = message;

    }

    public void clickSaveButton() {
        wait.isElementLoaded(newValidationSaveButton, this.driver);
        driver.findElement(newValidationSaveButton).click();
    }


    public void enterName() {
        wait.isElementLoaded(newValidationNameInput, this.driver);
        driver.findElement(newValidationNameInput).sendKeys(message);
    }

    public void enterMessage() {

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_TAB);
        }
        catch (AWTException e)
        {}

                    wait.isElementLoaded(newValidationMessageInput, this.driver);
        driver.findElement(newValidationMessageInput).sendKeys(message);
    }

    public void selectType() {
        wait.isElementLoaded(newValidationTypeList, this.driver);
        Select select = new Select(driver.findElement(newValidationTypeList));
        select.selectByVisibleText("STANDARD");
    }



}

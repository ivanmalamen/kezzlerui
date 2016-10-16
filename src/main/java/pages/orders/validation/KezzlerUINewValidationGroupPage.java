package pages.orders.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForElement;

/**
 * Created by admin on 10/16/2016.
 */
public class KezzlerUINewValidationGroupPage {
    WebDriver driver;
    WaitForElement wait;
    String message;
    By newValidationGroupSaveButton = By.xpath("//button[@ng-click='save()']");
    By newValidationGroupNameInput = By.xpath("//input[@ng-model='group.name']");
    By newValidationGroupMessageInputClosed = By.xpath("//a[@class='select2-choice select2-default']");
    By newValidationGroupMessageInput = By.xpath("//input[@class='select2-input select2-focused']");



    public KezzlerUINewValidationGroupPage(WebDriver driver, WaitForElement wait, String message){
        this.driver = driver;
        this.wait = wait;
        this.message = message;

    }

    public void clickSaveButton() {
        wait.isElementLoaded(newValidationGroupSaveButton, this.driver);
        driver.findElement(newValidationGroupSaveButton).click();
    }


    public void enterName() {
        wait.isElementLoaded(newValidationGroupNameInput, this.driver);
        driver.findElement(newValidationGroupNameInput).sendKeys(message);
    }

    public void enterMessage() {
        wait.isElementLoaded(newValidationGroupMessageInputClosed, this.driver);
        driver.findElement(newValidationGroupMessageInputClosed).sendKeys(message);
    }

    public void selectType() {
        wait.isElementLoaded(newValidationGroupMessageInputClosed, this.driver);
        Select select = new Select(driver.findElement(newValidationGroupMessageInputClosed));
        select.selectByVisibleText(message);
    }



}

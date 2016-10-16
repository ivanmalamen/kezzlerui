package pages.orders.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

/**
 * Created by admin on 10/16/2016.
 */
public class KezzlerUIValidationResponcePage {
    WebDriver driver;
    WaitForElement wait;
    String message;
    By validationNewResponceButton = By.xpath("//a[@id='new-validation-response-button']");
    By validationTable = By.xpath("//td[@data-title-text='Name']");


    public KezzlerUIValidationResponcePage(WebDriver driver, WaitForElement wait, String message){
        this.driver = driver;
        this.wait = wait;
        this.message = message;

    }

    public void clickNewResponceButton() {
        wait.isElementLoaded(validationNewResponceButton, this.driver);
        driver.findElement(validationNewResponceButton).click();
    }

    public boolean checkCreatedValidationResponce() {
        By validationTableItem = By.xpath("//td[contains(.,'"+message+"')]");
        wait.isElementLoaded(validationTable, this.driver);
        try {
            driver.findElement(validationTableItem);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }



}

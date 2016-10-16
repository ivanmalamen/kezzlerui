package pages.orders.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

/**
 * Created by admin on 10/16/2016.
 */
public class KezzlerUIValidationGroupsPage {
    WebDriver driver;
    WaitForElement wait;
    String group;
    By validationGroupAddButton = By.xpath("//a[@href='#/kcengine/ati-group/add']");
    By validationGroupTable = By.xpath("//td[@data-title-text='Name']");


    public KezzlerUIValidationGroupsPage(WebDriver driver, WaitForElement wait, String group){
        this.driver = driver;
        this.wait = wait;
        this.group = group;

    }

    public void clickAddButton() {
        wait.isElementLoaded(validationGroupAddButton, this.driver);
        driver.findElement(validationGroupAddButton).click();
    }

    public boolean checkCreatedValidationResponce() {
        By validationTableItem = By.xpath("//td[contains(.,'"+ group +"')]");
        wait.isElementLoaded(validationGroupTable, this.driver);
        try {
            driver.findElement(validationTableItem);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }



}

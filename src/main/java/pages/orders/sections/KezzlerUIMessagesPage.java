package pages.orders.sections;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.WaitForElement;

public class KezzlerUIMessagesPage {
    WebDriver driver;
    WaitForElement wait;
    By messageAddMessageButton = By.xpath("//button[contains(.,' Add validation message')]");
    By messageSetGroupButton = By.xpath("//button[contains(.,' Set validation messages group')]");
    By messageAddButton = By.xpath("//button[@ng-click='addAti(ati.id)']");
    By messageAddGroupButton = By.xpath("//button[@ng-click='addAtiGroup(atiGroup.id)']");
    By messageInputClosed = By.xpath("//div[@class='select2-drop-mask']");
    By messageInput = By.xpath("//input[@class='select2-input select2-focused']");
    By messageTable = By.xpath("//td[@class='ng-binding']");
    String message;
    String group;

    public KezzlerUIMessagesPage(WebDriver driver, WaitForElement wait, String message, String group) {
        this.driver = driver;
        this.wait = wait;
        this.message = message;
        this.group = group;
    }

    public boolean checkMessagePage() {
        wait.isElementLoaded(messageAddMessageButton, this.driver);
        if (driver.findElement(messageAddMessageButton).getText().toLowerCase().equals("add validation message")) {
            return true;
        }
        return false;
    }

    public void clickAddMessageButton() {
        wait.isElementLoaded(messageAddMessageButton, this.driver);
        driver.findElement(messageAddMessageButton).click();
    }

    public void clickSetGroupButton() {
        wait.isElementLoaded(messageSetGroupButton, this.driver);
        driver.findElement(messageSetGroupButton).click();
    }

    public void clickEditButton() {
        wait.isElementLoaded(messageAddMessageButton, this.driver);
        driver.findElement(messageAddMessageButton).click();
    }

    public void clickAddButton() {
        wait.isElementLoaded(messageAddButton, this.driver);
        driver.findElement(messageAddButton).click();
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        catch(Exception ie){}
    }

    public void clickAddGroupButton() {
        wait.isElementLoaded(messageAddGroupButton, this.driver);
        driver.findElement(messageAddGroupButton).click();
    }

    public void clickInputClosed() {
        wait.isElementLoaded(messageInputClosed, this.driver);
        driver.findElement(messageInputClosed).click();
    }

    public void enterInputMessage() {
//        wait.isElementLoaded(messageInput, this.driver);
        wait.isElementLoaded(messageInputClosed, this.driver);
        Select select = new Select(driver.findElement(messageInputClosed));
        select.selectByVisibleText(message);
//        driver.findElement(messageInput).sendKeys(message);
//        driver.findElement(messageInput).sendKeys(Keys.ENTER);
    }

    public void enterInputGroup() {
        wait.isElementLoaded(messageInput, this.driver);
        driver.findElement(messageInput).sendKeys(group);
        driver.findElement(messageInput).sendKeys(Keys.ENTER);
    }




}

package pages.orders.orders;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUIOrdersPage {
    WebDriver driver;
    WaitForElement wait;
    String orderName;
    By ordersNewOrderButton = By.xpath("//button[@id='create-new-order']");
    By ordersNewOrderFrame = By.className("modal-dialog");
    By ordersNewOrderFrameCreateButton = By.xpath("//button[@id='create-order-button']");
    By ordersNewOrderFrameSectionedCheckbox = By.xpath("//input[@ng-model='neworder.sectioned']");
    By ordersNewOrderFrameNameInput = By.xpath("//input[@id='order-name-input']");
    By ordersNewOrderFrameTitle = By.xpath("//h4[@class='modal-title']");
    By ordersTitle = By.xpath("//h1[@class='page-header ng-scope']");
    By ordersReloadButton = By.xpath("//button[@ng-click='reload()']");
    By ordersRandom = By.xpath("//td[@class='kz-order-name ng-binding']");

    public KezzlerUIOrdersPage(WebDriver driver, WaitForElement wait, String OrderName) {
        this.driver = driver;
        this.wait = wait;
        this.orderName = OrderName;
    }

    public void clickNewOrder() {
        wait.isElementLoaded(ordersNewOrderButton, this.driver);
        driver.findElement(ordersNewOrderButton).click();
    }

    public void switchToActiveFrame() {
        driver.switchTo().activeElement();
    }

    public void enterNewOrderFrameName() {
        wait.isElementLoaded(ordersNewOrderFrameNameInput, this.driver);
        driver.findElement(ordersNewOrderFrameNameInput).sendKeys(orderName);
    }

    public void checkNewOrderFrameSectioned() {
        wait.isElementLoaded(ordersNewOrderFrameSectionedCheckbox, this.driver);
        driver.findElement(ordersNewOrderFrameSectionedCheckbox).click();
    }


    public void clickNewOrderFrameCreate() {
        wait.isElementLoaded(ordersNewOrderFrameCreateButton, this.driver);
        driver.findElement(ordersNewOrderFrameCreateButton).click();
    }

    public boolean checkOrdersPage() {
        wait.isElementLoaded(ordersNewOrderButton, this.driver);
        if (driver.findElement(ordersNewOrderButton).getText().toLowerCase().equals("new order")) {
            return true;
        }
        return false;
    }


    public String getNewOrderFrameTitle() {
        wait.isElementLoaded(ordersNewOrderFrameTitle, this.driver);
        return driver.findElement(ordersNewOrderFrameTitle).getText();
    }

    public void clickOrdersOrderName() {
        By ordersOrderName = By.xpath("//td[contains(.,'" + orderName + "')]");
        wait.isElementLoaded(ordersOrderName, this.driver);
        driver.findElement(ordersOrderName).click();
    }

    public String getRandomOrderName() {
        wait.isElementLoaded(ordersRandom, this.driver);
        return driver.findElement(ordersRandom).getText();
    }


}

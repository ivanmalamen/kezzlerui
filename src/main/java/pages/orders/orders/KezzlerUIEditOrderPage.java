package pages.orders.orders;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUIEditOrderPage {
    WebDriver driver;
    WaitForElement wait;
    String productName;
    String productSchemaName;
    By orderTitle = By.xpath("//h1[@class='page-header ng-binding ng-scope']");
    By orderLockButton = By.xpath("//button[@id='lock-order-button']");
    By orderSaveButton = By.xpath("//button[@id='edit-order-save-button']");
    By orderProductMenu = By.xpath("//select[@id='product']");
    By orderProductSchemaMenu = By.xpath("//select[@id='metadataSchema']");


    public KezzlerUIEditOrderPage(WebDriver driver, WaitForElement wait, String productName, String productSchemaName) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.productSchemaName = productSchemaName;
    }

    public boolean checkEditOrderPage() {
        wait.isElementLoaded(orderSaveButton, this.driver);
        if (driver.findElement(orderSaveButton).getText().toLowerCase().equals("save")) {
            return true;
        }
        return false;
    }

    public void clickOrderLockButton() {
        wait.isElementLoaded(orderLockButton, this.driver);
        driver.findElement(orderLockButton).click();
    }

    public void clickOrderSaveButton() {
        wait.isElementLoaded(orderSaveButton, this.driver);
        driver.findElement(orderSaveButton).click();
    }

    public void insertProductName() {
        wait.isElementLoaded(orderProductMenu, this.driver);
        driver.findElement(orderProductMenu).click();
        driver.findElement(orderProductMenu).sendKeys(productName);
        driver.findElement(orderProductMenu).sendKeys(Keys.ENTER);

    }


    public void insertProductSchemaName() {
        wait.isElementLoaded(orderProductSchemaMenu, this.driver);
        driver.findElement(orderProductSchemaMenu).click();
        driver.findElement(orderProductSchemaMenu).sendKeys(productSchemaName);
        driver.findElement(orderProductSchemaMenu).sendKeys(Keys.ENTER);
    }

}

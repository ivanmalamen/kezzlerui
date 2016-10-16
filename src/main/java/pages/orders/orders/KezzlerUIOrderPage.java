package pages.orders.orders;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitForElement;

import java.util.List;

public class KezzlerUIOrderPage {
    WebDriver driver;
    WaitForElement wait;
    String productName;
    String productSchemaName;
    By orderSectioned = By.xpath("//div[@class='col-sm-4 ng-binding']");
    By orderDetails = By.xpath("//div[@class='panel-body']");
    By orderEditButton = By.xpath("//a[@id='edit-order-button']");
    By orderCodesButton = By.xpath("//a[@id='code-order-button']");
    By orderRecallButton = By.xpath("//button[@ng-click='recall(id)']");
    By orderPermissionsButton = By.xpath("//button[@ng-click='showPermissionsDialog()']");
    By orderAccessor = By.xpath("//th[contains(.,'Accessor')]");
    By orderSectionsButton = By.xpath("//a[@kz-restrict-disable='ROLE_SECTION_MANAGER']");
    By orderCodeStatisticsButton = By.xpath("//a[@kz-restrict-disable='ROLE_ORDER_STATISTICS_VIEWER']");
    By orderCodeStatisticsTitle = By.xpath("//div[@class='alert alert-info ng-scope']");


    public KezzlerUIOrderPage(WebDriver driver, WaitForElement wait, String productName, String productSchemaName) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
        this.productSchemaName = productSchemaName;
    }

    public void switchToActiveFrame() {
        driver.switchTo().activeElement();
    }

    public boolean checkOrderPage() {
        wait.isElementLoaded(orderEditButton, this.driver);
        if (driver.findElement(orderEditButton).getText().toLowerCase().equals("edit")) {
            return true;
        }
        return false;
    }

    public String checkOrderSectioned() {
        wait.isElementLoaded(orderDetails, this.driver);
        WebElement container = driver.findElement(orderDetails);
        List<WebElement> rows = container.findElements(orderSectioned);
        for (WebElement row : rows) {
            String text = row.getText();
            if (text.equals("yes") || text.equals("no")) {
                return text;
            }
        }

        return "fail";
    }

    public boolean checkOrderProduct() {
        wait.isElementLoaded(orderDetails, this.driver);
        WebElement container = driver.findElement(orderDetails);
        List<WebElement> rows = container.findElements(orderSectioned);
        for (WebElement row : rows) {
            String text = "";
            try {
                text = row.getText();
            } catch (Exception e) {
            }
            if (text.contains("TestProduct")) {
                return true;
            }
        }

        return false;
    }


    public boolean checkOrderProductSchema() {
        wait.isElementLoaded(orderDetails, this.driver);
        WebElement container = driver.findElement(orderDetails);
        List<WebElement> rows = container.findElements(orderSectioned);
        for (WebElement row : rows) {
            String text = "";
            try {
                text = row.getText();
            } catch (Exception e) {
            }
            if (text.contains("TestProductSchema")) {
                return true;
            }
        }

        return false;
    }

    public void clickOrderEditButton() {
        wait.isElementLoaded(orderEditButton, this.driver);
        driver.findElement(orderEditButton).click();
    }

    public void clickOrderPermissionsButton() {
        wait.isElementLoaded(orderPermissionsButton, this.driver);
        driver.findElement(orderPermissionsButton).click();
    }

    public void clickOrderCodeStatisticsButton() {
        wait.isElementLoaded(orderCodeStatisticsButton, this.driver);
        driver.findElement(orderCodeStatisticsButton).click();
    }

    public void clickOrderCodesButton() {
        wait.isElementLoaded(orderCodesButton, this.driver);
        driver.findElement(orderCodesButton).click();
    }

    public void clickOrderSectionsButton() {
        wait.isElementLoaded(orderSectionsButton, this.driver);
        driver.findElement(orderSectionsButton).click();
    }


    public boolean checkOrderLocked() {
        wait.isElementLoaded(orderDetails, this.driver);
        WebElement container = driver.findElement(orderDetails);
        List<WebElement> rows = container.findElements(By.xpath("//div[@class='col-sm-4']"));
        boolean status = false;
        for (WebElement row : rows) {
            try {
                WebElement locker = row.findElement(By.xpath("//i[@class='fa fa-lock']"));
                status = locker.isDisplayed();
            } catch (Exception ie) {
            }
            return status;
        }
        return status;
    }

    public boolean checkOrderRecall() {
        wait.isElementLoaded(orderEditButton, this.driver);
        try {
            driver.findElement(orderRecallButton);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public boolean checkOrderPermissions() {
        wait.isElementLoaded(orderEditButton, this.driver);
        try {
            driver.findElement(orderAccessor);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

    public boolean checkOrderCodeStatistics() {
        try {
            driver.findElement(orderCodeStatisticsTitle);
            return true;
        } catch (Exception ie) {
            return false;
        }
    }

}

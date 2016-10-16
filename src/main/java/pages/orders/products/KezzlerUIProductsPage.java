package pages.orders.products;

/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitForElement;

import java.util.List;

public class KezzlerUIProductsPage {
    WebDriver driver;
    WaitForElement wait;
    By productsTitle = By.xpath("//h1[contains(.,'Products')]");
    By productsList = By.xpath("//td[@data-title-text='Name']");
    By productsNewProductButton = By.xpath("//a[@id='add-new-product-button']");
    By products100Button = By.xpath("//button[contains(.,' 100 ')]");
    String productName;

    public KezzlerUIProductsPage(WebDriver driver, WaitForElement wait, String productName) {
        this.driver = driver;
        this.wait = wait;
        this.productName = productName;
    }

    public void clickProductsNewProductButton() {
        wait.isElementLoaded(productsNewProductButton, this.driver);
        driver.findElement(productsNewProductButton).click();
    }

    public void clickProducts100Button() {
        wait.isElementLoaded(products100Button, this.driver);
        driver.findElement(products100Button).click();
    }

    public boolean checkProductsPage() {
        wait.isElementLoaded(productsNewProductButton, this.driver);
        if (driver.findElement(productsNewProductButton).getText().toLowerCase().equals("new product")) {
            return true;
        }
        return false;
    }


    public boolean checkAddedProduct() {
        wait.isElementLoaded(productsList, this.driver);
        List<WebElement> names = driver.findElements(productsList);
        for (WebElement name : names) {
            String text = "";
            try {
                text = name.getText();
            } catch (Exception e) {
            }
            if (text.equals(productName)) {
                return true;
            }
        }
        return false;
    }


}

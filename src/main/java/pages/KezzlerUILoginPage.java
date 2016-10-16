package pages;
/**
 * Created by admin on 10/15/2016.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitForElement;

public class KezzlerUILoginPage {
    WebDriver driver;
    WaitForElement wait;
    By userName = By.xpath("//input[@id='username']");
    By password = By.id("password");
    By login = By.id("sign-in-button");


    public KezzlerUILoginPage(WebDriver driver, WaitForElement wait) {
        this.driver = driver;
        this.wait = wait;

    }

    public void setUserName(String strUserName) {
        wait.isElementLoaded(userName, this.driver);
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        wait.isElementLoaded(password, this.driver);
        driver.findElement(password).sendKeys(strPassword);
    }

    public void clickLogin() {
        wait.isElementLoaded(login, this.driver);
        driver.findElement(login).click();
    }

    public void loginToKezzlerUI(String strUserName, String strPassword) {
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();

    }
}


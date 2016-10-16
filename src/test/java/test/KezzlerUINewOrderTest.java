package test;

/**
 * Created by admin on 10/15/2016.
 */

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import pages.orders.orders.KezzlerUIOrderPage;
import pages.orders.orders.KezzlerUIOrdersPage;
import utils.Sleep;
import utils.WaitForElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KezzlerUINewOrderTest {

    static WebDriver driver;
    static KezzlerUILoginPage objLoginPage;
    static KezzlerUIRollActivatorPage objRollActivatorPage;
    private static WaitForElement wait = new WaitForElement();
    KezzlerUIMainMenu objMainMenu;
    KezzlerUIOrdersPage objOrdersPage;
    KezzlerUIOrderPage objOrderPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "GeckoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://core.dev.kezzler.net/#/security/login");
        objLoginPage = new KezzlerUILoginPage(driver, wait);
        objLoginPage.loginToKezzlerUI("ivanmalamen", "7JyzfqZs");
        objRollActivatorPage = new KezzlerUIRollActivatorPage(driver, wait);

    }

    @Test()
    public void test1OrdersPageAppear() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickOrders();
        Sleep.sleep(1000);
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, "");
        Assert.assertTrue(objOrdersPage.checkOrdersPage());
    }

    @Test()
    public void test2CreateNewNonSectionedOrder() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickOrders();
        Sleep.sleep(1000);
        Random random = new Random();
        String orderName = "testOrder" + Integer.toString(random.nextInt());
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, orderName);
        objOrdersPage.clickNewOrder();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        Assert.assertTrue(objOrdersPage.getNewOrderFrameTitle().toLowerCase().contains("new order"));
        objOrdersPage.enterNewOrderFrameName();
        Sleep.sleep(1000);
        objOrdersPage.clickNewOrderFrameCreate();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objOrdersPage.clickOrdersOrderName();
        Sleep.sleep(1000);
        objOrderPage = new KezzlerUIOrderPage(driver, wait, "", "");
        Assert.assertTrue(objOrderPage.checkOrderSectioned().toLowerCase().contains("no"));

    }

    @Test()
    public void test3CreateNewSectionedOrder() {
        objMainMenu = new KezzlerUIMainMenu(driver, wait);
        objMainMenu.clickSerialization();
        Sleep.sleep(1000);
        objMainMenu.clickOrders();
        Sleep.sleep(1000);
        Random random = new Random();
        String orderName = "testOrder" + Integer.toString(random.nextInt());
        objOrdersPage = new KezzlerUIOrdersPage(driver, wait, orderName);
        objOrdersPage.clickNewOrder();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        Assert.assertTrue(objOrdersPage.getNewOrderFrameTitle().toLowerCase().contains("new order"));
        objOrdersPage.enterNewOrderFrameName();
        Sleep.sleep(1000);
        objOrdersPage.checkNewOrderFrameSectioned();
        Sleep.sleep(1000);
        objOrdersPage.clickNewOrderFrameCreate();
        Sleep.sleep(1000);
        objOrdersPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objOrdersPage.clickOrdersOrderName();
        Sleep.sleep(1000);
        objOrderPage = new KezzlerUIOrderPage(driver, wait, "", "");
        Assert.assertTrue(objOrderPage.checkOrderSectioned().toLowerCase().contains("yes"));

    }

    @After
    public void kill() {
        driver.quit();
    }


}

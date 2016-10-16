package test;

/**
 * Created by admin on 10/15/2016.
 */

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;
import pages.orders.sections.KezzlerUICodesPage;
import pages.orders.orders.KezzlerUIEditOrderPage;
import pages.orders.orders.KezzlerUIOrderPage;
import pages.orders.orders.KezzlerUIOrdersPage;
import utils.Sleep;
import utils.WaitForElement;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KezzlerUIOrderCodesTest {

    static WebDriver driver;
    static KezzlerUILoginPage objLoginPage;
    static KezzlerUIRollActivatorPage objRollActivatorPage;
    private static WaitForElement wait = new WaitForElement();
    KezzlerUIMainMenu objMainMenu;
    KezzlerUIOrdersPage objOrdersPage;
    KezzlerUICodesPage objCodesPage;
    KezzlerUIOrderPage objOrderPage;
    KezzlerUIEditOrderPage objOrderEditPage;

    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "GeckoDriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("https://core.dev.kezzler.net/#/security/login");
        objLoginPage = new KezzlerUILoginPage(driver, wait);
        objLoginPage.loginToKezzlerUI("ivanmalamen", "7JyzfqZs");
        objRollActivatorPage = new KezzlerUIRollActivatorPage(driver, wait);
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
        objOrderPage.clickOrderCodesButton();
    }

    @Test()
    public void test1CheckOrderCodesPage() {
        objCodesPage = new KezzlerUICodesPage(driver, wait, "", "", "", "");
        Assert.assertTrue(objCodesPage.checkCodesPage());
    }

    @Test()
    public void test2CheckOrderCodesTopUp() {
        objCodesPage = new KezzlerUICodesPage(driver, wait, "10", "test", "", "");
        objCodesPage.clickTopUpButton();
        Sleep.sleep(1000);
        objCodesPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameSize();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameName();
        Sleep.sleep(1000);
        objCodesPage.clickTopUpFrameTopUpButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objCodesPage.checkAddedCode());
    }


    @Test()
    public void test3CheckOrderCodesAdministrativeTopUp() {
        objCodesPage = new KezzlerUICodesPage(driver, wait, "10", "test", "", "");
        objCodesPage.clickTopUpButton();
        Sleep.sleep(1000);
        objCodesPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameSize();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameName();
        Sleep.sleep(1000);
        objCodesPage.clickTopUpFrameAdvancedButton();
        Sleep.sleep(1000);
        objCodesPage.checkTopUpFramePairCheckbox();
        Sleep.sleep(1000);
        objCodesPage.clickTopUpFrameTopUpButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objCodesPage.checkAddedAdministrativeCode());
    }

    @Test()
    public void test4CheckOrderCodesUpload() {
        objCodesPage = new KezzlerUICodesPage(driver, wait, "10", "test", "Upload", "Upload\\upload.exe");
        objCodesPage.clickUploadButton();
        Sleep.sleep(1000);
        objCodesPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objCodesPage.clickUploadFrameBrowseButton();
        Sleep.sleep(3000);
        objCodesPage.generateUploadCodeCSV();
        objCodesPage.runUploadFrameUploadScript();
        Sleep.sleep(1000);
        objCodesPage.clickUploadFrameUploadButton();
        Sleep.sleep(3000);
        objCodesPage.switchToActiveFrame();

        Assert.assertTrue(objCodesPage.checkUploadedCode());
    }

    @Test()
    public void test5CheckTableCodesBehaviour() {
        test2CheckOrderCodesTopUp();
        objCodesPage = new KezzlerUICodesPage(driver, wait, "15", "test1", "Upload", "Upload\\upload.exe");
        objCodesPage.clickTableTopUpButton();
        Sleep.sleep(1000);
        objCodesPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameSize();
        Sleep.sleep(1000);
        objCodesPage.enterTopUpFrameName();
        Sleep.sleep(1000);
        objCodesPage.clickTopUpFrameTopUpButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objCodesPage.checkAddedCode());
        objCodesPage.clickTableStatusButton();
    }

    @Test()
    public void test6CheckQRGeneration() {
        test2CheckOrderCodesTopUp();
        objCodesPage = new KezzlerUICodesPage(driver, wait, "15", "test1", "Upload", "Upload\\upload.exe");
        objCodesPage.clickCheckCodeButton();
        Sleep.sleep(1000);
        objCodesPage.switchToActiveFrame();
        Sleep.sleep(1000);
        objCodesPage.enterCheckCodeFrameIndex();
        Sleep.sleep(1000);
        objCodesPage.clickCheckCodeFrameGetCodeButton();
        Sleep.sleep(1000);
        Assert.assertTrue(objCodesPage.checkGeneratedQR());
    }

    @Test()
    public void test7CheckOrderCodeStatusStatistic() {
        objCodesPage = new KezzlerUICodesPage(driver, wait, "15", "test1", "Upload", "Upload\\upload.exe");
        objCodesPage.clickBackButton();
        Sleep.sleep(1000);
        objOrderPage = new KezzlerUIOrderPage(driver, wait, "", "");
        objOrderPage.clickOrderCodeStatisticsButton();
        Sleep.sleep(1000);
        objOrderPage.switchToActiveFrame();
        Sleep.sleep(1000);
        Assert.assertTrue(objOrderPage.checkOrderCodeStatistics());
    }

    @After
    public void kill() {

        driver.close();
        driver.quit();
    }

}

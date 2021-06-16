package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void launchApp(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);
    }

    @DataProvider(name = "fetchExcelData")
    public Object[][] testDataFromExcel() throws IOException, InvalidFormatException {
        return utils.ExcelReader.readFile("src/main/resources/Testdata.xlsx");
    }


    /*public static void main(String[] args) throws InterruptedException {
        BaseClass base = new BaseClass();
        base.launchApp();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        System.out.println("Logged in..");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='dashboard-quick-launch-panel-container']//span[text()='My Leave']")).click();
        Thread.sleep(3000);
        String tabText = driver.findElement(By.xpath("//li[@class='selected']/a")).getText();
        System.out.println(tabText);
    }*/

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}

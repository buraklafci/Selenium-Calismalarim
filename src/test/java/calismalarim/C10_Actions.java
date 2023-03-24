package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C10_Actions {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
// https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
//          2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
// Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement isim=driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(isim).sendKeys("Berk").
          sendKeys(Keys.TAB).sendKeys("Karanfil").
           sendKeys(Keys.TAB).sendKeys("5345625363").
             sendKeys(Keys.TAB).sendKeys("234234").
             sendKeys(Keys.TAB).sendKeys(Keys.TAB).
              sendKeys("2").sendKeys(Keys.TAB).
                sendKeys("Mar").sendKeys(Keys.TAB).
                sendKeys("1991").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).perform();



    // Kaydol tusuna basalim
        actions.sendKeys(Keys.ENTER).perform();
    }
    @AfterClass
    public void tearDown() {

         driver.quit();
    }
}
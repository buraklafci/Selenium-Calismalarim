package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C20_Summary {
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
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
       driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        WebElement iframeGiris=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframeGiris);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3. “Cameras product”i tiklayin
        driver.findElement(By.xpath("//p[text()='Cameras']")).click();
        //4. Popup mesajini yazdirin

        //********************implicitly yerine explicitly kullanildi
        //specific sure atilmasi gerekiyo,mesajin gorunurlugu icin
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement mesaj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        System.out.println(mesaj.getText());
        //5. “close” butonuna basin
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        //iframe'den cikis yapmamiz gerekiyor(iframe tag'i icerisinde degil)
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame(); tek iframe icindeysen ayni gorevi gorur
        driver.findElement(By.cssSelector("#nav-title")).click();
        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        WebElement newPage=driver.findElement(By.xpath("//h1[@style='color:#f45950;']"));
        Assert.assertTrue(newPage.isDisplayed());
    } @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
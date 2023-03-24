package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C08_WindowHandle {
    WebDriver driver;
    SoftAssert softAssert;
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
//● Amazon anasayfa adresine gidin.
       driver.get("https://www.amazon.com");
//            ● Sayfa’nin window handle degerini String bir degiskene atayin
        String handle=driver.getWindowHandle();
//● Sayfa title’nin “Amazon” icerdigini test edin
        SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue(driver.getTitle().contains("Amazon"),"sayfa basligi Amazon icermiyor");
//● Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");
        String handle2=driver.getWindowHandle();
//● Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("TECHPROEDUCATION"),"sayfa basligi TECHPROEDUCATION icermiyor");
//● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
//● Sayfa title’nin “Walmart” icerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Walmart"),"sayfa basligi Walmart icermiyor");
//● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(handle);


    }//2. ve 3. reqirement'da beklenen hatali sonuc veriyor
    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }
}
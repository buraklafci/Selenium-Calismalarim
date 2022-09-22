package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C05_SoftAssert {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {
//	“https://www.hepsiburada.com/” Adresine gidin
        driver.get("https://www.hepsiburada.com/");
        softAssert=new SoftAssert();
//          2.	Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
        String actualTitle=driver.getTitle();
        String expectedTitle="Türkiye'nin En Büyük Online Alışveriş";
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"beklenilen sayfa basligi icermiyor");
//          3.	search kutusuna araba yazip arattirin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("araba", Keys.ENTER);
//	bulunan sonuc sayisini yazdirin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement sonucWE =driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']"));
        String sonucSayisi=sonucWE.getText();
//	sonuc yazisinin "araba" icerdigini dogrulayin
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement actualWE=driver.findElement(By.xpath("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']"));
        String actual=actualWE.getText();
        String expected="araba";
        softAssert.assertTrue(actual.contains(expected));
//	Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(actual.contains("oto"));

    }
    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        driver.close();
    }
}

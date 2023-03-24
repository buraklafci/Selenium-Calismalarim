package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C01_Ddm {
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

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void amazonTest() {

//● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com");
//            - Test 1
//    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28
//    oldugunu test edin
        List<WebElement> ddmList = driver.findElements(By.cssSelector("#searchDropdownBox"));
        int ddmSayisi = ddmList.size();
        softAssert = new SoftAssert();
        softAssert.assertEquals(ddmSayisi, 28, "ddmSayisi beklenenden farklidir");
    }
        @Test
        public void amazonTest2() {
            driver.get("https://www.amazon.com");

//            1. Kategori menusunden Books secenegini secin
            WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
            Select select=new Select(ddm);
           select.selectByVisibleText("Books");
            //select.selectByValue("search-alias=stripbooks-intl-ship");
//2. Arama kutusuna Java yazin ve aratin
            driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
//3. Bulunan sonuc sayisini yazdirin
            System.out.println(driver.findElement(By.xpath("//span[text()='1-16 of over 30,000 results for']")).getText());
//4. Sonucun Java kelimesini icerdigini test edin
            String actual=driver.findElement(By.xpath("//span[text()='\"Java\"']")).getText();
            String expected="Java";
            softAssert.assertTrue(actual.contains(expected),"Java icermiyor");

    }
}
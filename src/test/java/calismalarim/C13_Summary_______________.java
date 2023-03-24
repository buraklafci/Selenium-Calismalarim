package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C13_Summary_______________ {
    WebDriver driver;
    SoftAssert softAssert;
    Select select;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test()
    public void test1() {
//            1- amazon gidin
        driver.get("https://www.amazon.com");
//2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        //1.yol
        List<WebElement> ddmList=driver.findElements(By.cssSelector("#searchDropdownBox"));
        ddmList.forEach(t-> System.out.println(t.getText()));
        //System.out.println(ddmList.size()); select objesi kullanmadan sonuc yanlis olur
        System.out.println("*************************");

        //2.yol
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        select=new Select(ddm);
        List<WebElement> list=select.getOptions();
        list.forEach(t-> System.out.println(t.getText()));
//3- dropdown menude 28 eleman olduğunu doğrulayın
        //listeyi iki turlu yazdirabiliriz AMA SIZE'I ICIN SELECT OBJESINI KULLANIP GetOptions() ILE
        //LISTEYE ATIP ONUN SIZE'INI ALMAMIZ GEREKIR YOKSA(1.YOLDAKI GIBI OLURSA) SONUC 1 GELIR
        System.out.println("listenin size'i:"+list.size());
        softAssert=new SoftAssert();
        softAssert.assertEquals(list.size(),28);
    }

    @Test()
    public void test2() {
        driver.get("https://www.amazon.com");
        //1- dropdown menuden elektronik bölümü seçin
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        select=new Select(ddm);
        select.selectByVisibleText("Electronics");
//2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
//3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String actual=driver.findElement(By.xpath("//span[text()='\"iphone\"']")).getText();
        actual=actual.replaceAll("\\W","");
        softAssert.assertEquals(actual,"iphone");
//4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciUrrun=driver.findElement(By.xpath("(//img[@data-image-index='1'])[1]"));
        WebElement ucuncuUrun=driver.findElement(By.xpath("(//img[@data-image-index='3'])[1]"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(birinciUrrun)
                .toLeftOf(ucuncuUrun));
        ikinciUrun.click();

//5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        String ikinciUrunTitle=driver.findElement(By.cssSelector("#productTitle")).getText();
        String ikinciUrunFiyat=driver.findElement(By.cssSelector("#corePrice_feature_div")).getText();
        WebElement sepeteEkle=driver.findElement(By.cssSelector("[id='buy-now-button']"));
        sepeteEkle.click();
        driver.navigate().back();
    }

    @Test()
    public void test3() {

//1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
//2-dropdown’dan bebek bölümüne secin
        WebElement ddm=driver.findElement(By.cssSelector("#searchDropdownBox"));
        select=new Select(ddm);
        select.selectByVisibleText("Baby");
//3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("bebek puset", Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//span[text()='5 results for']")).getText());
//4-sonuç yazsının puset içerdiğini test edin
        String sonucPuset = driver.findElement(By.xpath("//span[text()='\"bebek puset\"']")).getText();
        softAssert.assertTrue(sonucPuset.contains("puset"));
//5-üçüncü ürüne tıklayin
        driver.findElement(By.xpath("(//*[@class='s-image'])[3]")).click();
//6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String ucuncuUrunTitle=driver.findElement(By.cssSelector("#productTitle")).getText();
        String ucuncuUrunFiyat=driver.findElement(By.xpath("//div[@class='a-section a-spacing-none aok-align-center']")).getText();
        WebElement sepeteEkle=driver.findElement(By.cssSelector("[id='buy-now-button']"));
        sepeteEkle.click();
        driver.navigate().back();
//    Test 4
//            1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
    @AfterClass
    public void tearDown() {
       softAssert.assertAll();
      //  driver.quit();
    }}

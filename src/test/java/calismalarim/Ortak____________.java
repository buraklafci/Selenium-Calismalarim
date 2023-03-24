package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ortak____________ {
    WebDriver  driver;
    Actions action=new Actions(driver);
    static String  urunTitle;

    @BeforeClass
    public  void beforeClass() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

   }

   @AfterClass
   public void tearDown() throws Exception {
       driver.close();
   }

   @Test
   public void Test(){

       //     1. Amazon sayfasını acalım
       driver.get("https://www.amazon.com");

       //     2. sayfanın acıldıgını dogrulayalım

       String actual=driver.getTitle();
       String expected="Amazon.com.tr";
       Assert.assertTrue(actual.contains(expected));
       driver.findElement(By.name("accept")).click();


       //     3.header daki sigin butonuna basalım
       bekle(3);
       WebElement headerAccountButton=driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));
       action.moveToElement(headerAccountButton).perform();
       bekle(2);
       driver.findElement(By.xpath("(//span[text()='Giriş yap'])[1]")).click();

       //     4. kullanıc adı ve şifre bilgisini girerek login olalım
       driver.findElement(By.xpath("//input[@name=\"email\" and @id=\"ap_email\"]")).sendKeys("suat_oruc@yahoo.com");
       driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
       driver.findElement(By.xpath("//input[@id=\"ap_password\"]")).sendKeys("Amazon115436-");
       driver.findElement(By.cssSelector("[id=\"signInSubmit\"]")).submit();

       //     5. başarılı bir şekilde login oldugumuzu dogrulayalım.
       WebElement account=driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));
       action.moveToElement(account).perform();
       bekle(2);
       Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Çıkış Yap']")).isDisplayed());

       //     6. header da account butonu altında create a list butonuna basalım
       WebElement listeoluturButton=driver.findElement(By.xpath("//span[text()='Liste Oluşturun']"));
       listeoluturButton.click();


       //     7. create a list sayfasının açıldıgını dogrulayalım
       Assert.assertTrue( driver.findElement(By.className("a-button-input")).isDisplayed());

       //     8.sayfada bulunan create a list butonuna basalım
       driver.findElement(By.className("a-button-input")).click();

       //     9.açılan popup menuden oluşturacagımız listenin adını girelim ve create a list butonuna basalım
       driver.findElement(By.cssSelector("[id=\"list-name\"]")).clear();
       driver.findElement(By.cssSelector("[id=\"list-name\"]")).sendKeys("Team09");
       driver.findElement(By.xpath("(//input[@id=\"list-name\"]//following::*)[18]")).click();

       //     10. listemin başarılı bir şekilde oluştugunu dogrulayalım

       String actualListTitle=driver.findElement(By.xpath("(//div[@class=\"wl-list-entry-row-wrapper\"])[1]")).getText();
       Assert.assertEquals("Team09",actualListTitle);


       //     11. kategori bölümünden computers seçilir
       WebElement kategori=driver.findElement(By.cssSelector("[id=\"searchDropdownBox\"]"));
       Select select=new Select(kategori);
       select.selectByVisibleText("Bilgisayarlar");


       //     12. kategori bolumnde computer seçili oldugunu dogrulayım
       String actualKategori=select.getFirstSelectedOption().getText();
       Assert.assertEquals("Bilgisayarlar",actualKategori);

       //     13. arama kutusuna msi yazıp aratalım
       driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]")).sendKeys("msi"+ Keys.ENTER);

       //     14. arama kutusunda msi arandığını dogrulayalım
       String actualResult=driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"]")).getText();
       System.out.println(actualResult);
       actualResult=actualResult.replaceAll("\"","");
       Assert.assertEquals("msi",actualResult);


       //     15. gelen ürün sayfasında 2. sayfaya gecelim

       String actualURl=driver.getCurrentUrl();
       actualURl=actualURl.replace("computers&","computers&page=2&");
       driver.get(actualURl);



       //     16. 2. sayfadaki 2. urunu secelim
       urunsec(2);

       //     17. acılan sayfada gelen urunun 2. urun oldugunu dogrulayalım
       bekle(3);
       String actualproductTitle=driver.findElement(By.xpath("//span[@id=\"productTitle\"]")).getText();

       Assert.assertEquals(urunTitle,actualproductTitle);

       //     18. urunu listemize ekleyelim
       driver.findElement(By.cssSelector("[id=\"add-to-wishlist-button\"]")).click();
       bekle(2);
       driver.findElement(By.cssSelector("[class=\"a-size-small atwl-hz-dd-list-name a-nowrap\"]")).click();
       bekle(2);
       Assert.assertTrue(driver.findElement(By.xpath("//span[text()='1 ürün şuraya eklendi:']")).isDisplayed());

       //     19. listemizi açalım
       driver.findElement(By.xpath("//a[text()=\"Listenizi Görüntüleyin\"]")).click();

       //     20. listemizdeki urunumuzu silelim
       bekle(2);
       driver.findElement(By.name("submit.deleteItem")).click();

       //     21. listemizdeki urunumuzun silindigi dogrulayaım
       Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Silindi']")).isDisplayed());

       //     22. siteden logout olalım
       Actions action1=new Actions(driver);
       bekle(2);

       WebElement account1=driver.findElement(By.cssSelector("[id=\"nav-link-accountList\"]"));
       action1.moveToElement(account1).perform();
       bekle(2);
       driver.findElement(By.xpath("//span[text()='Çıkış Yap']")).click();

       //     23. logout dogrulayalım.
       bekle(2);
       Assert.assertTrue(driver.getTitle().contains("Giriş Yap"));



   }

   private void urunsec(int urun) {
       String path="(//div[@class=\"a-section a-spacing-small puis-padding-left-small puis-padding-right-small\"]//h2)["+urun+"]";
       urunTitle= driver.findElement(By.xpath(path)).getText();
       driver.findElement(By.xpath(path)).click();
   }


    public void bekle(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }


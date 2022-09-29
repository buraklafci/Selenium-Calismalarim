package practice_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C05 {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        // driver.quit();
    }

    @Test
    public void alert1() {

        // 1- "http://webdriveruniversity.com/Popup-Alerts/index.html"  adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        // 2- CLICK ME of JavaScript Alert e tiklayin
        driver.findElement(By.id("button1")).click();
        // 3- pop up text i alin
        String message = driver.switchTo().alert().getText();
        // 4- Mesajin "I am an alert box!"  oldugunu dogrulayin.
        String expMessage = "I am an alert box!";
        softAssert.assertTrue(message.equals(expMessage));
        // 5- pop up i kabul edin
        driver.switchTo().alert().accept();


    }
        @Test(dependsOnMethods = "alert1")
        public void alert2 () {

            // Yine ayni class da baska bir test methodu olusturun
            // 1- "http://webdriveruniversity.com/Popup-Alerts/index.html"  adresine gidin
            driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
            // 2- CLICK ME of JavaScript Confirm Box i TIKLAYIN
             //Alert alert=driver.switchTo().alert(); //==> Alert alert=...  diye baslamasak da olur   driver.switchTo().alert();  seklinde de.
            driver.findElement(By.xpath("(//p[text()='CLICK ME!'])[3]")).click();
            //alert.getText();
            // 3- pop up text i alin
            String message=driver.switchTo().alert().getText();
            // 4- Mesajin "Press a button!" oldugunu dogrulayin
            String expMessage="Press a button!";
            softAssert.assertTrue(message.equals(expMessage));
            // 5- Acilir pencereyi kapat,pop up i iptal edin,
            //alert.dismiss(); //2.way
           driver.switchTo().alert().dismiss();
            // 6- "You pressed Cancel!"  yazisinin goruntulendigini dogrulayin
            softAssert.assertTrue(driver.findElement(By.xpath("//p[@id='confirm-alert-text']")).isDisplayed());
            // 7- alert1'e gore dependsOnMethods kullanin


             /*
        Alert alert=driver.switchTo().alert();  ==> bu sekilde de kullanimi mevcuttur
        alert variable ile methodlara ulasilabilir
        alert.dismiss();
        alert.getText();
        alert.accept();   vb
        bu kullanim sayesinde switchto() yazmamiza gerek kalmaz
         */
        }
    }

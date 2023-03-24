package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03_Alert {
    WebDriver driver;
    WebElement sonucYazisiElementi;
    SoftAssert softAssert;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void acceptAlertTesti1() {
        //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin. ● Bir metod olusturun: dismissAlert
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       driver.switchTo().alert().accept();

        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));

        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        softAssert=new SoftAssert();
        softAssert.assertEquals(actualSonucYazisi, expectedSonucYazisi);


    }
 @Test
 public void dismissAlertTesti1() {
     // butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin. ● Bir metod olusturun: sendKeysAlert
     driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
     driver.switchTo().alert().dismiss();

     sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
     String actualSonucYazisiElemennti=sonucYazisiElementi.getText();
     String istenmeyenKelime="successfuly";
     softAssert=new SoftAssert();
     softAssert.assertFalse(actualSonucYazisiElemennti.contains(istenmeyenKelime));

 }
 @Test
 public void AlertTesti1() {
     // butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
     driver.switchTo().alert().sendKeys("Berk");
     driver.switchTo().alert().accept();
     sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
     String actualSonucYazisiElemennti=sonucYazisiElementi.getText();
     String yazilan="Berk";

     softAssert=new SoftAssert();
     softAssert.assertTrue(actualSonucYazisiElemennti.contains(yazilan));

 }
    @AfterClass
    public void tearDown() {
     softAssert.assertAll();
        driver.close();
    }
}

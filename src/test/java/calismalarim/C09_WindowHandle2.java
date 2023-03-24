package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class C09_WindowHandle2 {
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
// https://the-internet.herokuapp.com/windows adresine gidin.
      driver.get("https://the-internet.herokuapp.com/windows");
//           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actual=driver.findElement(By.xpath("//h3")).getText();
        softAssert=new SoftAssert();
        softAssert.assertTrue(actual.contains("Opening a new window"),"sayfadaki text yanlis");
//           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actual2=driver.getTitle();
        softAssert.assertTrue(actual2.contains("The Internet"));
//           ● Click Here butonuna basın.
        String handle1=driver.getWindowHandle();
          driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        ArrayList<String> windowHandles=new ArrayList<>(driver.getWindowHandles());
        //2 windowhandle degerini olusturduk
//           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        driver.switchTo().window(windowHandles.get(1));//yeni acilan tab'a gecis yaptik
        String actual3=driver.findElement(By.xpath("//h3")).getText();
        softAssert.assertEquals(actual3,"New Window");
//           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu
//           doğrulayın
        driver.switchTo().window(windowHandles.get(0));
        String actual4=driver.getTitle();
        softAssert.assertEquals(actual4,"The Internet");
    }
    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
       // driver.quit();
    }
}
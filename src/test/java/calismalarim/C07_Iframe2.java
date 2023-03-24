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
import java.util.ArrayList;
import java.util.Set;

public class C07_Iframe2 {
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
    public void iframeTest() {

//   ● Bir class olusturun: IframeTest
// https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
//           ● Bir metod olusturun: iframeTest
// “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement baslikWe=driver.findElement(By.xpath("//h3"));
        softAssert=new SoftAssert();
        softAssert.assertTrue(baslikWe.isEnabled());

//           ○ Text Box’a “Merhaba Dunya!” yazin.
        //Once Iframe'e girmeliyiz
        WebElement iframeGiris=driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(iframeGiris);
        WebElement iframe=driver.findElement(By.xpath("//p"));
        iframe.clear();
        iframe.sendKeys("Merhaba Dunya!");
        //Iframe'den cikmamiz gerekir
       // driver.switchTo().defaultContent(); en basa doner
        driver.switchTo().parentFrame();//bir ust iframe'e doner

// TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //   dogrulayin ve konsolda yazdirin.
        WebElement test=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        softAssert.assertTrue(test.isDisplayed());
        System.out.println(test.getText());
//Elemental Seleniu'a tiklayip sayfanin acildigini test edin
        //yeni tab'da acildigi icin once bulundugumuz sayfanin hashcode'unu alalim
        String page1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();
        //yeni sayfaya gecince tum hascode'lari Set'e atalim,sonrasinda acilan sayfanin hascode'unu buluruz

        //1.yol
       /* Set<String>windowHandles=driver.getWindowHandles();
        String page2="";
        for (String each:windowHandles
             ) {
            if(!each.equals(page1)){
                page2=each;
            }
        }
        driver.switchTo().window(page2);
        WebElement page2WE=driver.findElement(By.xpath("//p[@class='subheader']"));
        softAssert.assertTrue(page2WE.isDisplayed()); */
        //2.yol
        ArrayList<String> windowHandles2=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles2.get(1));
        //get(1) yeni acilan sayfanin hascode'udur
        WebElement page2WE=driver.findElement(By.xpath("//p[@class='subheader']"));
        softAssert.assertTrue(page2WE.isDisplayed());

    }

    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        driver.quit();
    }
}
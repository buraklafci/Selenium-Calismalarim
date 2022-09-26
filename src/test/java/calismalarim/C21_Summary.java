package calismalarim;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C21_Summary {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions=new Actions(driver);
        WebElement loginPortal=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));

     actions.release(loginPortal).perform();
        //3."Login Portal" a tiklayin
        actions.click(loginPortal).perform();
        //4.Diger window'a gecin
        List<String> windowHandles=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        //5."username" ve "password" kutularina deger yazdirin
        WebElement userName=driver.findElement(By.cssSelector("#text"));
        Faker faker=new Faker();
        actions.click(userName).sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
        //6."login" butonuna basin
        sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
       String mesaj= driver.switchTo().alert().getText();
        Assert.assertEquals(mesaj,"validation failed");
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(windowHandles.get(0));
        //10.Ilk sayfaya donuldugunu test edin
        WebElement ilkSayfa=driver.findElement(By.xpath("//h1[text()='My Courses & Promo Codes']"));
        Assert.assertTrue(ilkSayfa.isDisplayed());
    }
}
package calismalarim;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class C18_Faker {
    WebDriver driver;

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
    public void isEnabled() {

        //Faker class’i testlerimizi yaparken ihtiyav duydugumuz isim, soyisim, adres vb bilgiler icin fake
        //degerler uretmemize imkan tanir.
        //Faker degerler uretmek icin Faker class’indan bir obje uretir ve var olan method’lari kullaniriz.
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
        //2. “create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        //3. “firstName” giris kutusuna bir isim yazin
        Faker faker=new Faker();  //once kutuphaneye yukledik

        String email = faker.internet().emailAddress();   //email iki defa ayni olmasi icin atama yapariz

        Actions actions=new Actions(driver);
        WebElement firstName=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
        //faker kutuphanesinin name methodundan isim ve soyismi rastgele atadik
        actions.click(firstName).sendKeys(faker.name().name()).
        //4. “surname” giris kutusuna bir soyisim yazin
        sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
        //5. “email” giris kutusuna bir email yazin
        //internet methodundan emmail ve passwordu rastgele atadik
        sendKeys(Keys.TAB).sendKeys(email).
        //6. “email” onay kutusuna emaili tekrar yazin
        sendKeys(Keys.TAB).sendKeys(email).
        //7. Bir sifre girin
        sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
        //8. Tarih icin gun secin
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("02").
        //9. Tarih icin ay secin
        sendKeys(Keys.TAB).sendKeys("Şub").
        //10. Tarih icin yil secin
        sendKeys(Keys.TAB).sendKeys("1991").
        //11. Cinsiyeti secin
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement female=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male=driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(male.isSelected());
        Assert.assertFalse(female.isSelected());
        //13. Sayfayi kapatin
        driver.close();
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
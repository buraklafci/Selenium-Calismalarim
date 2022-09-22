package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C04_Basicautentication {
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
        //https://theinternet.herokuapp.com/basic_auth
        //driver.get("https://theinternet.herokuapp.com/basic_auth");
        // asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        // Html komutu :https://username:password@URL
        // Username :admin
        //password:admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        // 4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement login=driver.findElement(By.xpath("//p"));
        String actual=login.getText();
        String expected="Congratulations! You must have the proper credentials.";
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown() {
        driver.close();
    }
}

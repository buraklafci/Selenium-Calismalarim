package practice_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02 {

    // birbirine bagimli testler olusturun..
    // BeforeClass olusturup setUp ayarlarini yapin..
    // birbirine bagimli testler olusturarak;
    //     ilk once facebook'a gidin
    //     daha sonra facebook'a bagimli olarak google'a gidin,
    //     daha sonra google'a bagimli olarak amazon'a gidin
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test(dependsOnMethods = "googleTest")
    public void amazonTest(){
        driver.get("https://www.amazon.com");
    }
    @Test()
    public void facebookTest(){
    driver.get("https://www.facebook.com");
    }
    @Test(dependsOnMethods = "facebookTest")
    public void googleTest(){
        driver.get("https://www.google.com");
    }
}

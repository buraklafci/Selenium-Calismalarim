package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class C14_FileDownload_________ {
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
    // Iki tane metod oluşturun : isExist( ) ve downloadTest( )

    @Test
    public void downloadTest() throws InterruptedException {
// downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
//  https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
//  LambdaTest.txt dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();

   Thread.sleep(5000);
    }
    @Test(dependsOnMethods ="downloadTest" )
    public void isExist() {
        //Yukarda indirme islemi biraz zaman aldigi icin hata almamak icin EXPLICITWAIT kullanmaliyiz
        //????????????
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='LambdaTest.txt']")));
        // Ardından isExist( ) methodunda dosyanın başarıyla indirilip indirilmediğini test edelim


        //"C:\Users\burak\Downloads\LambdaTest.txt"
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\LambdaTest.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));  //booelan donderir
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
    }

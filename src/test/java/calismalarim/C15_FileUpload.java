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

import java.time.Duration;

public class C15_FileUpload {
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

// https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
       //"C:\Users\burak\Downloads\LambdaTest.txt"  dosya yolu
        String dosyaYolu="C:\\Users\\burak\\Downloads\\LambdaTest.txt";
//          3. chooseFile butonuna basalim
// Yuklemek istediginiz dosyayi secelim.
        //Bilgisayara mudahale edemedigimizden dosya yolunu sendKeys ile gonderdik
        driver.findElement(By.cssSelector("#file-upload")).sendKeys(dosyaYolu);
//          5. Upload butonuna basalim.
        driver.findElement(By.cssSelector("#file-submit")).click();
// “File Uploaded!” textinin goruntulendigini test edelim
        WebElement fileUploded = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploded.isDisplayed());
}
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}

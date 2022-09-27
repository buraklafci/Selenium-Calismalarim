package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C19_Summary {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void isEnabled() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement button=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(button).perform();
        //3. "Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[@class='list-alert'])[1]")).click();
        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement button2=driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.release(button2).clickAndHold(button2).perform();
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement button3=driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(button3.getText());
        //8. "Double click me" butonunu cift tiklayin
        WebElement button4=driver.findElement(By.xpath("//h2"));
        actions.doubleClick(button4).perform();
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
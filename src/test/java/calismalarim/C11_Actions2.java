package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class C11_Actions2 {
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
    public void test() {

//1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//2- Hover over Me First" kutusunun ustune gelin
        WebElement button=driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
//            3- Link 1" e tiklayin
        Actions actions=new Actions(driver);
        WebElement link1=driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.moveToElement(button).click(link1).perform();
//            4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
//5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//            6- “Click and hold" kutusuna basili tutun
        WebElement clickandhold = driver.findElement(By.xpath("//div[@id='click-box']"));
       actions.sendKeys(Keys.PAGE_DOWN).click(clickandhold).perform();
       //            7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickandhold.getText());
//            8- “Double click me" butonunu cift tiklayin
        WebElement doubleclickme = driver.findElement(By.xpath("//h2"));
        actions.doubleClick(doubleclickme).perform();
//
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
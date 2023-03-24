package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C12_Actions3 {
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

//2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

//            3- video’yu gorecek kadar asagi inin
        Actions actions=new Actions(driver);
        WebElement video=driver.findElement(By.xpath("//div[@class='render']"));
        actions.release(video).perform();

//4- videoyu izlemek icin Play tusuna basin
        WebElement iframeGiris=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframeGiris);
        WebElement playTusu=driver.findElement(By.xpath("//button[@aria-label='Oynat']"));
        actions.click(playTusu).perform();
//5- videoyu calistirdiginizi test edin
        Assert.assertFalse(playTusu.isDisplayed());
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
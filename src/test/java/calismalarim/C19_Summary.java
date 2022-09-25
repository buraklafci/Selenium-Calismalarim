package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        //3. "Link 1" e tiklayin
        //4. Popup mesajini yazdirin
        //5. Popup'i tamam diyerek kapatin
        //6. "Click and hold" kutusuna basili tutun
        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        //8. "Double click me" butonunu cift tiklayin
    }
}
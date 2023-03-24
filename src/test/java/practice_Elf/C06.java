package practice_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C06 {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        softAssert.assertAll();
        // driver.quit();
    }

    @Test
    public void alert1() throws InterruptedException {
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
         driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // web sitesini maximize yapin

        // ikinci emojiye tiklayin
        /*     1. yol           */
        /*  driver.switchTo().frame("emoojis");    */

        /*     2. yol           */
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement secondEmoji=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();
        // tüm ikinci emoji ogelerini tiklayin
        List<WebElement> emojiOgeler=driver.findElements(By.xpath("//div[@id='nature']/div/img")); //iceri girebilmek icin absolute locate kullandik
        //   /div/img yerine //img yazilabilir
        //bu sekilde butun ogelere tiklayabiliriz
        for (WebElement w:emojiOgeler
             ) {
            w.click();
        }
        System.out.println("ogeler tiklandi");
        Thread.sleep(2000);
        // emojiOgeler.stream().forEach(x->x.click()); //  ==> yukaridaki for each yerine bu lambda satiri a kullanilabilir.

        // parent iframe e geri donun
        driver.switchTo().defaultContent();

        // formu doldurun, (istediginiz metinlerle)
        List<WebElement>metinGirList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>metinler=new ArrayList<>(Arrays.asList("Bir","iframe","sorusu","bu","kadar","eglenceli","olabilir","sizce de","oyle degil mi?","",""));

        for (int i = 0; i <metinGirList.size() ; i++) {
            metinGirList.get(i).sendKeys(metinler.get(i));

        }
        Thread.sleep(4000);

        // apply butonuna basin
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
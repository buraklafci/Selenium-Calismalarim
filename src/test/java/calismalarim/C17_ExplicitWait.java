package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C17_ExplicitWait {
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
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
           WebElement textbox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        WebElement textBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabled.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(textBox.isEnabled());
    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }
}
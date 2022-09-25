package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C16_ExplicitWait {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //Iki metod icin de asagidaki adimlari test edin.
    }
    @Test
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //***********butun page icin gecerli olup bir kere koymak yeterlidir
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGone.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement ItsBack=driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(ItsBack.isDisplayed());
    }
    @Test
    public void explicitWait() {
//***********explicitWait specific'tir sadce locate edilen satir icin gecerlidir
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
       Assert.assertTrue(itsGone.isDisplayed());
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack=wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]"))));
        Assert.assertTrue(itsBack.isDisplayed());

    }
    }




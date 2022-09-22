package calismalarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C02_Ddm2 {
    WebDriver driver;
    SoftAssert softAssert;
    Select select;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }

    @Test
    public void test() {
// http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
//2.	Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
//3.	Login kutusuna “username” yazin
        WebElement loginKutusu=driver.findElement(By.xpath("//input[@id='user_login']"));
        loginKutusu.sendKeys("username");
//4.	Password kutusuna “password” yazin
        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordKutusu.sendKeys("password");
//5.	Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
//6.	Online banking menusu icinde Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text( )='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
//7.	“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
//“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm=driver.findElement(By.cssSelector("#pc_currency"));
        select=new Select(ddm);
        select.selectByIndex(6);
//“amount” kutusuna bir sayi girin
        driver.findElement(By.cssSelector("#pc_amount")).sendKeys("15000");
// “US Dollars” in secilmedigini test edin
        SoftAssert softAssert=new SoftAssert();
        WebElement button=driver.findElement(By.cssSelector("#pc_inDollars_true"));
        softAssert.assertFalse(button.isSelected());
// “Selected currency” butonunu secin
        driver.findElement(By.cssSelector("#pc_inDollars_false")).click();
// “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.cssSelector("#pc_calculate_costs")).click();
        driver.findElement(By.cssSelector("#purchase_cash")).click();
// “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin
     String actual=driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']")).getText();
     String expected="Foreign currency cash was successfully purchased.";
     softAssert.assertEquals(actual, expected);
    }
}
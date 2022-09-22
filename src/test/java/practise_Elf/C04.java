package practise_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C04 {
    WebDriver driver;

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
    public void sauceDemoTest1() {
        // Navigate to: https://www.saucedemo.com/
        driver.navigate().to("https://www.saucedemo.com/");
        // Enter the user name: standard_user
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        // Enter the password: secret_sauce
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        // Click on login button
        driver.findElement(By.cssSelector("#login-button")).click();
        //    T1 : Choose price low to high
        WebElement ddm=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        //    T2 : Verify item prices are sorted from low to high with soft Assert
        Select select=new Select(ddm);
        select.selectByVisibleText("Price (low to high)");

        String expected="PRICE (LOW TO HIGH)";

        String actual=driver.findElement(By.className("active_option")).getText();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected,"Fiyatlar istenildigi gibi siralanmistir");
        softAssert.assertAll();
    }
    @Test
    public void sauceDemoTest2() {
        // Navigate to: https://www.saucedemo.com/
        driver.navigate().to("https://www.saucedemo.com/");
        // Enter the user name: standard_user
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        // Enter the password: secret_sauce
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        // Click on login button
        driver.findElement(By.cssSelector("#login-button")).click();
        //    T1 : Choose price low to high
        WebElement ddm=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        //    T2 : Verify item prices are sorted from low to high with soft Assert
        Select select=new Select(ddm);
        select.selectByIndex(2);

       List<WebElement> fiyatlar=driver.findElements(By.className("inventory_item_price"));
        ArrayList<Double>fiyatlarDouble=new ArrayList<>();
        for (WebElement fiyat:fiyatlar
             ) {
            //String fiyatStr=fiyat.getText().replaceAll("$","");
            String fiyatStr=fiyat.getText().replaceAll("\\D","");
            fiyatlarDouble.add(Double.parseDouble(fiyatStr));
        }
        ArrayList<Double> kontrolList=new ArrayList<>(fiyatlarDouble);
        Collections.sort(kontrolList);

        Assert.assertEquals(kontrolList,fiyatlarDouble);
    }
}
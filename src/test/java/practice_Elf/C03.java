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

import java.time.Duration;
import java.util.List;

public class C03 {

    // go to url: https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    // --> Task1 Find Dropdown on Multi Selection
    // --> Task2 Find all Dropdown Elements on page
    // --> Task3 printout Dropdown Elements' number
    // --> Task4 choose Dropdown elements and printout dropdown elements' name Multi Selection
    // --> Task5 check until choise 6' Multi Selection
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public void tearDown(){
       // driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        // --> Task1 Find Dropdown on Multi Selection
        driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
        // --> Task2 Find all Dropdown Elements on page
        List<WebElement>dropList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
        // --> Task3 printout Dropdown Elements' number
        System.out.println("dropListteki elementlerin sayisi==> "+dropList.size());//dropListteki elementlerin sayisi==> 45
        // --> Task4 choose Dropdown elements and printout dropdown elements' name Multi Selection
        for (int i = 0; i < dropList.size() ; i++) {
            String text=dropList.get(i).getText();
            System.out.println("text = " + text);
            if (!text.isEmpty()){
                dropList.get(i).click();
            }
            // --> Task5 check until choise 6' Multi Selection
            if (text.equals("choice 6")){
                dropList.get(i).click();

                break;
            }

        }

    }
}

package practise_Mhmt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class C01 {

    @Test
    public void sauceDemoTest1() {
        //pom.xml dosyasi oldugunu dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String yol="C:\\Users\\burak\\IdeaProjects\\SeleniumNewProject-TestNG-Burak\\pom.xml";
        softAssert.assertTrue(Files.exists(Paths.get(yol)));
    }

}

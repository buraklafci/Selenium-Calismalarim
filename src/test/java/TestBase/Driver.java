package TestBase;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    // testlerimizi calistirdigimizda her seferinde yeni driver oludturdugu icin
// her test methodu icin yeni bir pencere (driver) aciyor
// eger driver'a bir deger atanmamissa yani driver == null ise
// bir kere driver'i calistir diyerek bir kere if icini calistiracak
// ve driver artik bir kere calistigi icin ve deger atandigi icin null olmayacak
// ve direk return edecek ve diger testlerimiz ayni pencere (driver) uzerinde calisacak
    static WebDriver driver;

public static WebDriver getDriver() {
    if (driver == null) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    return driver;
}

public static void closeDriver() {
    if (driver != null) { //driver'a deger atanmissa kapat.
        driver.close();
        driver = null; // kapatmayi garanti altina aliyor..yoksa exception firlatir
    }

}

public static void quitDriver() {


        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

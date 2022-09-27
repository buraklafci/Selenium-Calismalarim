package calismalarim;

import TestBase.BeforeClassAfterClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C23_ScreenshotWE extends BeforeClassAfterClass {
    @Test
    public void testName() throws IOException {
        //https://hepsiburada.com gidin
        driver.get("https://hepsiburada.com");
        //Samsung aratin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung", Keys.ENTER);


        //Samsung telefonlarin oldugu ekranda cikan ilk telefonun SS'ini alin
       WebElement ilkTelefonSS=driver.findElement(By.cssSelector("#i0"));
       //asagiya inmek icin jse kullanalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",ilkTelefonSS);

       String date=new SimpleDateFormat("yymmddhhmmss").format(new Date());

       File dosyaYolu=new File("target/SS/ilkResim"+date+".jpeg");
       File geciciPath=ilkTelefonSS.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciPath,dosyaYolu);




    }
}

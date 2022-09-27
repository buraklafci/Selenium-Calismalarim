package calismalarim;

import TestBase.BeforeClassAfterClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class C22_ScreenshotTumSayfa extends BeforeClassAfterClass {
    @Test
    public void hepsiBurada() throws IOException {
        //https://hepsiburada.com gidin
        driver.get("https://hepsiburada.com");
        //Samsung aratin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Samsung", Keys.ENTER);

        //yenisayfanin acildigini gordukten sonra ss almak icin
         WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@class='searchResultSummaryBar-CbyZhv5896ASVcYBLKmx']"))));
        //ilk satirdaki telefonu gormek icin PAGE_DOWN yapalim
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //Samsung telefonlarin oldugu ekranda cikan ilk satirdaki telefonlarin SS'ini alin
        //Ss icin TakesScreenshot classina driver degerini atayalim
        TakesScreenshot tss= (TakesScreenshot) driver;
        //dosyayi kopyalayacagimiz path olusturalim
        //her zaman ayni ismin uzerine yenisini yazdirmamasi icin tarih atalim
        String date=new SimpleDateFormat("yymmddhhmmss").format(new Date());
        File dosyaYolu=new File("target/SS/hepsiburada"+date+".jpeg");

        //getScreenshot ile ekranin goruntusu aldigimiz resmi gecici dosyaya atalim
        File geciciPath=tss.getScreenshotAs(OutputType.FILE);

        //gecici path'i copyFile methoduyla kendi path'imize aktaralim
        FileUtils.copyFile(geciciPath,dosyaYolu);
    }
}

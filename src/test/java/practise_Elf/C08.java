package practise_Elf;

import TestBase.BeforeClassAfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C08 extends BeforeClassAfterClass {
    /*
@DataProvider bir TestNG annotation'idir
Dolayisiyla sadece TestNG ile kullanilir.
Veri saglamak icin kullanilir.
DDT(Data Driven Test) yapilir
Cucumber'daki Scenario Outline ile ayni isleve sahiptir
 */
    // http://amazon.com adresine gidiniz
    // araba, ev, anahtarlik, ayakkabi, gomlek kelimelerini arayiniz


    @Test(dataProvider = "urunler")
    public void amazonTest(String kelime) {
        driver.get("https://www.amazon.com");
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(kelime + Keys.ENTER);
    }

    @DataProvider(name = "urunler")
    public Object[][] getUrunler() {
        Object[][] urunler = {{"araba"}, {"ev"}, {"anahtarlik"}, {"ayakkabi"}, {"gomlek"}};
        return urunler;
    }
    // https://www.gittigidiyor.com/ adresine gidiniz
    // java, javascript ve python kelimelerini arayiniz

    @Test(dataProvider="aranacakUrunler")
    public void gittigidiyorTesti(String aranacakUrunler) {
        driver.get("https://gittigidiyor.com");
        driver.findElement(By.xpath("//input[@placeholder='Keşfetmeye Bak']")).sendKeys(aranacakUrunler + Keys.ENTER);
    }

    @DataProvider
    public Object[][] aranacakUrunler(){
        String data[][] = {{"java"}, {"javascript"}, {"python"}};
        return data;
    }
}
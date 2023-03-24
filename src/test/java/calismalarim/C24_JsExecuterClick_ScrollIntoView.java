package calismalarim;

import TestBase.BeforeClassAfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class C24_JsExecuterClick_ScrollIntoView extends BeforeClassAfterClass {
    @Test
    public void test() throws InterruptedException {

    //hepsiburada sitesine gidin
    driver.get("https://hepsiburada.com");
    //Süper Fiyat, Süper Teklif'ine tiklayin

        WebElement superFiyatWE=driver.findElement(By.xpath("//img[@alt='Süper Fiyat, Süper Teklif']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",superFiyatWE);
        jse.executeScript("arguments[0].click();",superFiyatWE);

}
}













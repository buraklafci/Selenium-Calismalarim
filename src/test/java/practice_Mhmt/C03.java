package practice_Mhmt;

import TestBase.BeforeClassAfterClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03 extends BeforeClassAfterClass {
    @Test
    public void test01() {
// 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
// 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.cssSelector("#button1")).click();

// 3. Açılır metni alın
        String actualText=driver.switchTo().alert().getText();

// 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        Assert.assertEquals(actualText,"I am an alert box!");
// 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();
    }
}

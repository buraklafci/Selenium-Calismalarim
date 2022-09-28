package practise_Mhmt;

import TestBase.BeforeClassAfterClass;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class C02 extends BeforeClassAfterClass {
    @Test
    public void testName() {


    // ...Exercise3...
// go to url : https://www.techlistic.com/p/selenium-practice-form.html
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
      //  driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
//fill the firstname
        WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        actions.click(firstname).sendKeys("Berk").
//fill the lastname
        sendKeys(Keys.TAB).sendKeys("Karanfil").
//check the gender
        sendKeys(Keys.TAB).click( driver.findElement(By.cssSelector("#sex-0"))).
//check the experience
        sendKeys(Keys.TAB).click(driver.findElement(By.cssSelector("#exp-0"))).
//fill the date
        sendKeys(Keys.TAB).sendKeys("30.01.2022").
//choose your profession -> Automation Tester
        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(driver.findElement(By.cssSelector("#profession-1")),Keys.ENTER).
//choose your tool -> Selenium Webdriver
        sendKeys(Keys.TAB). sendKeys(Keys.TAB). sendKeys(Keys.TAB).sendKeys(driver.findElement(By.cssSelector("#tool-2")),Keys.ENTER).perform();
//choose your continent -> Antartica
        WebElement ddmContinent=driver.findElement(By.cssSelector("#continents"));
        Select select=new Select(ddmContinent);
        select.selectByVisibleText("Antartica");
//choose your command  -> Browser Commands
        WebElement browserCommands = driver.findElement(By.xpath("//*[@id='selenium_commands']"));
        select = new Select(browserCommands);
        select.selectByVisibleText("Browser Commands");
//click submit button
        driver.findElement(By.cssSelector("#submit")).click();
}
}
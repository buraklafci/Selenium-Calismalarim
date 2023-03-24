package practice_Mhmt;

import TestBase.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerokuTetPage;

public class C06 {
   HerokuTetPage herokuTetPage;
   Actions actions;
    @Test
    public void testName() {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get(" https://testpages.herokuapp.com/styled/events/javascript-events.html");
        //Click all the buttons and verify they are all clicked
       herokuTetPage=new HerokuTetPage();
       actions =new Actions(Driver.getDriver());
       herokuTetPage.onBlur.click();
       herokuTetPage.onClick.click();
       herokuTetPage.onClick.click();
       actions.contextClick(herokuTetPage.onContextMenu).
      doubleClick(herokuTetPage.onDoubleClick).
      click(herokuTetPage.onFocus).
      sendKeys(herokuTetPage.onKeyDown, Keys.ENTER).
       sendKeys(herokuTetPage.onKeyUp,Keys.ENTER).
       sendKeys(herokuTetPage.onKeyPress,Keys.ENTER).
       moveToElement(herokuTetPage.onMouseOver).
       moveToElement(herokuTetPage.onMouseLeave).moveToElement(herokuTetPage.onMouseDown).
        click(herokuTetPage.onMouseDown).perform();

        Assert.assertTrue(herokuTetPage.eventTriggerred.size() == 11);
    }
}

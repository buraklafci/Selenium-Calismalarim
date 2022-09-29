package practice_Mhmt;

import TestBase.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;

public class C04 {
    // Go to URL http://www.htmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.
    @Test
    public void test01() {
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage dhtmlgoodiesPage=new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dhtmlgoodiesPage.oslo,dhtmlgoodiesPage.norway).
        dragAndDrop(dhtmlgoodiesPage.stockholm,dhtmlgoodiesPage.sweden).
        dragAndDrop(dhtmlgoodiesPage.washington,dhtmlgoodiesPage.unitedStates).
        dragAndDrop(dhtmlgoodiesPage.copenhagen,dhtmlgoodiesPage.denmark).
        dragAndDrop(dhtmlgoodiesPage.seoul,dhtmlgoodiesPage.southKorea).
        dragAndDrop(dhtmlgoodiesPage.rome,dhtmlgoodiesPage.italy).
        dragAndDrop(dhtmlgoodiesPage.madrid,dhtmlgoodiesPage.spain).perform();

        Driver.closeDriver();

        /*
-Frameworkler buyudukce yeni classlar yeni test methodlari yeni webelementler olusturdukca
icinden cikilmaz, anlasilmaz, tekrar bakimi yapilamaz, guncellemesi cok zor hatta imkansiz bir hal alir.
-Uzmanlar reusable, maintainable, rahat manipule edilebilir bir framework icin bir design pattern olarak
POM (page object model)'de karar vermisler.
-Olmazsa olmazlar
        1) Driver class
        2) Page class
        3) Test class
           Utilities
-Aradigimiz bir web elementi ya da bir methodu kolaylikla bulabilmek ve guncelleyebilmek icin javadan
ogrenmis oldugumuz OOP Concept Selenium ile page object modelde birlestirilmis oluyor.

 */
    }
}

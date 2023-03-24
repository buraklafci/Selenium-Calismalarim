package practice_Mhmt;

import TestBase.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;

public class C04 {
   // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.
    @Test
    public void test01() {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());
//        actions.dragAndDrop(dhtmlgoodiesPage.oslo,dhtmlgoodiesPage.norway).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.stockholm,dhtmlgoodiesPage.sweden).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.washington,dhtmlgoodiesPage.unitedStates).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.copenhagen,dhtmlgoodiesPage.denmark).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.seoul,dhtmlgoodiesPage.southKorea).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.rome,dhtmlgoodiesPage.italy).perform();
//        actions.dragAndDrop(dhtmlgoodiesPage.madrid,dhtmlgoodiesPage.spain).perform();
        actions.dragAndDrop(dhtmlgoodiesPage.oslo,dhtmlgoodiesPage.norway).
                dragAndDrop(dhtmlgoodiesPage.stockholm,dhtmlgoodiesPage.sweden).
                dragAndDrop(dhtmlgoodiesPage.washington,dhtmlgoodiesPage.unitedStates).
                dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark).
                dragAndDrop(dhtmlgoodiesPage.seoul,dhtmlgoodiesPage.southKorea).
                dragAndDrop(dhtmlgoodiesPage.rome,dhtmlgoodiesPage.italy).
                dragAndDrop(dhtmlgoodiesPage.madrid,dhtmlgoodiesPage.spain).perform();
        Driver.closeDriver();
        /** Frameworkler büyüdükçe yeni classlar yeni test methodları yeni webelementler olusturdukça içinden çıkılmaz
         * anlasılmaz, tekrar bakımı yapılamaz, güncellemesi çok zor hatta imkansız bir hal alır
         *
         * uzmanlar reusable maintainable, rahat manipule edilebilir bir framwork için bir design pattern olarak
         * POM PAGE OBJECT MODEL de karar vermisler
         * olmazsa olmazlar
         * 1) driver class
         * 2) PAGE class
         * 3) test class
         * utilities
         *
         * Aradığımız bir web elementi yada bir metohdu kolaylıkla bulabilmek ve güncelleyebilmek için
         * javadan öğrenmis olduğumuz oop concept selenium ile page object model de birlesitirilmis oluyuor
         *
         */
    }
}

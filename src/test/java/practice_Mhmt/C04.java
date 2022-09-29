package practice_Mhmt;

import TestBase.Driver;
import org.testng.annotations.Test;

public class C04 {
    // Go to URL http://www.htmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.
    @Test
    public void test01() {
        Driver.getDriver().get("http://www.htmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

    }
}

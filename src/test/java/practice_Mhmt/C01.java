package practice_Mhmt;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01 {

    @Test
    public void sauceDemoTest1() {
        //pom.xml dosyasi oldugunu dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String yol="C:\\Users\\burak\\IdeaProjects\\SeleniumNewProject-TestNG-Burak\\pom.xml";
        softAssert.assertTrue(Files.exists(Paths.get(yol)));
    }

}

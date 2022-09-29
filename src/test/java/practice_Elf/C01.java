package practice_Elf;

import org.testng.annotations.Test;

public class C01 {
    /*
TestNg (default) olarak @Test methodlarini alfabetik siraya gore run eder..(Yukaridan asagiya degil)
priority anotation Testlere oncelik vermek icin kullanilir, kucuk olan numara daha once calisir.
priority-> default degeri 0'dir
priority:  TestNG testlerinde, testler konsola alfabetik siraya gore yazdirilir.

enabled= false methodu: Testi gormezden gelmek icin @Test in yanina    '(enabled=false)'  fonksiyonunu kullaniriz.
 */
    @Test(priority = 3000)
    public void b() {
        System.out.println("a");
    }

    @Test(priority = 2001,enabled = false) //JUnit'te @Ignore yerine enabled=false yapilir
    public void a() {
        System.out.println("a");
    }
    @Test(priority = -2000)
    public void c() {
        System.out.println("c");
    }
    @Test
    public void test1() {
        System.out.println("test1....");
    }
    @Test
    public void test2() {
        System.out.println("test2....");
    }
    @Test
    public void test3() {
        System.out.println("test3....");
    }
    @Test(enabled = false)
    public void test4() {
        System.out.println("test4....");
    }
    @Test(enabled = false)
    public void test5() {
        System.out.println("test5....");
    }
    @Test
    public void test6() {
        System.out.println("test6....");
    }

}

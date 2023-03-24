package practice_Mhmt;

import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;

import java.util.List;

public class C07 {
    // 1. Tarayıcıyı başlat
// 2. 'http://automationexercise.com' url'sine gidin
// 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
// 4. 'Ürünler' butonuna tıklayın
// 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
// 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
// 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
// 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın
    SearchProductPage searchProductPage;
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void searchProductPage() throws InterruptedException {

        // 1. Tarayıcıyı başlat
        // 2. 'http://automationexercise.com' url'sine gidin

        Driver.getDriver().get("http://automationexercise.com");
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String homeUrl ="https://automationexercise.com/";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),homeUrl);

        searchProductPage = new SearchProductPage();
        // 4. 'Ürünler' butonuna tıklayın
        searchProductPage.prouducts.click();

        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(searchProductPage.allProductTitle.isDisplayed());
//        String productPageUrl = "https://automationexercise.com/products";
//        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),productPageUrl);

        // 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
        searchProductPage.searchBox.sendKeys("blue");
        searchProductPage.searchButton.click();
//        actions.click( searchProductPage.searchButton).click().perform();
        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
        Assert.assertTrue(searchProductPage.searchedProductTitle.isDisplayed());
        List<WebElement> ürünlistesi = searchProductPage.searchedProductList;
//        for (WebElement w:   ürünlistesi      ) {
//            Assert.assertTrue(w.isDisplayed());
//            Thread.sleep(500);
//        }
        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın

        actions.click(searchProductPage.viewProduct).perform();
        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());
    }
}


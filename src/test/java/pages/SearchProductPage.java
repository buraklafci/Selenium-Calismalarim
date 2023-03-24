package pages;
import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
    public class SearchProductPage {
        public SearchProductPage (){
            PageFactory.initElements(Driver.getDriver(),this);
        }
        @FindBy (xpath = "//*[text()=' Products']")
        public WebElement prouducts;
        @FindBy (xpath = "//*[text()='All Products']")
        public WebElement allProductTitle;
        @FindBy (xpath = "//input[@id='search_product']")
        public WebElement searchBox;
        @FindBy (xpath = "//button[@id='submit_search']")
        public WebElement searchButton;
        @FindBy (xpath = "(//h2)[3]")
        public WebElement searchedProductTitle;
        @FindBy (linkText = "View Product")
        public WebElement viewProduct;
        @FindBy (xpath = "(//h2)[3]")
        public WebElement blueTop;
        @FindBy (xpath = "//div[@class='product-image-wrapper']")
        public List<WebElement> searchedProductList;
    }


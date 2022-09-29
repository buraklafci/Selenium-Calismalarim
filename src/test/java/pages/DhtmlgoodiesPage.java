package pages;

import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DhtmlgoodiesPage {
    DhtmlgoodiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(css = "#box1")
    public WebElement oslo;
    @FindBy(css = "#box2")
    public WebElement stockholm;
    @FindBy(css = "#box3")
    public WebElement washington;
    @FindBy(css = "#box4")
    public WebElement copenhagen;
    @FindBy(css = "#box5")
    public WebElement seoul;
    @FindBy(css = "#box6")
    public WebElement rome;
    @FindBy(css = "#box7")
    public WebElement madrid;


}

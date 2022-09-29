package pages;

import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DhtmlgoodiesPage {
  public  DhtmlgoodiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //     --baskentler
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

    //countries--ulkeler
    @FindBy(css = "#box106")
    public WebElement italy;
    @FindBy(css = "#box107")
    public WebElement spain;
    @FindBy(css = "#box101")
    public WebElement norway;
    @FindBy(css = "#box104")
    public WebElement denmark;
    @FindBy(css = "#box105")
    public WebElement southKorea;
    @FindBy(css = "#box102")
    public WebElement sweden;
    @FindBy(css="box103")
    public WebElement unitedStates;


}

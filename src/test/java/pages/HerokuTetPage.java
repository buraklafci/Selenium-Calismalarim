package pages;

import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HerokuTetPage {
   public HerokuTetPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[@id='onblur']")
    public WebElement onBlur;
    @FindBy (xpath = "//button[@id='onclick']")
    public WebElement onClick;
    @FindBy (xpath = "//button[@id='oncontextmenu']")
    public WebElement onContextMenu;
    @FindBy (xpath = "//button[@id='ondoubleclick']")
    public WebElement onDoubleClick;
    @FindBy (xpath = "//button[@id='onfocus']")
    public WebElement onFocus;
    @FindBy (xpath = "//button[@id='onkeydown']")
    public WebElement onKeyDown;
    @FindBy (xpath = "//button[@id='onkeyup']")
    public WebElement onKeyUp;
    @FindBy (xpath = "//button[@id='onkeypress']")
    public WebElement onKeyPress;
    @FindBy (xpath = "//button[@id='onmouseover']")
    public WebElement onMouseOver;
    @FindBy (xpath = "//button[@id='onmouseleave']")
    public WebElement onMouseLeave;
    @FindBy (xpath = "//button[@id='onmousedown']")
    public WebElement onMouseDown;

    @FindBy (xpath = "//*[text()='Event Triggered']")
    public List<WebElement> eventTriggerred;
}

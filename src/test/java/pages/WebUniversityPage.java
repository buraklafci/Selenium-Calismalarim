package pages;

import TestBase.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebUniversityPage {
  public   WebUniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//input[@type='text']")
    public  WebElement adNewTodo;

  @FindBy (xpath = "//li")
    public List<WebElement> toDo;

  @FindBy(xpath = "//*[@class='fa fa-trash']")
  public List<WebElement> deleteButtons;




}
